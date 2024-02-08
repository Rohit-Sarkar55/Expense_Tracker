package com.project.client;

<<<<<<< HEAD
import org.springframework.cloud.openfeign.FeignClient;
=======
import java.util.List;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dto.Expense;



@FeignClient("EXPENSE-SERVICE")
public interface ExpenseFeign {
	@GetMapping("expenses/{userId}/byMonth/{month}")
	public ResponseEntity<List<Expense>> getByUserIdAndMonth(@PathVariable long userId,@PathVariable String month);
	
	@GetMapping("expenses/amountByTransactionType/{userId}/{transactionType}")
	public ResponseEntity<Double> getAllAmountByTransactionType(@PathVariable long userId, @PathVariable String transactionType);
	
	@GetMapping("expenses/byDateAndByTransactionType")
	public ResponseEntity<List<Expense>> getbyDateAndTransactionType(@RequestParam String strDate,@RequestParam String type);
	
	@GetMapping("expenses/byUserIdandbyDate")
	public ResponseEntity<List<Expense>> getByUserIdAndDate(@RequestParam long userId,@RequestParam String dateStr);
	
	@GetMapping("expenses/byUserIdandbyTransactionType/{userId}/{transactionType}")
	public ResponseEntity<List<Expense>> getByUserIdAndTransactionType(@PathVariable long userId , @PathVariable String transactionType);
	
	@GetMapping("expenses/byTransactionType/{transactionType}")
	public ResponseEntity<List<Expense>> getByTransactionType(@PathVariable String transactionType);
	
	
	@GetMapping("expenses")
	public ResponseEntity<List<Expense>> viewAllExpense();
>>>>>>> upstream/main

@FeignClient("EXPENSE-SERVICE")
public interface ExpenseFeign {
	
}
