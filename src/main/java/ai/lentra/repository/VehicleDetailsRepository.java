package ai.lentra.repository;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails,Long> {
    VehicleDetails findByApplicantId(Long applicantId);
}
