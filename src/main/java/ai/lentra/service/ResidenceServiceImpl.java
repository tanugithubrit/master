package ai.lentra.service;

import ai.lentra.controller.ValidationController;
import ai.lentra.dto.ResponseDto;
import ai.lentra.exceptions.ResidenceException;
import ai.lentra.exceptions.ResourceNotFoundException;

import ai.lentra.modal.residence.ResidenceDetails;
import ai.lentra.repository.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static ai.lentra.commons.ErrorMessage.*;


@Service
@Transactional
public class ResidenceServiceImpl implements ResidenceService{

    @Autowired
    ValidationController validationController;
    @Autowired
    ResidenceRepository residenceRepository;
    @Override
    public List<ResidenceDetails> findAll()  {
        return residenceRepository.findAll();
    }

    @Override
    public ResidenceDetails findResidenceByAppId(Long residenceId) throws ResourceNotFoundException {

        return residenceRepository
                .findByAppId(residenceId)
                .orElseThrow(() -> new ResourceNotFoundException(RESIDENCE_NOT_FOUND + " for given Id " + residenceId));
    }

    @Override
    public ResidenceDetails updateExpense(ResidenceDetails newResidence, ResidenceDetails ResidenceDetails) {

        ResidenceDetails.setAddressLine1(newResidence.getAddressLine1());
        ResidenceDetails.setAddressLine2(newResidence.getAddressLine2());
        ResidenceDetails.setAddressLine3(newResidence.getAddressLine3());
        ResidenceDetails.setAddressLine4(newResidence.getAddressLine4());
        ResidenceDetails.setAppliances(newResidence.getAppliances());
        ResidenceDetails.setCity(newResidence.getCity());
        ResidenceDetails.setResidenceType(newResidence.getResidenceType());
        ResidenceDetails.setClassification(newResidence.getClassification());
        ResidenceDetails.setResidenceCategory(newResidence.getResidenceCategory());
        ResidenceDetails.setResidenceLandmark(newResidence.getResidenceLandmark());
        ResidenceDetails.setResidenceType(newResidence.getResidenceType());
        ResidenceDetails.setAddressProofId(newResidence.getAddressProofId());
        ResidenceDetails.setAppliancesTotalValue(newResidence.getAppliancesTotalValue());
        ResidenceDetails.setCommunityDominated(newResidence.isCommunityDominated());
        ResidenceDetails.setCommuteOptions(newResidence.getCommuteOptions());
        ResidenceDetails.setYearsOfStay(newResidence.getYearsOfStay());
        ResidenceDetails.setCountry(newResidence.getCountry());
        ResidenceDetails.setCountry_code(newResidence.getCountry_code());
        ResidenceDetails.setDistanceFromAddressToActualLoaction(newResidence.getDistanceFromAddressToActualLoaction());
        ResidenceDetails.setHouseCondition(newResidence.getHouseCondition());
        ResidenceDetails.setLandlineNum(newResidence.getLandlineNum());
        ResidenceDetails.setLattitue(newResidence.getLattitue());
        ResidenceDetails.setLivingWIth(newResidence.getLivingWIth());
        ResidenceDetails.setLongitude(newResidence.getLongitude());
        ResidenceDetails.setMailDeliveryStatus(newResidence.isMailDeliveryStatus());
        ResidenceDetails.setMonthlyAmortization(newResidence.getMonthlyAmortization());
        ResidenceDetails.setMonthsOfStay(newResidence.getMonthsOfStay());
        ResidenceDetails.setMortagagorName(newResidence.getMortagagorName());
        ResidenceDetails.setNamePlateVisible(newResidence.isNamePlateVisible());
        ResidenceDetails.setResNegativeLocation(newResidence.isResNegativeLocation());
        ResidenceDetails.setNeighbourhoodType(newResidence.getNeighbourhoodType());
        ResidenceDetails.setResNoOfStorey(newResidence.getResNoOfStorey());
        ResidenceDetails.setOwnedBy(newResidence.getOwnedBy());
        ResidenceDetails.setOwnershipType(newResidence.getOwnershipType());
        ResidenceDetails.setPersMet(newResidence.getPersMet());
        ResidenceDetails.setPincode(newResidence.getPincode());
        ResidenceDetails.setPropertyInterior(newResidence.getPropertyInterior());
        ResidenceDetails.setPropertyMAkeType(newResidence.getPropertyMAkeType());
        ResidenceDetails.setRentedFrom(newResidence.getRentedFrom());
        ResidenceDetails.setRentPerMonth(newResidence.getRentPerMonth());
        ResidenceDetails.setResidency(newResidence.getResidency());
        ResidenceDetails.setState(newResidence.getState());
//        ResidenceDetails.setScore(calculateScore(ResidenceDetails));
        residenceRepository.save(ResidenceDetails);
        return ResidenceDetails;
    }

