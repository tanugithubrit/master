package ai.lentra.dto.famil_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class FamilyDetailsDTO {

	private long applicantId;
	private int numberOfDependents;
	private String motherMidName;
	private boolean entityConfirmationMother;
	private int motherAge;
	private String motherFirstName;
	private String motherLastName;
	private String motherReligion;
	private String fatherMidName;
	private String fatherFirstName;
	private int fatherAge;
	private String fatherReligion;
	private String fatherLastName;
	private boolean entityConfirmationFather;
	private int numberOfMinor;
	private String childEducationLevel;
	private boolean spouseWorking;
	private String spouseLastName;
	private String spouseOccupation;
	private int spouseAge;
	private boolean entityConfirmationSpouse;
	private String spouseReligion;
	private String spouseCitizenship;
	private String spouseMidName;
	private String spouseSuffix;
	private String spouseAlias;
	private String spouseBirthdate;
	private String spouseFirstName;
}