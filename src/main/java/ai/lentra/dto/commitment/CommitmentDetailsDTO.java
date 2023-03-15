package ai.lentra.dto.commitment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class CommitmentDetailsDTO {

	private long applicantId;
	private String bankNameLoc;
	private int termInsuranceAmt;
	private int lifeInsuranceDuration;
	private int termInsuranceDuration;
	private int locAmt;
	private int carInsuranceAmt;
	private int twoWheelerInsuranceDuration;
	private int npsDuration;
	private int homeInsuranceAmt;
	private String locExpiryDate;
	private int carInsuranceDuration;
	private String insuranceType;
	private int healthInsuranceDuration;
	private int homeInsuranceDuration;
	private String npsApplicantName;
	private int healthInsuranceAmt;
	private int npsAmt;
	private int lifeInsuranceAmt;
	private int twoWheelerInsuranceAmt;
	private int customerId;
}