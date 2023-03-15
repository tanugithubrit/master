package ai.lentra.dto.employment_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class EmploymentDetailsDTO {
	private long applicantId;
	private String companyType;
	private String employmentType;
	private String empCode;
	private boolean domainCheck;
	private String noOfEmployees;
	private String designation;
	private String jobDomain;
	private int lastMonthSalary;
	private boolean businessBoardSighted;
	private String natureOfBusiness;
	private String businessActivitySighted;
	private int avgMonthlyTurnover;
	private String officeAddressCountry;
	private int officeArea;
	private String officeLocality;
	private boolean outOfGeoLimit;
	private String officeAddressLine2;
	private String officeAddressLine1;
	private String officeAddressLine4;
	private String officeAddressLine3;
	private String officeStateCode;
	private boolean EmpNegativeLocation;
	private int officePincode;
	private String officeAddressState;
	private boolean metroLocation;
	private String officeCity;
	private int officeTelephoneNumber;
	private String EmpNoOfStorey;
	private String easeOfOfficeLocation;
	private String officeInterior;
	private String officeConstruction;
	private String officeName;
	private boolean officeEmailVerified;
	private boolean entryAllowedInOffice;
	private int extensionNumber;
	private String officeEmail;
	private String itemsSightedInOffice;
	private String officeExterior;

}