package ai.lentra.service;

import ai.lentra.modal.employment_info.OfficeSelfEmployment;

import java.util.List;

public interface OfficeSelfEmploymentService {
    List<OfficeSelfEmployment> findAll();

    void addOffice(OfficeSelfEmployment offices);

    OfficeSelfEmployment findOfficeById(Long officeId);

    OfficeSelfEmployment updateOffice(OfficeSelfEmployment newOffice, OfficeSelfEmployment officeSelfEmployment);
}
