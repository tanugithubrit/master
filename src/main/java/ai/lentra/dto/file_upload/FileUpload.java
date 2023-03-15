package ai.lentra.dto.file_upload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class FileUpload {


    private Long id;

    private long applicantId;
    private String filename;
    private String contentType;
//to accept geolocation

    private String latitude;

    private String longitude;
//to accept timestamp
    @CreatedDate
    private Instant timestamp;
    private byte[] data;
    public FileUpload() {}

    public FileUpload(Long id, long applicantId, String filename, String contentType, byte[] data) {
        this.id = id;
        this.applicantId = applicantId;
        this.filename = filename;
        this.contentType = contentType;
        this.data = data;
    }

}