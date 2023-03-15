package ai.lentra.service;

import ai.lentra.commons.JsonUtils1;
import ai.lentra.dto.VehicleDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.InvalidInputException;
import ai.lentra.modal.VehicleDetails;
import ai.lentra.repository.VehicleDetailsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static ai.lentra.commons.ResponeGen.getResponse;

@Service
public class VehicleDetailsServiceImpl {
    @Autowired
    VehicleDetailsRepository repository;

 ObjectMapper mapper = new ObjectMapper();

    public ResponseEntity<ResponseDTO> saveVehicleDetails(VehicleDetailsDTO vehicleDetailsDTO, long applicantId) throws InvalidInputException {
        vehicleDetailsDTO.setApplicantId(applicantId);
        String[] carDate = vehicleDetailsDTO.getFinancedFromDateCar().split("/");
        String[] bikeDate = vehicleDetailsDTO.getFinancedFromDateBike().split("/");
        LocalDate localBikeDate = LocalDate.of(Integer.parseInt(bikeDate[2]), Integer.parseInt(bikeDate[1]), Integer.parseInt(bikeDate[0]));
        LocalDate localCarDate = LocalDate.of(Integer.parseInt(carDate[2]), Integer.parseInt(carDate[1]), Integer.parseInt(carDate[0]));
        LocalDate today = LocalDate.now();
        if (localCarDate.isAfter(today)) {
            throw new InvalidInputException("Date should not be greater than current date " + vehicleDetailsDTO.getFinancedFromDateBike());
        }
        if (localBikeDate.isAfter(today)) {
            throw new InvalidInputException("Date should not be greater than current date " + vehicleDetailsDTO.getFinancedFromDateCar());
        }
        VehicleDetails vehicleDetails=mapper.convertValue(vehicleDetailsDTO,VehicleDetails.class);
        vehicleDetails.setApplicantId(applicantId);
        repository.save(vehicleDetails);
    return ResponseEntity.status(HttpStatus.CREATED).body(getResponse(201,"SUCCESS","VEHICLE DETAILS ADDED SUCCESSFULLY "));


    }

