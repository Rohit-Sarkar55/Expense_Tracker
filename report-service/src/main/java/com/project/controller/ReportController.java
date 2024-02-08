package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.client.ExpenseFeign;
import com.project.dto.Expense;

@RestController
@RequestMapping("/reports")
public class ReportController {
	@Autowired
	ExpenseFeign expenseFeign;
	
	@GetMapping("byTransactionType/{transactionType}")
	public ResponseEntity<List<Expense>> viewByTransactionType(@PathVariable String transactionType)
	{
		return expenseFeign.getByTransactionType(transactionType);
		
		
		
	}
	
	@GetMapping("viewAllexpenses")
	public ResponseEntity<List<Expense>> viewAll(){
		
		ResponseEntity<List<Expense>> list = expenseFeign.viewAllExpense();
		return list;

	}
	@GetMapping("byUserIdandbyTransactionType/{userId}/{transactionType}")
	public ResponseEntity<List<Expense>> viewByUserIdAndTransactionType(@PathVariable long userId , @PathVariable String transactionType)
	{
		return expenseFeign.getByUserIdAndTransactionType(userId, transactionType);
	}
	@GetMapping("byUserIdandbyDate")
	public ResponseEntity<List<Expense>> viewByUserIdAndDate(@RequestParam long userId,@RequestParam String dateStr)
	{
		return expenseFeign.getByUserIdAndDate(userId, dateStr);
	}
	@GetMapping("byDateAndByTransactionType")
	public ResponseEntity<List<Expense>>  viewbyDateAndTransactionType(@RequestParam String strDate,@RequestParam String type)
	{
		return expenseFeign.getbyDateAndTransactionType(strDate, type);
	}
	@GetMapping("amountByTransactionType/{userId}/{transactionType}")
	public ResponseEntity<Double> getAllAmountByTransactionType(@PathVariable long userId, @PathVariable String transactionType)
	{
		return expenseFeign.getAllAmountByTransactionType(userId, transactionType);
	}
	@GetMapping("{userId}/byMonth/{month}")
	public ResponseEntity<List<Expense>> getByUserIdAndMonth(@PathVariable long userId,@PathVariable String month)
	{
		return expenseFeign.getByUserIdAndMonth(userId, month);
	}
	

}
