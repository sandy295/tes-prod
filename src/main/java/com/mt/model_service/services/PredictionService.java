//package com.mt.model_service.services;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.mt.model_service.component.DateComponent;
//import com.mt.model_service.container.OnnxModels;
//
//import ai.onnxruntime.OnnxTensor;
//import ai.onnxruntime.OrtEnvironment;
//import ai.onnxruntime.OrtException;
//import ai.onnxruntime.OrtSession;
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@Slf4j
//public class PredictionService {
////	    @Autowired
////	    private  OrtEnvironment env;
////	    @Autowired
////	    private DateComponent dateComponent;
////	    @Autowired 
////	    private OnnxModels onnxModels;
//	  
//	    public void someModelOperation() throws OrtException {
//	    	float[][] input = new float[5][];
//	    	for(int i = 0 ; i < 5;i++) {
//	    	   input[i] = parseDate("10-12-2004");
//	    	}
//
//	    		// Create the ONNX tensor from the input
//	    		OnnxTensor inputTensor = OnnxTensor.createTensor(env, input);
//	    		Map<String, OnnxTensor> inputMap = new HashMap<String, OnnxTensor>();
//	    		inputMap.put("float_input", inputTensor);
//
//	    		// Run the model
//	    		OrtSession.Result result = onnxModels.getMap().get("price").run(inputMap);
//
//	    		// Extract and display the predictions for each input
//	    		float[][] predictions = (float[][]) result.get(0).getValue();
//	    		for (int i = 0; i < predictions.length; i++) {
//	    		    log.info("Prediction Result for input " + (i + 1) + ": " + predictions[i][0]);
//	    		}
//	    }
//	    
//	    public Object predictQuantity(String inputDate , String resourceName ,int noofDate) throws OrtException, JsonProcessingException{
////	        float[][] inputs1 = {
////	        		{3,2024,6},
////	        		{3,2024,9},
////	        		{3,2024,12},
////	        		{3,2025,6}
////	        };
//	    	float[][] inputs = new float[noofDate][3]; 
//	    	List<String> dates = dateComponent.getDates(inputDate, noofDate);
//	    	for(int i = 0 ; i < noofDate ;i++) {
//	    		inputs[i] = parseDate(dates.get(i));
//	    		log.info("Float vALUE is " + inputs[i][0] + " "+inputs[i][1]+" "+inputs[i][2] +" Date is " + dates.get(i));
//	    	} 	
//	    	OnnxTensor inpuTensor = OnnxTensor.createTensor(env, inputs);
//	    	Map<String, OnnxTensor> inputMap = new HashMap<String, OnnxTensor>();
//	    	inputMap.put("float_input", inpuTensor);
//	    	OrtSession.Result result = onnxModels.getSession("price").run(inputMap);
//	    	return result.get(0).getValue();
//	    }
//	    float[] parseDate(String date){ //10-12-2004
//			float[] dateOutput = {1f,0,0};
//			float month =(float) Float.parseFloat(date.substring(3,5));
//			float year = (float) Float.parseFloat(date.substring(6));
//			log.info("Parsed Date: Month: " + month + " year: "+year);
//			dateOutput[2] = month;
//			dateOutput[1] = year;
//			return dateOutput;
//		}
//	    
//	    
//}
