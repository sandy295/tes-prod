package com.mt.model_service.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mt.model_service.dto.DetailsDto;
import com.mt.model_service.model.Department;
import com.mt.model_service.model.Product;
import com.mt.model_service.repository.DepartmentRepository;
import com.mt.model_service.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired DepartmentRepository departmentRepository;
	private HashMap<Long, List<String>> maps = new HashMap<Long, List<String>>();
	
	@PostConstruct
	void init() {
		if(productRepository.count()==0) {
		maps.put(1L,Arrays.asList("Apple", "Banana", "Orange", "Grapes", "Strawberry", "Mango", "Pineapple", "Blueberry"));
		maps.put(2L,Arrays.asList("Chicoree", "Carrots", "Potatoes", "Tomatoes", "Lettuce", "Spinach", "Onions", "Cucumber", "Bell Pepper", "Cauliflower"));
		maps.put(3L,Arrays.asList("Rice", "Pasta", "Bread", "Milk", "Cheese", "Flour", "Sugar", "Salt"));
		maps.put(4L,Arrays.asList("Yogurt", "Butter", "Cream", "Paneer", "Ice Cream", "Ghee", "Cheese Spread"));
		maps.put(5L,Arrays.asList("Chips", "Cookies", "Nuts", "Chocolate", "Granola Bars", "Popcorn", "Trail Mix"));
		maps.put(6L,Arrays.asList("Tea", "Coffee", "Juice", "Soda", "Water", "Energy Drink", "Milkshake"));
		maps.put(7L,Arrays.asList("Baguette", "Croissant", "Muffin", "Brownie", "Pound Cake"));
		maps.put(8L,Arrays.asList("Ketchup", "Mustard", "Mayonnaise", "Hot Sauce", "Soy Sauce"));
		maps.put(9L,Arrays.asList("Oats", "Cornflakes", "Muesli", "Granola", "Rice Puffs"));
//		for(int i = 0 ; i < 20 ; i++) {
			for (Map.Entry<Long, List<String>> entry : maps.entrySet()) {
				Long key = entry.getKey();
				List<String> val = entry.getValue();
 				for (Iterator<String> iterator = val.iterator(); iterator.hasNext();) {
					String string = (String) iterator.next();
					save(string, key);
				}
				
//			}
			
		}
	}
}
	void save(String name , Long id) {
		Product product = new Product();
		product.setName(name);
		product.setDepartmentId(id);
		productRepository.save(product);
	}
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	public List<DetailsDto> getProductsWithDepartment() {
		List<DetailsDto> detailsDtos = new ArrayList<DetailsDto>();
		List<Department> departments = departmentRepository.findAll();
		for (Iterator<Department> iterator = departments.iterator(); iterator.hasNext();) {
			DetailsDto detailsDto = new DetailsDto();
			Department department = (Department) iterator.next();
			detailsDto.setDepartmentName(department.getName());
			detailsDto.setProducts(productRepository.findAllByDepartmentId(department.getId()));
			detailsDtos.add(detailsDto);
		}
		return detailsDtos;
	}
}
