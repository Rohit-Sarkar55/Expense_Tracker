package com.project.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("EXPENSE-SERVICE")
public interface ExpenseFeign {
	
}
