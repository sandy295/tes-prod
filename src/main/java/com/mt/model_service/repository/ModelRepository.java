package com.mt.model_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mt.model_service.model.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
	Model findByToPredict(String toPredict);

}
