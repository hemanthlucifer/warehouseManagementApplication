package com.application.warehouseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.warehouseManagement.model.User;

public interface UserRepository extends JpaRepository<User,String> {

}
