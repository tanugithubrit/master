package ai.lentra.modal.employment_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class OfficeSelfEmployment {
	@Id
	@Column(name = "applicant_id")
	private long applicantId;

	@Column(name = "out_of_geo_limit")
	private boolean outOfGeoLimit;

	@Column(name = "metro_location")
	private boolean metroLocation;

	@Column(name = "offc_negative_location")
	private boolean offcNegativeLocation;

	@Column(name = "office_construction")
	private Integer office_construction;
	@Column(name = "office_area")
	private Integer officeArea;
	@Column(name = "office_exterior")
	private Integer officeExterior;
	@Column(name = "office_interior")
	private Integer officeInterior;
	@Column(name = "offc_no_of_storey")
	private Integer offcNoOfStorey;
	@Column(name = "ease_of_office_location")
	private Integer easeOfOfficeLocation;

	@Column(name = "items_sighted_in_office")
	private Integer itemsSightedInOffice;
	@Column(name = "no_of_emplyees")
	private Integer noOfEmplyees;

	@Column(name = "employment_type")
	private Integer employmentType;
	@Column(name = "designation")
	private Integer designation;

	@Column(name = "company_type")
	private Integer company_type;

	@Column(name = "job_domain")
	private Integer jobDomain;

	@Column(name = "last_month_salary")
	private Integer last_monthSalary;

	@Column(name = "nature_of_business")
	private Integer natureOfBusiness;

	@Column(name = "avg_monthly_turn_over")
	private Integer avgMonthlyTurnOver;

	@Column(name = "business_board_sighted")
	private boolean businessBoardSighted;

	@Column(name = "office_email_verified")
	private boolean officeEmailVerified;

	@Column(name = "entry_allowed_in_office")
	private boolean entryAllowedInOffice;

	@Column(name = "off_domain_check")
	private boolean offDomainCheck;

	@Column(name = "office_name")
	private String officeName;

	@Column(name = "office_telephone_no")
	private Integer officeTelephoneNo;
	@Column(name = "extension_no")
	private Integer extensionNo;

	@Column(name = "office_email")
	private String officeEmail;
	@Column(name = "office_address_line_1")
	private String officeAddressLine1;

	@Column(name = "office_address_line_2")
	private String officeAddressLine2;

	@Column(name = "office_address_line_3")
	private String officeAddressLine3;

	@Column(name = "office_address_line_4")
	private String officeAddressLine4;

	@Column(name = "office_address_pincode")
	private String officeAddressPincode;

	@Column(name = "office_address_city")
	private String officeAddressCity;

	@Column(name = "office_address_state")
	private String office_address_state;

	@Column(name = "office_address_country")
	private Integer officeAddressCountry;

	@Column(name = "office_city_code")
	private String officeCityCode;

	@Column(name = "employee_code")
	private String employeeCode;

	@Column(name = "business_activity_sighted")
	private String businessActivitySighted;

	@Column(name = "office_locality")
	private Integer officeLocality;



}