package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

@Entity
public class Category {
	@Id
	@TableGenerator(name = "cat_seq_gen", table = "cat_seq_tab", pkColumnName = "cat_pk" , valueColumnName = "cat_val", pkColumnValue = "cat", initialValue = 1000, allocationSize = 1) // 4th type
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "cat_seq_gen")
	private long categoryId;
	private String categoryName;
	private long userId;
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
}
