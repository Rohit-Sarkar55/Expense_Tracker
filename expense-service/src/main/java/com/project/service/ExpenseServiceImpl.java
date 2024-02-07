package com.project.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.entity.Expense;
import com.project.exception.IdNotPresentException;
import com.project.repository.ExpenseRepository;
@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository repository;
	
	@Override
	public Expense addOrUpdate(Expense ex) {
		return repository.save(ex);
	}

	@Override
	public Expense searchById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Expense> viewAll() {
		return repository.findAll();
		}

	public void ifIdPresent(Expense expense) throws IdNotPresentException {
		// TODO Auto-generated method stub
		if(searchById(expense.getExpenseId())==null)
		{
			throw new IdNotPresentException("expense id missing");
		}
		
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Expense> getExpenseByTransactionType(String type) {
		return repository.findAllByTransactionType(type);
	}

	@Override
	public List<Expense> getAllByUserIdAndTransactionType(long userId, String type) {
		return repository.findAllByUserIdAndTransactionType(userId, type);
	}

	@Override
	public List<Expense> getAllByUserIdAndCategoryId(long userId, long categoryId) {
		return repository.findAllByUserIdAndCategoryId(userId, categoryId);
	}

	@Override
	public List<Expense> getAllByUserIdAndDate(long userId, LocalDate date) {
		return repository.findAllByUserIdAndExpenseDate(userId, date);
	}


}
