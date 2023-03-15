package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleDetailsDTO {
    private long applicantId;

    @Min(value = 0, message = "Number of vehicle owned should  not be possitive")
    @Max(value = 999, message = "Number of vehicle owned should not be contain more than 3")
    private int numberOfVehiclesOwned;
    //	@Pattern(regexp = "^[0-9]{2,20}$",message = "Bike Registration Number  should be less than 20 characters and more than 2 characters")
    @Min(value = 10, message = "Bike Registration Number should be less than 20 characters and more than 2 characters")
    @Max(value = 999999999, message = "Bike Registration Number should be less than 20 characters and more than 2 characters")
    private int bikeRegistrationNumber;
//	@Size(min = 4,max = 10,message = "Car Manufacturer Year should be less than 10 characters and more than 4 characters")

    @Min(value = 1000, message = "Car Manufacturer Year should be less than 20 characters and more than 2 characters")
    @Max(value = 999999999, message = "Car Manufacturer Year should be less than 20 characters and more than 2 characters")
    private int manufactureYearCar;
    @Pattern(regexp = "^[a-zA-Z]{4,10}$", message = "Bike Manufacturer Year should be less than 10 characters and more than 4 characters")
    private String bikeManufactureName;
    @Pattern(regexp = "^[a-zA-Z]{3,50}$", message = "Car Hypothecated Name should be less than 50 characters and more than 3 characters")

    private String carHypothecatedTo;
    //	@Size(min=2,max=20,message = "Car Registration Number  should be less than 20 characters and more than 2 characters")
    @Min(value = 2, message = "Car Registration Number  should be less than 20 characters and more than 2 characters")
    @Max(value = 999999999, message = "Car Registration Number should be less than 20 characters and more than 2 characters")
    private int carRegistrationNumber;
    private boolean withParkingSpace;
    @Pattern(regexp = "^[a-zA-Z]{4,20}$", message = "Car Ownership type should be less than 20 characters and more than 4 characters")

    private String carOwnershipType;
    @Min(value = 1000, message = "Manufacturer Year  should be less than 20 characters and more than 4 characters")
    @Max(value = 999999999, message = "Manufacturer Year should be less than 20 characters and more than 4 characters")
    private int manufactureYearTwoWheeler;
    @Pattern(regexp = "^[a-zA-Z0-9]{0,255}$", message = "Two Wheeler Model should be less than 255 characters and more than 0 characters")

    private String twoWheelerModel;
    @Pattern(regexp = "^[a-zA-Z0-9]{2,50}$", message = "Car Issuing Authority should be less than 50 characters and more than 2 characters")
    private String carIssuingAuthority;
    @Pattern(regexp = "^[a-zA-Z]{3,50}$", message = "Car Manufacturer Name should be less than 50 characters and more than 3 characters")

    private String carManufactureName;
    @Pattern(regexp = "^[a-zA-Z]{4,20}$", message = "Bike Ownership type should be less than 20 characters and more than 4 characters")

    private String bikeOwnershipType;
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Invalid date format. Please use the format DD/MM/YYYY")

    private String financedFromDateCar;
    @Pattern(regexp = "^[a-zA-Z]{0,6}$", message = "Car Fuel type should be less than 20 characters and more than 10 characters")

    private String carFuelType;
    @Pattern(regexp = "^[a-zA-Z]{3,50}$", message = "Bike Hypothecated Name should be less than 50 characters and more than 3 characters")
    private String bikeHypothecatedTo;

    @Min(value = 1, message = "Car Seating Capacity should be 1 characters")
    @Max(value = 9, message = "Car Seating Capacity should be 1 characters")
    private int carSeatingCapacity;
    @Pattern(regexp = "^[a-zA-Z0-9]{2,50}$", message = "Bike Issuing Authority should be less than 50 characters and more than 2 characters")

    private String bikeIssuingAuthority;
    @Pattern(regexp = "^[a-zA-Z]{10,20}$", message = "Vehicle type should be less than 20 characters and more than 10 characters")

    private String vehicleType;
    @Pattern(regexp = "^[a-zA-Z0-9]{0,255}$", message = "Car Model type should be less than 255 characters and more than 0 characters")

    private String carModel;
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Invalid date format. Please use the format DD/MM/YYYY")

    private String financedFromDateBike;
}