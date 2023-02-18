package com.tian.safe_travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tian.safe_travels.models.Expense;
import com.tian.safe_travels.repositories.ExpensesRepository;

@Service
public class ExpenseService {
     	//option1
	    private final ExpensesRepository expensesRepo;
	
	    public ExpenseService(ExpensesRepository expensesRepo) {
	        this.expensesRepo = expensesRepo;
	    }
	    
	    ;
	   
	    // get all 
	    public List<Expense> allExpenses() {
	        return expensesRepo.findAll();
	    }
	    // create 
	    public Expense createExpense(Expense newExpense) {
	        return expensesRepo.save(newExpense);
	    }
	    // find one
	    public Expense oneExpense(Long id) { 
	        Optional<Expense> optionalExpense = expensesRepo.findById(id);
	        if(optionalExpense.isPresent()) {
	            return optionalExpense.get();
	        } else {
	            return null;
	        }
	    }
		//update
	    public Expense updateExpense(Expense foundExpense) {
	        return expensesRepo.save(foundExpense);
	    }
		
		//delete
	    public void deleteExpense(Long id) {
	        expensesRepo.deleteById(id);
	    }

}
