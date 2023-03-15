package ai.lentra.modal;

import ai.lentra.modal.commitment.CommitmentDetails;
import ai.lentra.modal.contact_info.ContactDetails;
import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import ai.lentra.modal.expenses.Expenses;
import ai.lentra.modal.famil_info.FamilyDetails;
import ai.lentra.modal.personal_info.PersonalDetails;
import ai.lentra.modal.residence.ResidenceDetails;
import ai.lentra.modal.summary.Summary;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicantDetailsHistory {
    @Id
    private long applicantId;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "summary_details", referencedColumnName = "applicant_id")
    private Summary summary;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "commitments", referencedColumnName = "applicant_id")
    private CommitmentDetails commitments;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "family_details", referencedColumnName = "applicant_id")
    private FamilyDetails familyDetails;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employment_details", referencedColumnName = "applicant_id")
    private OfficeSelfEmployment officeSelfEmployment;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contact_details", referencedColumnName = "applicant_id")
    private ContactDetails contactInformation;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "personal_details", referencedColumnName = "applicant_id")
    private PersonalDetails personalDetails;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "residence_details", referencedColumnName = "applicant_id")
    private ResidenceDetails residences;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "expenses", referencedColumnName = "applicant_id")
    private Expenses expenses;

}
