package ai.lentra.controller;

import ai.lentra.commons.EndPointReferer;
import ai.lentra.commons.JsonUtils1;
import ai.lentra.dto.ExpensesDto;
import ai.lentra.exceptions.CurrencyNotFoundException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.expenses.Expenses;
import ai.lentra.service.ExpensesService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import static ai.lentra.commons.EndPointReferer.*;
import static ai.lentra.commons.ErrorMessage.*;


@RestController
@RequestMapping(value = EndPointReferer.EXPENSE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ExpenseController {
    private static final Logger logger =  LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    private JsonUtils1 jsonUtils;

    @Autowired
    ExpensesService expensesService;

    @Autowired
    ValidationController validationController;
        @Operation(summary = "Get all expenses")
        @GetMapping(EXPENSE_ALL)
        public ResponseEntity<List<ExpensesDto> > getAllExpenses()  throws ResourceNotFoundException {
        logger.info("Started API call to get all expenses");
           List<Expenses> expenses = expensesService.findAll();
            List<ExpensesDto> expenseDtoList=

                    expenses.stream()
                        .map(addr -> jsonUtils.mapper().convertValue(addr, ExpensesDto.class)).collect(Collectors.toList());
            if (!expenses.isEmpty()) {

                return  ResponseEntity.status(HttpStatus.OK).body(expenseDtoList);
            }
            throw new EntityNotFoundException(EXPENSES_NOT_FOUND);
    }

    @Operation(summary = "Add expenses")
    @PostMapping(EXPENSE_ADD)
    public ResponseEntity<?> createExpense(@RequestBody ExpensesDto expensesDto) throws CurrencyNotFoundException {
        logger.info("Started API request for Creating Expense...");
        Expenses expenses = jsonUtils.mapper().convertValue(expensesDto, Expenses.class);


        logger.info("Done Creating Expense...");
        return expensesService.addExpense( expenses);
//        new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Get Single Expense")
    @GetMapping(EXPENSE_ID)
    public ResponseEntity<ExpensesDto> getExpenses(@PathVariable Integer applicantId) throws ResourceNotFoundException {
        logger.info("Started API call to get expense details for Id {} ...", applicantId);
        Expenses expense = expensesService.findExpenseByAppId(applicantId);
        ExpensesDto expensesDto = jsonUtils.mapper().convertValue(expense, ExpensesDto.class);
        logger.info("Done getting contact details with response {}...", expensesDto.toString());


        return new ResponseEntity<>(expensesDto, HttpStatus.OK);
    }

    @Operation(summary = "Update Single Expense")
    @PutMapping(EXPENSE_ID + UPDATE)
    public ResponseEntity<ExpensesDto> updateExpenses(@PathVariable Integer applicantId,  @RequestBody ExpensesDto expensesDto) throws ResourceNotFoundException {
        logger.info("Started API call to get expense details for Id {} ...", applicantId);
        Expenses expense = expensesService.findExpenseByAppId(applicantId);
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        ExpensesDto expensesDtoOld = jsonUtils.mapper().convertValue(expense, ExpensesDto.class);
        logger.info("Done getting contact details with response {}...", expensesDtoOld.toString());
        Expenses newExpenses = jsonUtils.mapper().convertValue(expensesDto, Expenses.class);
        Expenses expensesUpdated = expensesService.updateExpense(newExpenses,expense);
        ExpensesDto expensesDtoNew = jsonUtils.mapper().convertValue(expensesUpdated, ExpensesDto.class);

        return new ResponseEntity<>(expensesDtoNew, HttpStatus.OK);
    }





}
