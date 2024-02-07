package com.project.service;

import java.util.List;

import com.project.entity.Expense;
import com.project.exception.IdNotPresentException;

public interface ExpenseService {
	Expense addOrUpdate(Expense ex);
	Expense searchById(long id);
	List<Expense> viewAll();
	void ifIdPresent(Expense expense) throws IdNotPresentException;
	void delete(long id);

}
