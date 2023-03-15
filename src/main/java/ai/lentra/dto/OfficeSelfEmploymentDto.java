package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OfficeSelfEmploymentDto {
        @JsonProperty("applicant_id")
        private Long applicantId;

        @JsonProperty("out_of_geo_limit")
        private boolean outOfGeoLimit;

        @JsonProperty("metro_location")
        private boolean metroLocation;

        @JsonProperty("offc_negative_location")
        private boolean offcNegativeLocation;

        @JsonProperty("office_construction")
        private Integer office_construction;
        @JsonProperty("office_area")
        private Integer officeArea;
        @JsonProperty("office_exterior")
        private Integer officeExterior;
        @JsonProperty("office_interior")
        private Integer officeInterior;
        @JsonProperty("offc_no_of_storey")
        private Integer offcNoOfStorey;
        @JsonProperty("ease_of_office_location")
        private Integer easeOfOfficeLocation;

        @JsonProperty("items_sighted_in_office")
        private Integer itemsSightedInOffice;
        @JsonProperty("no_of_emplyees")
        private Integer noOfEmplyees;

        @JsonProperty("employment_type")
        private Integer employmentType;
        @JsonProperty("designation")
        private Integer designation;

        @JsonProperty("company_type")
        private Integer company_type;

        @JsonProperty("job_domain")
        private Integer jobDomain;

        @JsonProperty("last_month_salary")
        private Integer last_monthSalary;

        @JsonProperty("nature_of_business")
        private Integer natureOfBusiness;

        @JsonProperty("avg_monthly_turn_over")
        private Integer avgMonthlyTurnOver;

        @JsonProperty("business_board_sighted")
        private boolean businessBoardSighted;

        @JsonProperty("office_email_verified")
        private boolean officeEmailVerified;

        @JsonProperty("entry_allowed_in_office")
        private boolean entryAllowedInOffice;

        @JsonProperty("domain_check")
        private boolean domainCheck;

        @JsonProperty("office_name")
        private String officeName;

        @JsonProperty("office_telephone_no")
        private Integer officeTelephoneNo;
        @JsonProperty("extension_no")
        private Integer extensionNo;

        @JsonProperty("office_email")
        private String officeEmail;
        @JsonProperty("office_address_line_1")
        private String officeAddressLine1;

        @JsonProperty("office_address_line_2")
        private String officeAddressLine2;

        @JsonProperty("office_address_line_3")
        private String officeAddressLine3;

        @JsonProperty("office_address_line_4")
        private String officeAddressLine4;

        @JsonProperty("office_address_pincode")
        private String officeAddressPincode;

        @JsonProperty("office_address_city")
        private String officeAddressCity;

        @JsonProperty("office_address_state")
        private String office_address_state;

        @JsonProperty("office_address_country")
        private Integer officeAddressCountry;

        @JsonProperty("office_city_code")
        private String officeCityCode;

        @JsonProperty("employee_code")
        private String employeeCode;

        @JsonProperty("business_activity_sighted")
        private String businessActivitySighted;

        @JsonProperty("office_locality")
        private Integer officeLocality;



}
