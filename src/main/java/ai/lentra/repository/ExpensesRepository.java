package ai.lentra.repository;

import ai.lentra.modal.expenses.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
    Optional<Expenses> findByApplicantId(Integer appId);
}
