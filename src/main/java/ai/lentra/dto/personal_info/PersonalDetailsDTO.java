package ai.lentra.dto.personal_info;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonalDetailsDTO {

	private long applicantId;
	private int persRefId;
	private boolean loanTakenEarlier;
	@Pattern(regexp = "^[a-zA-Z]{3,20}")
	private String citizenship;
	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",message = "date must be in the format of 'DD/MM/YYYY'")
	private String birthDate;
	@Pattern(regexp = "^[a-zA-Z]{2,10}",message = "religion must contain only letters and should be in  2 to 10 characters ")
	private String religion;
	@Pattern(regexp = "^[a-zA-Z]+$",message = "martial status must contain only letters")
	private String martialStatus;
	private boolean politicallyExposed;
	@Pattern(regexp = "^[a-zA-Z]+( [a-zA-Z]+)?$",message = "education level must contain only letters")
	private String educationLevel;
	private int age;
	@Pattern(regexp = "^[a-zA-Z]{3,50}$",message = "last name must contain only letters and should be in  3 to 50 characters")
	private String lastName;

	@Pattern(regexp = "^[a-zA-Z]{2,50}$",message = "last name must contain only letters and should be in  2 to 50 characters")
	private String alias;
	@Pattern(regexp = "^[a-zA-Z]{1,50}$",message = "middle name must contain only letters and should be in  1 to 50 characters")

	private String middleName;
	@Pattern(regexp = "^[a-zA-Z]{2,10}$",message = "suffix  must contain only letters and should be in  3 to 50 characters")

	private String suffix;
	@Pattern(regexp = "^[a-zA-Z]{2,50}$",message = "first name must contain only letters and should be in 3 to 50 characters")

	private String firstName;
	@DecimalMin(value = "99", message = "Income must be at least 3 digits long")
	@DecimalMax(value = "9999999999999", message = "Income cannot be more than 13 digits long")
	private BigDecimal income;
	private String civilStatus;
	@Pattern(regexp = "^[a-zA-Z]{3,20}$",message = "Income source should be in 3 to 20 characters and igt should have only letters")
	private String incomeSource;
	@DecimalMin(value = "10",message = "Income Period should not be less than 2 digits")
	@DecimalMax(value = "9999999999",message = "Income Period should not be greater than 10 digits")
	private BigDecimal incomePeriod;
	private String dateTimeEndorsed;
	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Invalid date format. Please use the format DD/MM/YYYY")
private String dateInspected;
}