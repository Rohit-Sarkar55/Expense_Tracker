package com.project.entity;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

@Entity
public class Expense {

	@Id
	@TableGenerator(name = "exp_seq_gen", table = "exp_seq_tab", pkColumnName = "exp_pk", valueColumnName = "exp_val", pkColumnValue = "exp", initialValue = 100, allocationSize = 1) // 4th
																																														// type
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "exp_seq_gen")

	private long expenseId;
	private String expenseName;
	private long userId;
	private LocalDate expenseDate;
	private double amount;
	private long categoryId;
	private String transactionType;
	private byte[] receiptAttachment;

	public long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public byte[] getReceiptAttachment() {
		return receiptAttachment;
	}

	public void setReceiptAttachment(byte[] receiptAttachment) {
		this.receiptAttachment = receiptAttachment;
	}

}
