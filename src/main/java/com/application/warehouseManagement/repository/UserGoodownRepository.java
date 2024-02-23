package com.application.warehouseManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.warehouseManagement.model.UserGoodown;

public interface UserGoodownRepository extends JpaRepository<UserGoodown,Integer> {
	
	List<UserGoodown> findAllByEmailId(String emailId);

}
