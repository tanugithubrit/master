package ai.lentra.service;

import ai.lentra.controller.ValidationController;
import ai.lentra.dto.ResponseDto;
import ai.lentra.exceptions.CurrencyNotFoundException;
import ai.lentra.exceptions.ResourceNotFoundException;

import ai.lentra.modal.expenses.Expenses;
import ai.lentra.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

import static ai.lentra.commons.ErrorMessage.*;

@Service
@Transactional
public class ExpensesServiceImpl implements  ExpensesService{
String errorMsg = "";
    @Autowired
    ValidationController validationController;
    @Autowired
    ExpensesRepository expensesRepository;
    @Override
    public List<Expenses> findAll() {
        return expensesRepository
                .findAll();
    }

    public ResponseEntity<?> addExpense(Expenses expenses) throws CurrencyNotFoundException {

        Boolean checkValid =  checkValidations(expenses);

        Expenses expenses1 =  calculateScore(expenses);

if (checkValid) {
    expensesRepository.save(expenses1);
}
         ResponseDto responseDTO=new ResponseDto();
        responseDTO.setCode(HttpStatus.CREATED);
        responseDTO.setMessage("Expenses Details Created Successfully");
        responseDTO.setStatus("Created");
        new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    private Boolean checkValidations(Expenses expenses) throws CurrencyNotFoundException{

        System.out.println(validationController.checkPresicion((expenses.getAvgFuelCost()))+"  Precision Avg Cost");
        System.out.println(validationController.checkPresicion(expenses.getAvgFuelCost())+"  Precision Avg Cost");
        System.out.println(NumberFormat.getCurrencyInstance().format(expenses.getAvgFuelCost()));


        if (!validationController.checkCurrency(expenses.getAvgFuelCost())) {

            throw new CurrencyNotFoundException(INVALID_CURRENCY + "for given fuel cost " + expenses.getAvgFuelCost());

        } else if (!validationController.checkCurrency(expenses.getBroadbandBillAmt())) {
            throw new CurrencyNotFoundException(INVALID_CURRENCY + "for given broadband bill " + expenses.getBroadbandBillAmt());

        }else if (!validationController.checkCurrency(expenses.getCableNetBillAmt())) {
            throw new CurrencyNotFoundException(INVALID_CURRENCY + "for given cable net bill  " + expenses.getCableNetBillAmt());

        }else
        if (!validationController.checkCurrency(expenses.getCollegeFeesAmt()) ){
            throw new CurrencyNotFoundException(INVALID_CURRENCY + "for given college fees " + expenses.getCollegeFeesAmt());

        }else if (!validationController.checkCurrency(expenses.getElectricBillAmt()) ){
            throw new CurrencyNotFoundException(INVALID_CURRENCY + "for given electric bill " + expenses.getElectricBillAmt());

        }else
        if (!validationController.checkCurrency(expenses.getSchoolFeesAmt()) ){
            throw new CurrencyNotFoundException(INVALID_CURRENCY + "for given school fees " + expenses.getSchoolFeesAmt());

        }else
        if (!validationController.checkCurrency(expenses.getWaterBillAmt()) ){
            throw new CurrencyNotFoundException(INVALID_CURRENCY + "for given water bill " + expenses.getWaterBillAmt());

        }else
        if (!validationController.checkCurrency(expenses.getOfficeTransportationCost()) ){
            throw new CurrencyNotFoundException(INVALID_CURRENCY + "for given transportation cost " + expenses.getOfficeTransportationCost());
        }
        else {
            return true;
        }
    }

    @Override
    public Expenses findExpenseByAppId(Integer appId) throws ResourceNotFoundException {

        return expensesRepository
                .findByApplicantId(appId)
                .orElseThrow(() -> new ResourceNotFoundException(EXPENSES_NOT_FOUND + " for given Id " + appId));
    }

    @Override
    public Expenses updateExpense(Expenses expensesNew, Expenses expenses) {
        if(expensesNew.getAvgFuelCost()!=null)
        expenses.setAvgFuelCost(expensesNew.getAvgFuelCost());
        if(expensesNew.getBroadbandBillAmt()!=null)
        expenses.setBroadbandBillAmt(expensesNew.getBroadbandBillAmt());
        if(expensesNew.getCableNetBillAmt()!=null)
        expenses.setCableNetBillAmt(expensesNew.getCableNetBillAmt());
        if(expensesNew.getCollegeFeesAmt()!=null)
        expenses.setCollegeFeesAmt(expensesNew.getCollegeFeesAmt());
        if(expensesNew.getElectricBillAmt()!=null)
        expenses.setElectricBillAmt(expensesNew.getElectricBillAmt());
        if(expensesNew.getOfficeTransportationCost()!=null)
        expenses.setOfficeTransportationCost(expensesNew.getOfficeTransportationCost());
        if(expensesNew.getWaterBillAmt()!=null)
        expenses.setWaterBillAmt(expensesNew.getWaterBillAmt());
        if(expensesNew.getSchoolFeesAmt()!=null)
        expenses.setSchoolFeesAmt(expensesNew.getSchoolFeesAmt());
        Expenses expenses1 =  calculateScore(expenses);
        return expensesRepository.save(expenses1);
    }

    private Expenses calculateScore(Expenses expenses){

       BigDecimal score = expenses.getAvgFuelCost().add(expenses.getBroadbandBillAmt()).add(expenses.getElectricBillAmt()).add(
                expenses.getOtherExp()).add(expenses.getWaterBillAmt()).add(expenses.getBroadbandBillAmt()).add(
                expenses.getCableNetBillAmt()).add(expenses.getCollegeFeesAmt()).add(expenses.getSchoolFeesAmt());

        score = score.setScale(2, RoundingMode.HALF_UP);
        expenses.setExpScore(score);
        return expenses;
    }
}