    public ResponseEntity<Object> getVehicleDetails(Long applicantId) {
        VehicleDetails details = repository.findByApplicantId(applicantId);
        return  details!=null ? ResponseEntity.status(HttpStatus.OK).body(details):ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"NOT_FOUND","DETAIL NOT FOUND FOR Applicant Id :"+applicantId));
    }

    public ResponseEntity<ResponseDTO> updateVehicleDetails(VehicleDetailsDTO vehicleDetailsDTO, long applicantId) throws InvalidInputException {
        VehicleDetails rawVehicle = repository.findByApplicantId(applicantId);

        if (rawVehicle!=null) {


            if (vehicleDetailsDTO.getBikeRegistrationNumber()!=0) {
                rawVehicle.setBikeRegistrationNumber(vehicleDetailsDTO.getBikeRegistrationNumber());
            }
            if (vehicleDetailsDTO.getBikeOwnershipType()!=null) {
                rawVehicle.setBikeOwnershipType(vehicleDetailsDTO.getBikeOwnershipType());
            }
            if (vehicleDetailsDTO.getManufactureYearCar() !=0) {
                rawVehicle.setManufactureYearCar(vehicleDetailsDTO.getManufactureYearCar());
            }
            if (vehicleDetailsDTO.getBikeManufactureName() != null) {
                rawVehicle.setBikeManufactureName(vehicleDetailsDTO.getBikeManufactureName());
            }
            if (vehicleDetailsDTO.getCarManufactureName() != null) {
                rawVehicle.setCarManufactureName(vehicleDetailsDTO.getCarManufactureName());
            }
            if (vehicleDetailsDTO.getCarHypothecatedTo() != null) {
                rawVehicle.setCarHypothecatedTo(vehicleDetailsDTO.getCarHypothecatedTo());
            }
            if (vehicleDetailsDTO.getCarRegistrationNumber() != 0) {
                rawVehicle.setCarRegistrationNumber(vehicleDetailsDTO.getCarRegistrationNumber());
            }
            if (vehicleDetailsDTO.getCarIssuingAuthority()!=null) {
                rawVehicle.setCarIssuingAuthority(vehicleDetailsDTO.getCarIssuingAuthority());
            }
            if (vehicleDetailsDTO.getBikeIssuingAuthority()!=null) {
                rawVehicle.setBikeIssuingAuthority(vehicleDetailsDTO.getBikeIssuingAuthority());
            }
            if (vehicleDetailsDTO.getCarFuelType()!=null) {
                rawVehicle.setCarFuelType(vehicleDetailsDTO.getCarFuelType());
            }
            if (vehicleDetailsDTO.getBikeHypothecatedTo()!=null) {
                rawVehicle.setBikeHypothecatedTo(vehicleDetailsDTO.getBikeHypothecatedTo());
            }
            if (vehicleDetailsDTO.getVehicleType()!=null) {
                rawVehicle.setVehicleType(vehicleDetailsDTO.getVehicleType());
            }if (vehicleDetailsDTO.getCarSeatingCapacity()!=0) {
                rawVehicle.setCarSeatingCapacity(vehicleDetailsDTO.getCarSeatingCapacity());
            }
            if (vehicleDetailsDTO.getNumberOfVehiclesOwned()!=0) {
                rawVehicle.setNumberOfVehiclesOwned(vehicleDetailsDTO.getNumberOfVehiclesOwned());
            }
            if (vehicleDetailsDTO.isWithParkingSpace() ) {
                rawVehicle.setWithParkingSpace(vehicleDetailsDTO.isWithParkingSpace());
            }
            if (vehicleDetailsDTO.getCarOwnershipType() != null) {
                rawVehicle.setCarOwnershipType(vehicleDetailsDTO.getCarOwnershipType());
            }
            if (vehicleDetailsDTO.getManufactureYearTwoWheeler() != 0) {
                rawVehicle.setManufactureYearTwoWheeler(vehicleDetailsDTO.getManufactureYearTwoWheeler());
            }
            if (vehicleDetailsDTO.getTwoWheelerModel() != null) {
                rawVehicle.setTwoWheelerModel(vehicleDetailsDTO.getTwoWheelerModel());
            }
            if (vehicleDetailsDTO.getCarModel() != null) {
                rawVehicle.setCarModel(vehicleDetailsDTO.getCarModel());
            }
            if (vehicleDetailsDTO.getFinancedFromDateBike() != null) {
                String[] bikeDate = vehicleDetailsDTO.getFinancedFromDateBike().split("/");
                LocalDate localBikeDate = LocalDate.of(Integer.parseInt(bikeDate[2]), Integer.parseInt(bikeDate[1]), Integer.parseInt(bikeDate[0]));
                LocalDate today = LocalDate.now();
                if (localBikeDate.isAfter(today)) {
                    throw new InvalidInputException("Date should not be greater than current date " + vehicleDetailsDTO.getFinancedFromDateBike());
                }
                rawVehicle.setFinancedFromDateBike(vehicleDetailsDTO.getFinancedFromDateBike());
            }
            if (vehicleDetailsDTO.getFinancedFromDateCar() != null) {
                String[] carDate = vehicleDetailsDTO.getFinancedFromDateCar().split("/");
                LocalDate localCarDate = LocalDate.of(Integer.parseInt(carDate[2]), Integer.parseInt(carDate[1]), Integer.parseInt(carDate[0]));
                LocalDate today = LocalDate.now();
                if (localCarDate.isAfter(today)) {
                    throw new InvalidInputException("Date should not be greater than current date " + vehicleDetailsDTO.getFinancedFromDateBike());
                }
                rawVehicle.setFinancedFromDateCar(vehicleDetailsDTO.getFinancedFromDateCar());
            }

            repository.save(rawVehicle);

            return ResponseEntity.status(HttpStatus.OK).body(getResponse(200,"SUCCESS","VEHICLE DETAILS SUCCESSFULLY UPDATED"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"NOT_FOUND","VEHICLE DETAILS NOT FOUND "));
        }
    }
}
