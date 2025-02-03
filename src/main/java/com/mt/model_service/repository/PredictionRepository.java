package com.mt.model_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.model_service.model.Predictions;
@Repository
public interface PredictionRepository extends JpaRepository<Predictions, Long> {
	
}
