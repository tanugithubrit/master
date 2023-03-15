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

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ApplicantDetails {
	@Id
	@Column(name = "applicant_id")
	private long applicantId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "summary", referencedColumnName = "applicant_id")
	private Summary summary;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "commitments", referencedColumnName = "applicant_id")
	private CommitmentDetails commitments;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "family_details", referencedColumnName = "applicant_id")
	private FamilyDetails familyDetails;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employment_details", referencedColumnName = "applicant_id")
	private OfficeSelfEmployment officeSelfEmployment;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_details", referencedColumnName = "applicant_id")
	private ContactDetails contactInformation;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personal_details", referencedColumnName = "applicant_id")
	private PersonalDetails personalDetails;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "residence_details", referencedColumnName = "applicant_id")
	private ResidenceDetails residences;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "expenses", referencedColumnName = "applicant_id")
	private Expenses expenses;

}
