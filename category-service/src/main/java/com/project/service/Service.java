package com.project.service;

import java.util.List;

import com.project.entity.Category;

public interface Service {
	Category addOrUpdate(Category category);
	List<Category> getAllCategories();
	int deleteCategory(Long categoryId);
	Category getCategoryById(Long categoryId);
}
