package com.mt.model_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.model_service.services.AnalysisService;

@RestController
public class AnalysisController {
	@SuppressWarnings("unused")
	@Autowired
	private AnalysisService analysisService;
	 
	@GetMapping("")
	public String home() {
		return  "Analayis Home Working ";
	}
	
}
