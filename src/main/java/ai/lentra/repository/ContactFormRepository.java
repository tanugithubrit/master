package ai.lentra.repository;

import ai.lentra.modal.contact_info.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactFormRepository extends JpaRepository<ContactDetails, Long> {

    ContactDetails findByApplicantId(Long applicantId);
}
