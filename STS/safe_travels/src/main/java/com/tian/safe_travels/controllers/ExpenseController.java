package com.tian.safe_travels.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.tian.safe_travels.models.Expense;
import com.tian.safe_travels.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public String dashboardPage(Model model) {
		List<Expense> allExpenses= expenseService.allExpenses();
		model.addAttribute("allExpenses",allExpenses);
		model.addAttribute("newExpense",new Expense());
		return "dashboard.jsp";
	}
	
	//create using data binding
	   //display the form
//	@GetMapping("/expenses")
//	public String newExpenseForm(@ModelAttribute("newExpense")Expense expense) {
//		//modelAttribute will create an empty object based on data type we define
//		//model.addAttribute("newExpense",new Expense());
//		return "dashboard.jsp";
//	}

	   //process the form 
	@PostMapping("/expenses/new")
	public String processCreateForm(
			@Valid @ModelAttribute("newExpense")Expense expense, BindingResult result,Model model
			) {	
		if (result.hasErrors()) {
			List<Expense> allExpenses= expenseService.allExpenses();
			model.addAttribute("allExpenses",allExpenses);
            return "dashboard.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/expenses";
        }

	}
	
	//get one
	@GetMapping("/expenses/{id}")
	public String expenseDetail(@PathVariable("id")Long id,Model model) {
		Expense expense=expenseService.oneExpense(id);
		model.addAttribute("expense",expense);
		return "expense_detail.jsp";
	}
	
	//update edit
	
    //display the form//similar to find one
	@GetMapping("/expenses/edit/{id}")
	public String expenseEdit(@PathVariable("id")Long id,Model model) {
		Expense expense=expenseService.oneExpense(id);
		model.addAttribute("expense",expense);//same as how to be called in the form
		return "edit.jsp";
	}
	
	//process the form
	@PutMapping("/expenses/edit/{id}")
	public String processEditForm(
			@Valid @ModelAttribute("expense")Expense expense, BindingResult result
			) {	
		if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }

	}
	
	//delete
	@DeleteMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}

}
