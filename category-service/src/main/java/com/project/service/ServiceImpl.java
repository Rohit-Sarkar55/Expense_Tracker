package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.entity.Category;
import com.project.repository.Repository;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	Repository repository;
	
	@Override
	public Category addOrUpdate(Category category) {
		return repository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return repository.findAll();
	}

	@Override
	public int deleteCategory(Long categoryId) {
		Category c = repository.findById(categoryId).orElse(null);
		if(c!=null) {
			repository.deleteById(categoryId);
			return 1;
		}
		else {
			return 0;
		}
		
		
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		return repository.findById(categoryId).orElse(null);
	}

}
