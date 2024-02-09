package com.project.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.dto.Response;
import com.project.entity.Expense;
import com.project.exception.IdNotPresentException;
import com.project.service.ExpenseService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
//	@PostMapping("register")
//	public Expense addExpense(@RequestBody Expense expense)
//	{
//		return expenseService.addOrUpdate(expense);
//		
//	}
	@PostMapping("register")
	public ResponseEntity<Expense> addExpense(@RequestBody Expense expense)
	{
		Expense expense2=expenseService.addOrUpdate(expense);
		if(expense2!=null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(expense2);
		}
		else
		{
			return ResponseEntity.noContent().build();
		}
	}
//	@GetMapping("{expenseId}")
//	public Expense searchByExpenseId(@PathVariable long expenseId)
//	{
//		return expenseService.searchById(expenseId);
//	}
	
	@GetMapping("{expenseId}")
	public ResponseEntity<Expense> searchByExpenseId(@PathVariable long expenseId)
	{
		Expense expense3=expenseService.searchById(expenseId);
		if(expense3!=null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(expense3);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
//	@GetMapping("")
//	public List<Expense> viewAllExpense()
//	{
//		return expenseService.viewAll();
//		
//	}
//	@GetMapping("")
//	public ResponseEntity<List<Expense>> viewAllExpense()
//	{
//		List<Expense> expense4=expenseService.viewAll();
//		if(!expense4.isEmpty())
//		{
//			return ResponseEntity.status(HttpStatus.OK).body(expense4);
//		}
//		else
//		{
//			return ResponseEntity.noContent().build();
//		}
//	}

	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody Expense expense)
	{
		try
		{
			expenseService.ifIdPresent(expense);
			Expense expense5=expenseService.addOrUpdate(expense);
			return ResponseEntity.status(HttpStatus.CREATED).body(expense5);
		}
		catch(IdNotPresentException e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@DeleteMapping("delete/{expenseId}")
	public ResponseEntity<Response> delete(@PathVariable long expenseId)
	{
		try {
			expenseService.delete(expenseId);
			Response response=new Response();
			response.setMsg("success");
			return new ResponseEntity<Response>(response,HttpStatus.OK);
			
		}
		catch(Exception e)
		{
			Response response=new Response();
			response.setMsg("fail");
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("byTransactionType/{transactionType}")
	public ResponseEntity<List<Expense>> getByTransactionType(@PathVariable String transactionType)
	{
		List<Expense> list = expenseService.getExpenseByTransactionType(transactionType);
		if(!list.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else
		{
			return ResponseEntity.noContent().build();
		}
	}
//	 public List<Expense> getByTransactionType(@PathVariable String transactionType)
//	 {
//		return expenseService.getExpenseByTransactionType(transactionType);
//	 }
//	
	@GetMapping("byUserIdandbyTransactionType/{userId}/{transactionType}")
	public ResponseEntity<List<Expense>> getByUserIdAndTransactionType(@PathVariable long userId , @PathVariable String transactionType)
	{
		List<Expense> list = expenseService.getAllByUserIdAndTransactionType(userId, transactionType);
		if(!list.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else
		{
			return ResponseEntity.noContent().build();
		}
	}
	@GetMapping("byUserIdandbyCategory")
	public ResponseEntity<List<Expense>> getByUserIdAndCategory(@RequestParam long userId,@RequestParam long categoryId)
	{

		List<Expense> list = expenseService.getAllByUserIdAndCategoryId(userId, categoryId);
		if(!list.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else
		{
			return ResponseEntity.noContent().build();
		}
	
	}
	@GetMapping("byUserIdandbyDate")
	public ResponseEntity<List<Expense>> getByUserIdAndDate(@RequestParam long userId,@RequestParam String dateStr)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(dateStr, formatter);
		List<Expense> list = expenseService.getAllByUserIdAndDate(userId, date);
		if(!list.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else
		{
			return ResponseEntity.noContent().build();
		}
	
	}
	@GetMapping("byDateAndByTransactionType")
	public ResponseEntity<List<Expense>> getbyDateAndTransactionType(@RequestParam String strDate,@RequestParam String type)
	{
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date=LocalDate.parse(strDate, formatter);
		List<Expense> list=expenseService.getAllByDateAndTransactionType(date, type);
		if(!list.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else
		{
			return ResponseEntity.noContent().build();
		}
	}
	@GetMapping("amountByTransactionType/{userId}/{transactionType}")
	public ResponseEntity<Double> getAllAmountByTransactionType(@PathVariable long userId, @PathVariable String transactionType)
	{
		List<Expense> ex= (List<Expense>) expenseService.getAllAmountByUserIdAndTransactionType(userId, transactionType);
		double a=ex.stream().mapToDouble(Expense:: getAmount).sum();
		return ResponseEntity.status(HttpStatus.OK).body(a);
		
	}
	@GetMapping("{userId}/byMonth/{month}")
	public ResponseEntity<List<Expense>> getByUserIdAndMonth(@PathVariable long userId,@PathVariable String month)
	{
		
		List<Expense> ex=expenseService.getAllByUserId(userId);
		List<Expense> expense=new ArrayList<>();
		for(Expense e:ex)
		{
			if(e.getExpenseDate().getMonth().toString().toLowerCase().equals(month.toLowerCase()) ) {
				expense.add(e);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(expense);
	}

	@GetMapping("byUserId/{userId}")
	public ResponseEntity<List<Expense>> viewByUserId(@PathVariable long userId)
	{
		List<Expense> list=expenseService.getAllByUserId(userId);
		if(!list.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else
		{
			return ResponseEntity.noContent().build();
		}
	}
	
	
	

}
