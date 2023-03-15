package ai.lentra.commons;

import ai.lentra.dto.responses.ResponseDTO;
import org.springframework.http.HttpStatus;

public class ResponeGen {

    public static ResponseDTO getResponse(int code ,String message,String status) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(message);
        responseDTO.setCode(HttpStatus.valueOf(code));
        responseDTO.setStatus(status);
        return responseDTO;
    }
}
