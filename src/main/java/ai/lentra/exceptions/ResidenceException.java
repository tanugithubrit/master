package ai.lentra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class ResidenceException extends RuntimeException{
    public ResidenceException(String message){
        super(message);
    }
}