    @Override
    public ResponseEntity<?> addExpense(ResidenceDetails ResidenceDetails) throws ResidenceException {

        ResidenceDetails.setResScore(calculateScore(ResidenceDetails));
        checkValidations(ResidenceDetails);
        residenceRepository.save(ResidenceDetails);
        ResponseDto responseDTO=new ResponseDto();
        responseDTO.setCode(HttpStatus.CREATED);
        responseDTO.setMessage("ResidenceDetails Information Created Successfully");
        responseDTO.setStatus("Created");
        new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    private BigDecimal calculateScore(ResidenceDetails ResidenceDetails){

//        BigDecimal score = null;
        return BigDecimal.valueOf(ResidenceDetails.getResidenceCategory()).add(BigDecimal.valueOf(ResidenceDetails.getOwnershipType())).add(BigDecimal.valueOf(ResidenceDetails.getResidenceType())).add(BigDecimal.valueOf(ResidenceDetails.getResNoOfStorey())).add(
                BigDecimal.valueOf( ResidenceDetails.getClassification())).add(BigDecimal.valueOf(ResidenceDetails.getHouseCondition())).add(BigDecimal.valueOf(ResidenceDetails.getPropertyAge())).add(BigDecimal.valueOf(ResidenceDetails.getPropertyMAkeType())).add(
                BigDecimal.valueOf(ResidenceDetails.getPropertyInterior())).add(BigDecimal.valueOf(ResidenceDetails.getAppliances())).add(ResidenceDetails.getAppliancesTotalValue()).add(BigDecimal.valueOf(ResidenceDetails.getCommuteOptions())).add(
                BigDecimal.valueOf(ResidenceDetails.getNeighbourhoodType())).add(BigDecimal.valueOf(ResidenceDetails.getResidency())).add(BigDecimal.valueOf(ResidenceDetails.getCountry())).add(BigDecimal.valueOf(ResidenceDetails.getYearsOfStay())).add(
                BigDecimal.valueOf(ResidenceDetails.getMonthsOfStay())).add(BigDecimal.valueOf(ResidenceDetails.getDistanceFromAddressToActualLoaction())).add(ResidenceDetails.getMonthlyAmortization()).add(BigDecimal.valueOf(ResidenceDetails.getRentPerMonth()));
    }
    private boolean checkValidations(ResidenceDetails ResidenceDetails )throws ResidenceException{
        if (ResidenceDetails.getAddressLine1()==null) {

            throw new ResidenceException("Value required for address line 1");

        }else if (ResidenceDetails.getAddressLine2()==null) {

            throw new ResidenceException("Value required for address line 2");

        }else if (ResidenceDetails.getAddressLine3()==null) {

            throw new ResidenceException("Value required for address line 3");

        }else
        if (ResidenceDetails.getAddressLine4()==null) {

            throw new ResidenceException("Value required for address line 4");
        }else
        if (ResidenceDetails.getCity()==null) {

            throw new ResidenceException("Value required for city");
        }else
        if (ResidenceDetails.getState()==null) {

            throw new ResidenceException("Value required for state");
        }else if (ResidenceDetails.getPincode()==null) {

            throw new ResidenceException("Value required for pincode");
        }else if (ResidenceDetails.getCountry_code()==null) {

            throw new ResidenceException("Value required for country code");

        }else if(!validationController.checkCurrency(ResidenceDetails.getAppliancesTotalValue()))
        {
            throw new ResidenceException(INVALID_CURRENCY + "for given appliances total value " + ResidenceDetails.getAppliancesTotalValue());

        }else if(!validationController.checkCurrency(ResidenceDetails.getMonthlyAmortization()))
        {
            throw new ResidenceException(INVALID_CURRENCY + "for given monthly amortization " + ResidenceDetails.getMonthlyAmortization());

        }
    else {
    return true;
        }

        }
}
