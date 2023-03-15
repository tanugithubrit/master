package ai.lentra.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class VehicleDetails{
	@Id
	private Long applicantId;
	private int numberOfVehiclesOwned;
	private int bikeRegistrationNumber;
	private int manufactureYearCar;
	private String bikeManufactureName;
	private String carHypothecatedTo;
	private int carRegistrationNumber;
	private boolean withParkingSpace;
	private String carOwnershipType;
	private int manufactureYearTwoWheeler;
	private String twoWheelerModel;
	private String carIssuingAuthority;
	private String carManufactureName;
	private String bikeOwnershipType;
	private String financedFromDateCar;
	private String carFuelType;
	private String bikeHypothecatedTo;
	private int carSeatingCapacity;
	private String bikeIssuingAuthority;
	private String vehicleType;
	private String carModel;
	private String financedFromDateBike;
}