package com.mt.model_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.mt.model_service.model.Department;
import com.mt.model_service.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("")
//	@Cacheable(value = "departmentCache")
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartment();
	}
}
