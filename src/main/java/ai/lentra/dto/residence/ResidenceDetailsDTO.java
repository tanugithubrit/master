package ai.lentra.dto.residence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResidenceDetailsDTO {
	private long applicantId;
	@JsonProperty("id")
	private Long id;
	@JsonProperty("residence_category")
	private BigDecimal residenceCategory;
	@JsonProperty("ownership_type")
	private BigDecimal ownershipType;

	@JsonProperty("property_age")
	private BigDecimal propertyAge;

	@JsonProperty("living_with")
	private String livingWIth;

	@JsonProperty("residence_type")
	private BigDecimal residenceType;

	@JsonProperty("res_no_of_storey")
	private BigDecimal ResNoOfStorey;

	@JsonProperty("classification")
	private BigDecimal classification;

	@JsonProperty("house_condition")
	private BigDecimal houseCondition;

	@JsonProperty("property_make_type")
	private BigDecimal propertyMAkeType;

	@JsonProperty("property_interior")
	private BigDecimal propertyInterior;

	@JsonProperty("name_plate_visible")
	private boolean namePlateVisible;

	@JsonProperty("appliances")
	private BigDecimal appliances;

	@JsonProperty("appliances_total_value")
	private BigDecimal appliancesTotalValue;

	@JsonProperty("commute_options")
	private BigDecimal commuteOptions;

	@JsonProperty("neighbourhood_type")
	private BigDecimal neighbourhoodType;

	@JsonProperty("community_dominated")
	private boolean communityDominated;

	@JsonProperty("residency")
	private BigDecimal residency;

	@JsonProperty("country")
	private BigDecimal country;

	@JsonProperty("years_of_stay")
	private BigDecimal yearsOfStay;

	@JsonProperty("months_of_stay")
	private BigDecimal monthsOfStay;

	@JsonProperty("distance_from_address_to_actual_loaction")
	private BigDecimal distanceFromAddressToActualLoaction;

	@JsonProperty("res_negative_location")
	private boolean negativeLocation;
	@JsonProperty("monthly_amortization")
	private BigDecimal monthlyAmortization;

	@JsonProperty("rent_per_month")
	private BigDecimal rentPerMonth;

	@JsonProperty("landline_num")
	private BigDecimal landlineNum;

	@JsonProperty("address_line_1")
	private String addressLine1;

	@JsonProperty("address_line_2")
	private String addressLine2;
	@JsonProperty("address_line_3")
	private String addressLine3;
	@JsonProperty("address_line_4")
	private String addressLine4;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("pincode")
	private String pincode;

	@JsonProperty("country_code")
	private BigDecimal country_code;

	@JsonProperty("lattitue")
	private BigDecimal lattitue;

	@JsonProperty("longitude")
	private BigDecimal longitude;

	@JsonProperty("mail_delivery_status")
	private boolean mailDeliveryStatus;

	@JsonProperty("address_proof_id")
	private BigDecimal addressProofId;

	@JsonProperty("owned_by")
	private String ownedBy;

	@JsonProperty("mortagagor_name")
	private String mortagagorName;

	@JsonProperty("rented_from")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	private Date rentedFrom;


	@JsonProperty("residence_landmark")
	private String residenceLandmark;

	@JsonProperty("applicant_id")
	private Integer applicant_id;

	@JsonProperty("pers_met")
	private String persMet;


}