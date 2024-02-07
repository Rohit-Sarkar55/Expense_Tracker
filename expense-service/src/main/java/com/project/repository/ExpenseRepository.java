package com.project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	List<Expense> findAllByTransactionType(String type);
	List<Expense> findAllByUserIdAndTransactionType(long userId,String type);
	List<Expense> findAllByUserIdAndCategoryId(long userId,long categoryId);
	List<Expense> findAllByUserIdAndExpenseDate(long userId,LocalDate date);
	List<Expense> findAllByExpenseDateAndTransactionType(LocalDate date,String type);
	List<Expense> findAllAmountByUserIdAndTransactionType(long userId,String type);
	

}
