package com.mt.model_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.model_service.model.Store;
import com.mt.model_service.repository.StoreRepository;

import jakarta.annotation.PostConstruct;

@Service
public class StoreService {
	@Autowired 
	private StoreRepository storeRepository;
	
	@PostConstruct
	void init() {
		if(storeRepository.count() == 0) {
		String[] stores = {"LULU Hypermarket","D-Mart","Relaince-Mart","Robin's SuperMarket","PazhaMudhir"};
		for (String name : stores) {
			save(name);
		}
		}
	}
	void save(String name) {
		Store store = new Store();
		store.setName(name);
		storeRepository.save(store);
	}
	
	public List<Store> getAllstores(){
		return storeRepository.findAll();
	}
}
