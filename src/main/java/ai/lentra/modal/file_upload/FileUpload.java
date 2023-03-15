package ai.lentra.modal.file_upload;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Data

public class FileUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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