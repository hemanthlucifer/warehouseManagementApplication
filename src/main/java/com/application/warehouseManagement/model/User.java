package com.application.warehouseManagement.model;

import com.application.warehouseManagement.util.UserRoles;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class User {
	
	@Getter
	@Setter
	@Column
	@Id
	private String emailId;
	
	@Getter
	@Setter
	@Column
	private String userName;
	
	@Getter
	@Setter
	@Column
	private String password;
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private UserRoles role;

}
