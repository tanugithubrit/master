package ai.lentra.modal.residence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ResidenceDetails{
	@Id

	@Column(name = "applicant_id")
	private long applicantId;
	@Column(name = "residence_category")

	private Long residenceCategory;

	@Column(name = "ownership_type")

	private Long ownershipType;

	@Column(name = "living_with")

	private String livingWIth;

	@Column(name = "residence_type")
	private Long residenceType;

	@Column(name = "res_no_of_storey")
	private Long resNoOfStorey;

	@Column(name = "classification")
	private Long classification;

	@Column(name = "house_condition")
	private Long houseCondition;

	@Column(name = "property_make_type")
	private Long propertyMAkeType;

	@Column(name = "property_interior")
	private Long propertyInterior;

	@Column(name = "name_plate_visible")
	private boolean namePlateVisible;

	@Column(name = "appliances")
	private Long appliances;

	@Column(name = "appliances_total_value")
	private BigDecimal appliancesTotalValue;

	@Column(name = "commute_options")
	private Long commuteOptions;

	@Column(name = "neighbourhood_type")
	private Long neighbourhoodType;

	@Column(name = "community_dominated")
	private boolean communityDominated;

	@Column(name = "residency")
	private Long residency;

	@Column(name = "country")
	private Long country;

	@Column(name = "years_of_stay")
	private Long yearsOfStay;

	@Column(name = "months_of_stay")
	private Long monthsOfStay;

	@Column(name = "distance_from_address_to_actual_loaction")
	private Long distanceFromAddressToActualLoaction;

	@Column(name = "res_negative_location")
	private boolean ResNegativeLocation;
	@Column(name = "monthly_amortization")
	private BigDecimal monthlyAmortization;

	@Column(name = "rent_per_month")
	private Long rentPerMonth;

	@Column(name = "landline_num")
	private Long landlineNum;

	@Column(name = "address_line_1")
	private String addressLine1;

	@Column(name = "address_line_2")
	private String addressLine2;
	@Column(name = "address_line_3")
	private String addressLine3;
	@Column(name = "address_line_4")
	private String addressLine4;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "country_code")
	private Long country_code;

	@Column(name = "lattitue")
	private Long lattitue;

	@Column(name = "longitude")
	private Long longitude;

	@Column(name = "mail_delivery_status")
	private boolean mailDeliveryStatus;

	@Column(name = "address_proof_id")
	private Long addressProofId;

	@Column(name = "property_age")
	private Long propertyAge;

	@Column(name = "owned_by")
	private String ownedBy;

	@Column(name = "mortagagor_name")
	private String mortagagorName;

	@Column(name = "rented_from")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	private Date rentedFrom;

	@Column(name = "residence_landmark")
	private String residenceLandmark;

	@Column(name = "pers_met")
	private String persMet;

	@Column(name = "res_score")
	private BigDecimal ResScore;



}