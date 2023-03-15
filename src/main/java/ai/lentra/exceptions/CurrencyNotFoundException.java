package ai.lentra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CurrencyNotFoundException extends RuntimeException{

    public CurrencyNotFoundException(String message){
        super(message);
    }

}
