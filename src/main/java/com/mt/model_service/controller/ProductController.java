package com.mt.model_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.model_service.dto.DetailsDto;
import com.mt.model_service.model.Product;
import com.mt.model_service.services.ProductService;


@RestController
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("product")
//	@Cacheable(value = "producstscache")
	public List<Product> getAllProduct() {
		return productService.getAllProducts();
	}
	@GetMapping("/products")
//	@Cacheable(value = "productsDepartmentcache")
	public List<DetailsDto> getProductsWithDepartment(){
		return productService.getProductsWithDepartment();
	}	
}
