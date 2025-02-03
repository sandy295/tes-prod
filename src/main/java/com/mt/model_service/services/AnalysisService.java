package com.mt.model_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.model_service.model.Analaysis;
import com.mt.model_service.repository.AnalysisRepository;

@Service
public class AnalysisService {
	@Autowired
	private AnalysisRepository analysisRepository;
	public void save(Analaysis analaysis) {
		analysisRepository.save(analaysis);
	}
}
