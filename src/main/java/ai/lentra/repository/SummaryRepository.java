package ai.lentra.repository;

import ai.lentra.modal.expenses.Expenses;
import ai.lentra.modal.summary.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SummaryRepository extends JpaRepository<Summary,Long> {
    @Query(value = "SELECT e.applicant_id, e.other_exp,e.school_fees_amt,e.college_fees_amt,e.electric_bill_amt," +
            "e.office_transportation_cost,e.cable_net_bill_amt,e.broadband_bill_amt,e.water_bill_amt," +
            "e.score, e.applicant_id , e.avg_fuel_cost FROM vms_db.expenses_fi e where e.applicant_id = ?1", nativeQuery = true)
    Optional<Expenses> findByAppId(Integer appId);
}
