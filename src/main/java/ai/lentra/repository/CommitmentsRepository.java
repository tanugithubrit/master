package ai.lentra.repository;

import ai.lentra.modal.commitment.CommitmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitmentsRepository extends JpaRepository<CommitmentDetails,Long> {
}
