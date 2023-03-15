package ai.lentra.repository.lookups;

import ai.lentra.modal.lookups.SimCardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SimCardTypeRepository extends JpaRepository<SimCardType, Long> {

     SimCardType findByTypeIgnoreCase(String type);

    SimCardType findById(String id);
}
