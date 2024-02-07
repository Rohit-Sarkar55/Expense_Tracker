package com.project.service;

import java.time.LocalDate;
import java.util.List;

import com.project.entity.Expense;
import com.project.exception.IdNotPresentException;

public interface ExpenseService {
	Expense addOrUpdate(Expense ex);
	Expense searchById(long id);
	List<Expense> viewAll();
	void ifIdPresent(Expense expense) throws IdNotPresentException;
	void delete(long id);
	List<Expense> getExpenseByTransactionType(String type);
	List<Expense> getAllByUserIdAndTransactionType(long userId,String type);
	List<Expense> getAllByUserIdAndCategoryId(long userId,long categoryId);
	List<Expense> getAllByUserIdAndDate(long userId,LocalDate date);

}
