package com.application.warehouseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.warehouseManagement.model.Goodown;


@Repository
public interface GoodownRepository extends JpaRepository<Goodown,Integer> {
	
	Goodown findByGoodownId(String goodownId);

}
