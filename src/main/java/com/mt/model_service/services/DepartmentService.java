package com.mt.model_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.model_service.model.Department;
import com.mt.model_service.repository.DepartmentRepository;

import jakarta.annotation.PostConstruct;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	@PostConstruct
	public void init() {
		if(departmentRepository.count()==0) {
		String[] departments = {"Fruits","Vegetables","Groceries","Dairy","Snacks","Beverages","Bakery","Condiments","Cereals"};
		for (int i = 0; i < departments.length; i++) {
			save(departments[i]);
		}
		}
	}
	
	public void save(String name) {
		Department department = new Department();
		department.setName(name);
		departmentRepository.save(department);
	}

	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}
}
