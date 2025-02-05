package com.mt.model_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.model_service.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
