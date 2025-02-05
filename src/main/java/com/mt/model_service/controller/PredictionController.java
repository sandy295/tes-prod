package com.mt.model_service.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mt.model_service.component.DateComponent;
import com.mt.model_service.model.QuantityPredictionRequest;
import com.mt.model_service.repository.PredictionRepository;
import com.mt.model_service.services.PredictionService;

import ai.onnxruntime.OrtException;
    
@RestController
@RequestMapping("/predict")
public class PredictionController {
	@Autowired 
	PredictionService predictionService;
	@Autowired
	PredictionRepository predictionRepository;
	
	@Autowired 
	DateComponent dateComponent;
	@PostMapping("/quantity")
	public Object predict(@RequestBody QuantityPredictionRequest request,@RequestParam int noOfDate) throws JsonProcessingException, OrtException{
		String resourcename = "quantity";
		List<String> list = dateComponent.getDates(request.getDate(), noOfDate);
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		return predictionService.predictQuantity(request.getDate(),resourcename,noOfDate);
	}
	
	@GetMapping("/test")
	public Object getMethodName() throws OrtException {
		predictionService.someModelOperation();
		return "";
	}	
}
