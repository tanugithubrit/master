package ai.lentra.dto.responses;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class ResponseDataDTO {
    private String Status;
    private HttpStatus code;
    private String message;
    private Object data;
}
