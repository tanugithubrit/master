package ai.lentra.repository;

import ai.lentra.modal.famil_info.FamilyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyDetailsRepository extends JpaRepository<FamilyDetails,Long> {
}
