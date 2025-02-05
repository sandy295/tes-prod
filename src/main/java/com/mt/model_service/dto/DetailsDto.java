package com.mt.model_service.dto;

import java.io.Serializable;
import java.util.List;

import com.mt.model_service.model.Product;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class DetailsDto implements Serializable {
	private String departmentName;
	private List<Product> products;
}
