package ai.lentra.repository;

import ai.lentra.modal.ApplicantDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantDetailsRepository extends JpaRepository<ApplicantDetails,Long> {
}
