package ai.lentra.dto.lookups;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data

public class SimCardType {

    private long id ;

    @Pattern(regexp = "^[a-zA-Z]$")
    private String type;
    private boolean isActive;



}
