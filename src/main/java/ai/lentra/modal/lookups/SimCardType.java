package ai.lentra.modal.lookups;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class SimCardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

//    @Pattern(regexp = "^[a-zA-Z]$")
    private String type;
    private boolean isActive;



}
