package com.mt.model_service.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import com.mt.model_service.configuration.OnnxLoader;
import com.mt.model_service.model.Model;
import com.mt.model_service.repository.ModelRepository;

import ai.onnxruntime.OrtException;

@RestController
@RequestMapping("/api/model")
public class ModelController {
//	@Autowired
//	OnnxLoader onnxLoader;
	@Autowired
	ModelRepository modelRepository;
	@GetMapping("")
	public String home() {
		return "Home Of Model Controller Wokring ";
	}
	
	@PostMapping(consumes = "multipart/form-data",path = "")
	public Object postMethodName(@RequestParam("file") MultipartFile file , @RequestParam("categories") String categroies , @RequestParam("name") String name) throws IOException {
		if(file.isEmpty()) {
			return "emplyty";
		}
		System.out.println(file.getContentType());
		
		Model model = new Model();
		model.setFileName(file.getOriginalFilename());
		model.setModelData(file.getBytes());
		model.setCategories(categroies);
		model.setToPredict(name);
		modelRepository.save(model);
		return file.getContentType();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE,path = "download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable Long id){
		Model model = modelRepository.findById(id).get();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\"" + model.getFileName() + "\"")
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(model.getModelData());
	}
	
	@GetMapping("/model/load/{id}")
	public String moveModel(@PathVariable Long id) throws OrtException {
//		onnxLoader.loadModel("name");
		return "SDf";
	}
	
	
}
