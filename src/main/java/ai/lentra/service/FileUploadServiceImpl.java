package ai.lentra.service;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.file_upload.FileUpload;
import ai.lentra.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileUploadServiceImpl implements FileUploadService{

//Defining the image    format  to be uploaded
    private static final List<String> ALLOWED_IMAGE_TYPES = Arrays.asList("jpeg", "jpg", "png", "gif", "tiff", "bmp");
    //defining the video format to  be uploaded
    private static final List<String> ALLOWED_VIDEO_TYPES = Arrays.asList("mp4", "mov", "wmv", "flv", "avi", "avchd");
//defining the document formats
    private static final List<String> ALLOWED_DOCUMENT_TYPES = Arrays.asList("pdf", "xlsx", "docx", "rar");


    // setting up the max upload size
    private static final long MAX_FILE_SIZE = 100 * 1024 * 1024; // 100 MB
    @Autowired
    private FileUploadRepository fileUploadRepository;



    public ResponseEntity<?> uploadFilesOnline(Long applicantId, MultipartFile[] multipartFiles, String latitude, String longitude) {

        List<String> errorMessages = new ArrayList<>();

        List<FileUpload> fileUploads = Arrays.stream(multipartFiles)
                .peek(file -> {
                    String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                    String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

                    // Check file type prevent the false file upload
                    if (!( ALLOWED_DOCUMENT_TYPES.contains(fileExtension) ||ALLOWED_IMAGE_TYPES.contains(fileExtension) || ALLOWED_VIDEO_TYPES.contains(fileExtension)) ) {
                        errorMessages.add(fileName + ": Only images allowed with the following extensions "
                                + StringUtils.arrayToCommaDelimitedString(
                                ALLOWED_IMAGE_TYPES.toArray(new String[ALLOWED_IMAGE_TYPES.size()]))
                                + ", Only Videos allowed with the following extensions "
                                + StringUtils.arrayToCommaDelimitedString(
                                ALLOWED_VIDEO_TYPES.toArray(new String[ALLOWED_VIDEO_TYPES.size()]))
                                + ", Only Documents allowed with the following extensions "
                                + StringUtils.arrayToCommaDelimitedString(
                                ALLOWED_DOCUMENT_TYPES.toArray(new String[ALLOWED_DOCUMENT_TYPES.size()]))
                        );

                    }

                    // Check file size is not larger than MAX_FILE_SIZE (100MB)
                    if (file.getSize() > MAX_FILE_SIZE) {
                        errorMessages.add(fileName + ": File size must be less than or equal to 100 MB");
                    }
                })
                .filter(file -> file.getSize() <= MAX_FILE_SIZE)
                .map(file -> {
                    try {
                        FileUpload fileUpload = new FileUpload();
                        fileUpload.setFilename(applicantId + "_" + file.getOriginalFilename());
                        fileUpload.setData(file.getBytes());
                        fileUpload.setContentType(file.getContentType());
                        fileUpload.setApplicantId(applicantId);
                        fileUpload.setLatitude(latitude);
                        fileUpload.setLongitude(longitude);
                        fileUpload.setTimestamp(Instant.now());
                        return fileUpload;
                    } catch (IOException e) {
                        errorMessages.add("Error uploading file: " + file.getOriginalFilename());
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if ((longitude == null && latitude == null) || longitude == null || latitude == null) {
            errorMessages.add("Location must be a valid latitude and longitude");
        }

        if (!errorMessages.isEmpty()) {
            List<ResponseDTO> errros = errorMessages.stream().map(err -> {
                ResponseDTO response = new ResponseDTO();
                response.setCode(HttpStatus.BAD_REQUEST);
                response.setMessage(err);
                response.setStatus("Upload Failed");
                return response;
            }).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errros);
        } else {
            fileUploadRepository.saveAll(fileUploads);
            return ResponseEntity.ok("All files uploaded successfully along with the geoTag latitude: " + latitude + " longitude: " + longitude);
        }
    }

@Override
    public ResponseEntity<?> downloadFile(Long applicantId) throws IOException {
        // retrieve list of files from database
        List<FileUpload> files = fileUploadRepository.findByApplicantId(applicantId);

        // create a temporary file to hold the zip archive to avoid unecessary file closing
        File zipFile = File.createTempFile("files", ".zip");

        // creating a new ZipOutputStream and open it
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOut.setLevel(Deflater.DEFAULT_COMPRESSION);

        // loop through each file, add it to the zip archive, and close the input stream
        for (FileUpload file : files) {
            zipOut.putNextEntry(new ZipEntry(file.getFilename()));
            zipOut.write(file.getData());
            zipOut.closeEntry();
        }
        if (zipOut!=null) {
            zipOut.close();
        }
        // close the zip output stream
        zipOut.close();

        // create a resource from the zip file and return it in a ResponseEntity
        FileSystemResource resource = new FileSystemResource(zipFile);
//        Headers for a Zip archive
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "files.zip");
        if (files.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No file for the specified applicant \n "+"applicant Id: "+applicantId);
        }

//returning the resource with custom content and custom headers for zip file format
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);


    }
    @Override
    public ResponseEntity<?> getFilebyNameAndApplicantId(Long applicantId, String filename) throws IOException {
        List<FileUpload> files = fileUploadRepository.findByApplicantId(applicantId);
        for (FileUpload file : files) {

            MediaType mediaType = MediaType.valueOf(file.getContentType());

        }


        if (files.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No file present with name " + filename +" for the applicant " +applicantId);
        }

        File temp= new File(filename);
        FileOutputStream fos = new FileOutputStream(temp);
        for (FileUpload file : files) {
            if (file.getFilename().contains(applicantId+"_"+filename)) {
                fos.write(file.getData());
                break;
            }
        }
        fos.close();
        Path path = Paths.get(temp.getAbsolutePath());

        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+filename+"_"+applicantId);
        headers.add(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(temp.length()));

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);

    }

