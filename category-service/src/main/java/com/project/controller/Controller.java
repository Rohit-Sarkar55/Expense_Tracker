package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Response;
import com.project.entity.Category;
import com.project.service.Service;

@RestController 
@RequestMapping("/categories")
public class Controller {
	@Autowired
	Service service;
	
	@GetMapping("")
	public ResponseEntity<List<Category>> viewAll(){
		List<Category> categories = new ArrayList<>();
		try {
			categories = service.getAllCategories();
			return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Category>>(categories, HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@GetMapping("{categoryId}")
	public ResponseEntity<Category> viewById(@PathVariable Long categoryId) {
		Category c = new Category();
		try {
			c =service.getCategoryById(categoryId);
			if(c!=null) {
				return new ResponseEntity<Category>(c, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Category>(c, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Category>(c, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("add")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category c = new Category();
		try {
			c = service.addOrUpdate(category);
			return new ResponseEntity<Category>(c, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Category>(c, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("delete/{categoryId}")
	public ResponseEntity<Response>  deleteCategoryById(@PathVariable Long categoryId){
		int r = service.deleteCategory(categoryId);
		Response response = new Response();
		if(r==1) {
			response.setMsg("success");
		}
		else {
			response.setMsg("fail");
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
