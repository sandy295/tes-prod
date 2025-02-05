//package com.mt.model_service.configuration;
//
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.mt.model_service.container.OnnxModels;
//import com.mt.model_service.model.Model;
//import com.mt.model_service.repository.ModelRepository;
//
//import ai.onnxruntime.OrtEnvironment;
//import ai.onnxruntime.OrtSession;
//import lombok.extern.slf4j.Slf4j;
//
//@Configuration
//@Slf4j
//public class OnnxConfig {
//	  @Autowired
//	  private ModelRepository modelRepository;                                                                                                           
//	  @Value("${model.id}")
//	  private Long modelId;
//	  
//	  @Bean
//	  OrtEnvironment ortEnvironment() {
//		    log.info("Initializing OnnxEnvironment");
//	        return OrtEnvironment.getEnvironment();
//	  }
//	  
//	  @Bean 
//	  OnnxModels create(OrtEnvironment ortEnvironment) throws Exception{
//		  log.info("Attempting to create a map of sessions");
//		  int[] Modelids = {1,252};
//		  OnnxModels onnxModels = new OnnxModels();
//		  ConcurrentHashMap<String, OrtSession> sessionMap = new ConcurrentHashMap<String, OrtSession>();
//		  for (int i = 0; i < Modelids.length; i++) {
//			Model modelToLoad = modelRepository.findById((long) Modelids[i]).orElseThrow(()-> new Exception("Model Not Found"));
//			sessionMap.put(modelToLoad.getToPredict(),ortEnvironment.createSession(modelToLoad.getModelData()));
//			log.info("Created Session for "+modelToLoad.getFileName() + " With predicting --- "+ modelToLoad.getToPredict());
// 		  }
//		  onnxModels.setMap(sessionMap);
//		  return onnxModels;
//	  }
//}
