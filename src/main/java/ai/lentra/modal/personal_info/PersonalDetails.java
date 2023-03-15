package ai.lentra.modal.personal_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
//@Entity
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class PersonalDetails{
	@Id
	@Column(name = "applicant_id")
	private long applicantId;
	private int persRefId;
	private boolean loanTakenEarlier;
	private String citizenship;
	private String birthDate;
	private String religion;
	private String martialStatus;
	private boolean politicallyExposed;
	private String educationLevel;
	private int age;
	private String lastName;
	private String alias;
	private String middleName;
	private String suffix;
	private String firstName;
	private BigDecimal income;
	private String civilStatus;
	private String incomeSource;
	private BigDecimal incomePeriod;
	private String dateTimeEndorsed;
	private String dateInspected;
}