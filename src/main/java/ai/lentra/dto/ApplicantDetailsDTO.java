package ai.lentra.dto;

import ai.lentra.dto.contact_info.ContactDetailsDTO;
import ai.lentra.dto.employment_info.EmploymentDetailsDTO;
import ai.lentra.dto.expenses.ExpensesDTO;
import ai.lentra.dto.famil_info.FamilyDetailsDTO;
import ai.lentra.dto.personal_info.PersonalDetailsDTO;
import ai.lentra.dto.residence.ResidenceDetailsDTO;
import ai.lentra.modal.commitment.CommitmentDetails;
import ai.lentra.modal.summary.Summary;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicantDetailsDTO{


	private long applicantId;

	private Summary summary;

	private CommitmentDetails commitments;

	private FamilyDetailsDTO familyDetails;

	private EmploymentDetailsDTO employmentDetails;

	private ContactDetailsDTO contactInformation;

	private PersonalDetailsDTO personalDetails;

	private ResidenceDetailsDTO residences;

	private ExpensesDTO expenses;

}
