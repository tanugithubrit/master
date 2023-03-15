package ai.lentra.dto;

import ai.lentra.dto.commitment.CommitmentDetailsDTO;
import ai.lentra.dto.contact_info.ContactDetailsDTO;
import ai.lentra.dto.employment_info.EmploymentDetailsDTO;
import ai.lentra.dto.expenses.ExpensesDTO;
import ai.lentra.dto.famil_info.FamilyDetailsDTO;
import ai.lentra.dto.personal_info.PersonalDetailsDTO;
import ai.lentra.dto.residence.ResidenceDetailsDTO;
import ai.lentra.dto.summary.SummaryDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicantDetailsHistoryDTO {

    private long applicantId;
    private SummaryDTO summary;
    private CommitmentDetailsDTO commitments;
    private FamilyDetailsDTO familyDetails;
    private EmploymentDetailsDTO employmentDetails;
    private ContactDetailsDTO contactInformation;
    private PersonalDetailsDTO personalDetails;
    private ResidenceDetailsDTO residences;
    private ExpensesDTO expenses;

}
