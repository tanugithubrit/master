package ai.lentra.dto.contact_info;

import ai.lentra.modal.lookups.SimCardType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.validation.constraints.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class ContactDetailsDTO {


    private long applicantId;
    @Pattern(regexp = "^\\d{10,13}$",message = "Mobile number should contain 10 to 13 digits only")
    private String mobileNumber;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]{1,64}@[a-zA-Z0-9.-]{1,63}\\.[a-zA-Z]{2,}$",message = "Email must be well formed")
    private String personalEmail;

//    @Pattern(regexp = "^[a-zA-Z0-9]{0,255}",message = "Sim type should contain only letters")
    private String simType;

    private boolean mobileNumberVerified;

    @Pattern(regexp = "^\\d{10,13}$",message = "Phone number should contain 10 to 13 digits only")
    private String phoneNumber;

    private boolean phoneNumberVerified;
    private boolean personalEmailVerified;
    private boolean domainCheck;
    private boolean registeredWithBank;


}