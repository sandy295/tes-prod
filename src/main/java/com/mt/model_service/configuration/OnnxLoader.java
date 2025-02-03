//package com.mt.model_service.configuration;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Paths;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.mt.model_service.model.Model;
//import com.mt.model_service.repository.ModelRepository;
//
//import ai.onnxruntime.OrtEnvironment;
//import ai.onnxruntime.OrtException;
//import ai.onnxruntime.OrtSession;
//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//
//
//@Slf4j
//@Configuration
//public class OnnxLoader {
//    @Autowired
//    private ModelRepository modelRepository;
//    
//    @Value("${model.id}")
//    private Long modelId;
//    
//    private OrtEnvironment ortEnvironment;
//    private OrtSession ortSession;
//
//    @PostConstruct
//    public void init() throws OrtException, IOException {
//        log.info("Initializing OnnxLoader");
//        Model modelToLoad = modelRepository.findById(modelId).orElseThrow(() -> new IllegalArgumentException("Model not found with id: " + modelId));
//        String loadDirectory =  "C:\\path\\to\\your\\models\\directory";
//       
//        File directory = new File(loadDirectory);
//        if(!directory.exists()) {
//            directory.mkdirs();
//        }
//        File loadFile = new File(loadDirectory, modelToLoad.getFileName());
//        try (FileOutputStream fos = new FileOutputStream(loadFile)) {
//            fos.write(modelToLoad.getModelData());
//        } catch (IOException e) {
//            e.printStackTrace();
//            log.error("Error moving File from database to local Directory "+e.getMessage());
//        }
//        log.info("Successfully Loaded: "+modelToLoad.getFileName());
//        ortEnvironment = OrtEnvironment.getEnvironment();
//        String modelPath = Paths.get("src/main/resources/models/"+modelToLoad.getFileName()).toAbsolutePath().toString();
//        ortSession = ortEnvironment.createSession(modelPath, new OrtSession.SessionOptions());
//        log.info("Successfully Created ORT session with Model Name: " + modelToLoad.getFileName());
//    }
//    
//    public void loadModel(String modelName) throws OrtException{
//    	Model modelToLoad = modelRepository.findByToPredict(modelName);
//        String loadDirectory =  "C:\\Users\\muthusam-4\\Desktop\\Java-Workspace\\model-service\\model-service\\src\\main\\resources\\models\\";
//        
//        File directory = new File(loadDirectory);
//        if(!directory.exists()) {
//            directory.mkdirs();
//        }
//        File loadFile = new File(loadDirectory, modelToLoad.getFileName());
//        System.out.println(loadFile.getPath());
//        log.info(modelToLoad.getFileName() +" " + modelToLoad.getToPredict());
//        try (FileOutputStream fos = new FileOutputStream(loadFile)) {
//            fos.write(modelToLoad.getModelData());
//        } catch (IOException e) {
//            e.printStackTrace();
//            log.error("Error moving File from database to local Directory "+e.getMessage());
//        }
//        log.info("Successfully Loaded: "+modelToLoad.getFileName());
//        String modelPath = Paths.get("src/main/resources/models/"+modelToLoad.getFileName()).toAbsolutePath().toString();
//        ortSession = ortEnvironment.createSession(modelPath, new OrtSession.SessionOptions());
//        log.info("Successfully Created ORT session with Model Name: " + modelToLoad.getFileName());
//    }
//    
//    @Bean
//    public OrtEnvironment ortEnvironment() {
//        return this.ortEnvironment;
//    }
//
//    @Bean
//    public OrtSession ortSession() {
//        return this.ortSession;
//    }
//}
