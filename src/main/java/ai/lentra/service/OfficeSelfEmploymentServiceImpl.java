package ai.lentra.service;

import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import ai.lentra.repository.OfficeSelfEmploymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

import static ai.lentra.commons.ErrorMessage.OFFICE_NOT_FOUND;
@Service
@Transactional
public class OfficeSelfEmploymentServiceImpl implements OfficeSelfEmploymentService{
    @Autowired
    OfficeSelfEmploymentRepository officeSelfEmploymentRepository;

    @Override
    public List<OfficeSelfEmployment> findAll() {
        return officeSelfEmploymentRepository.findAll();
    }

    @Override
    public void addOffice(OfficeSelfEmployment offices) {
        officeSelfEmploymentRepository.save(offices);
    }

    @Override
    public OfficeSelfEmployment findOfficeById(Long officeId) {
        return officeSelfEmploymentRepository.findById(officeId).orElseThrow(() -> new EntityNotFoundException(OFFICE_NOT_FOUND + " for given Id " + officeId));
    }

    @Override
    public OfficeSelfEmployment updateOffice(OfficeSelfEmployment newOffice, OfficeSelfEmployment officeSelfEmployment) {

        officeSelfEmployment.setEaseOfOfficeLocation(newOffice.getEaseOfOfficeLocation());
        officeSelfEmployment.setEmploymentType(newOffice.getEmploymentType());
        officeSelfEmployment.setEntryAllowedInOffice(newOffice.isEntryAllowedInOffice());
        officeSelfEmployment.setOffice_construction(newOffice.getOffice_construction());
        officeSelfEmployment.setOfficeArea(newOffice.getOfficeArea());
        officeSelfEmployment.setOfficeArea(newOffice.getOfficeArea());
        officeSelfEmployment.setOfficeName(newOffice.getOfficeName());
        officeSelfEmployment.setOfficeExterior(newOffice.getOfficeExterior());
        officeSelfEmployment.setOfficeInterior(newOffice.getOfficeInterior());
        officeSelfEmployment.setOfficeLocality(newOffice.getOfficeLocality());
        officeSelfEmployment.setAvgMonthlyTurnOver(newOffice.getAvgMonthlyTurnOver());
        officeSelfEmployment.setBusinessActivitySighted(newOffice.getBusinessActivitySighted());
        officeSelfEmployment.setBusinessBoardSighted(newOffice.isBusinessBoardSighted());
        officeSelfEmployment.setEaseOfOfficeLocation(newOffice.getEaseOfOfficeLocation());
        officeSelfEmployment.setAvgMonthlyTurnOver(newOffice.getAvgMonthlyTurnOver());
        officeSelfEmployment.setCompany_type(newOffice.getCompany_type());
        officeSelfEmployment.setDesignation(newOffice.getDesignation());
        officeSelfEmployment.setOffDomainCheck(newOffice.isOffDomainCheck());
        officeSelfEmployment.setEmployeeCode(newOffice.getEmployeeCode());
        officeSelfEmployment.setExtensionNo(newOffice.getExtensionNo());
        officeSelfEmployment.setItemsSightedInOffice(newOffice.getItemsSightedInOffice());
        officeSelfEmployment.setJobDomain(newOffice.getJobDomain());
        officeSelfEmployment.setLast_monthSalary(newOffice.getLast_monthSalary());
        officeSelfEmployment.setMetroLocation(newOffice.isMetroLocation());
        officeSelfEmployment.setMetroLocation(newOffice.isMetroLocation());
        officeSelfEmployment.setNatureOfBusiness(newOffice.getNatureOfBusiness());
        officeSelfEmployment.setOffcNegativeLocation(newOffice.isOffcNegativeLocation());
        officeSelfEmployment.setNoOfEmplyees(newOffice.getNoOfEmplyees());
        officeSelfEmployment.setOffcNoOfStorey(newOffice.getOffcNoOfStorey());
        officeSelfEmployment.setOffice_address_state(newOffice.getOffice_address_state());
        officeSelfEmployment.setOfficeAddressCity(newOffice.getOfficeAddressCity());
        officeSelfEmployment.setOfficeAddressCountry(newOffice.getOfficeAddressCountry());
        officeSelfEmployment.setOfficeAddressLine1(newOffice.getOfficeAddressLine1());
        officeSelfEmployment.setOfficeAddressLine2(newOffice.getOfficeAddressLine2());
        officeSelfEmployment.setOfficeAddressLine3(newOffice.getOfficeAddressLine3());
        officeSelfEmployment.setOfficeAddressLine4(newOffice.getOfficeAddressLine4());
        officeSelfEmployment.setOfficeAddressPincode(newOffice.getOfficeAddressPincode());
        officeSelfEmployment.setOfficeCityCode(newOffice.getOfficeCityCode());
        officeSelfEmployment.setOfficeEmail(newOffice.getOfficeEmail());
        officeSelfEmployment.setOfficeEmailVerified(newOffice.isOfficeEmailVerified());


        return officeSelfEmploymentRepository.save(officeSelfEmployment);
    }
}
