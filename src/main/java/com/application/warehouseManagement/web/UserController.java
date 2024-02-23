package com.application.warehouseManagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.warehouseManagement.dto.GetUserDTO;
import com.application.warehouseManagement.dto.UserDTO;
import com.application.warehouseManagement.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Operation(summary="create User")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="User created sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while creating store")
	})
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		UserDTO user = userService.createUser(userDTO);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@Operation(summary="delete User")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="User deleted sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while deleting user"),
			@ApiResponse(responseCode="404", description="No User found with the given Id")
	})
	@DeleteMapping("/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable("userId")String userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	
	@Operation(summary="fetch User")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="User fetched sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while fetching user"),
			@ApiResponse(responseCode="404", description="No User found with the given Id")
	})

	@GetMapping("/{userId}")
	public ResponseEntity<GetUserDTO> getUserById(@PathVariable("userId")String userId){
		GetUserDTO userDTO = userService.getUserById(userId);
		return new ResponseEntity<>(userDTO,HttpStatus.OK);
	}

}
