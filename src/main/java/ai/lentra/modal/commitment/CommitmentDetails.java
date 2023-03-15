package ai.lentra.modal.commitment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class CommitmentDetails{
	@Id
	@Column(name = "applicant_id")
	private long applicantId;
	private String bankNameLoc;
	private int termInsuranceAmt;
	private int lifeInsuranceDuration;
	private int termInsuranceDuration;
	private int locAmt;
	@Column(nullable = false)
	private int carInsuranceAmt;
	private int twoWheelerInsuranceDuration;
	private int npsDuration;
	private int homeInsuranceAmt;
	private String locExpiryDate;
	@Column(nullable = false)
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