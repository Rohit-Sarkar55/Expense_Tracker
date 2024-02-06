package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Category;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Category, Long> {
	
}
