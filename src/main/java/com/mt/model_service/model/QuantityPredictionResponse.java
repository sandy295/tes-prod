package com.mt.model_service.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class QuantityPredictionResponse {
	private String date;
	private float predictedQuantity;
	public String toJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this);
	}
}