//to get file name extension
    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex < 0) {
            return "";
        } else {
            return fileName.substring(dotIndex + 1);
        }
    }

@Override
    public ResponseEntity<?> uploadFilesOffline(Long applicantId, MultipartFile[] files)
    {

        List<String> errorMessages = new ArrayList<>();

        List<FileUpload> fileUploads = Arrays.stream(files)
                .peek(file -> {
                    String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                    String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

                    // Check file type prevent the false file upload
                    if (!( ALLOWED_DOCUMENT_TYPES.contains(fileExtension) ||ALLOWED_IMAGE_TYPES.contains(fileExtension) || ALLOWED_VIDEO_TYPES.contains(fileExtension))) {
                        errorMessages.add(fileName + ": Only images allowed with the following extensions  "
                                + StringUtils.arrayToCommaDelimitedString(
                                ALLOWED_IMAGE_TYPES.toArray(new String[ALLOWED_IMAGE_TYPES.size()]))
                                + ", Only Videos allowed with the following extensions "
                                + StringUtils.arrayToCommaDelimitedString(
                                ALLOWED_VIDEO_TYPES.toArray(new String[ALLOWED_VIDEO_TYPES.size()]))
                                + ", Only Documents allowed with the following extensions "
                                + StringUtils.arrayToCommaDelimitedString(
                                ALLOWED_DOCUMENT_TYPES.toArray(new String[ALLOWED_DOCUMENT_TYPES.size()]))
                        );
                    }

                    // Check file size is not larger than MAX_FILE_SIZE (100MB)
                    if (file.getSize() > MAX_FILE_SIZE) {
                        errorMessages.add(fileName + ": File size must be less than or equal to 100 MB");
                    }
                })
                .filter(file -> file.getSize() <= MAX_FILE_SIZE)
                .map(file -> {
                    try {
                        FileUpload fileUpload = new FileUpload();
                        fileUpload.setFilename(applicantId + "_" + file.getOriginalFilename());
                        fileUpload.setData(file.getBytes());
                        fileUpload.setContentType(file.getContentType());
                        fileUpload.setApplicantId(applicantId);
                        fileUpload.setTimestamp(Instant.now());
                        return fileUpload;
                    } catch (IOException e) {
                        errorMessages.add("Error uploading file: " + file.getOriginalFilename());
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (!errorMessages.isEmpty()) {
            List<ResponseDTO> errors = errorMessages.stream().map(err -> {
                ResponseDTO response = new ResponseDTO();
                response.setCode(HttpStatus.BAD_REQUEST);
                response.setMessage(err);
                response.setStatus("Upload Failed");
                return response;
            }).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        } else {
            fileUploadRepository.saveAll(fileUploads);
            return ResponseEntity.ok("All files uploaded successfully ");
        }
    }
}
