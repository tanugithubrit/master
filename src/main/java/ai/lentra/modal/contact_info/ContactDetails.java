package ai.lentra.modal.contact_info;

import ai.lentra.modal.lookups.SimCardType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ContactDetails {

    @Id
    @Column(name = "applicant_id", nullable = false)
    private long applicantId;
    @Pattern(regexp = "^\\d{10,13}$",message = "Mobile number should contain 10 to 13 digits only")
    private String mobileNumber;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]{1,64}@[a-zA-Z0-9.-]{1,63}\\.[a-zA-Z]{2,}$",message = "Email must be well formed")
    private String personalEmail;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "sim_card_type")
    private String simType;

    private boolean mobileNumberVerified;

    @Pattern(regexp = "^\\d{10,13}$",message = "Phone number should contain 10 to 13 digits only")
    private String phoneNumber;

    private boolean phoneNumberVerified;
    private boolean personalEmailVerified;
    private boolean contDomainCheck;
    private boolean registeredWithBank;


}