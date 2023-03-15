package ai.lentra.repository;

import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentDetailsRepository extends JpaRepository<OfficeSelfEmployment,Long> {

}
