package com.mt.model_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.model_service.model.Store;
import com.mt.model_service.services.StoreService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {
	@Autowired
	private StoreService storeService;
	@GetMapping("")
	public List<Store> getAllStores() {
		return storeService.getAllstores();
	}
}
