package ai.lentra.service;

import ai.lentra.exceptions.CurrencyNotFoundException;
import ai.lentra.exceptions.ResourceNotFoundException;

import ai.lentra.modal.expenses.Expenses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public interface ExpensesService {
       List<Expenses> findAll() throws ResourceNotFoundException;

       ResponseEntity<?> addExpense(Expenses expenses) throws CurrencyNotFoundException;

       Expenses findExpenseByAppId(Integer expenseId) throws ResourceNotFoundException;

       Expenses updateExpense(Expenses expensesNew, Expenses expensesOld);
}
