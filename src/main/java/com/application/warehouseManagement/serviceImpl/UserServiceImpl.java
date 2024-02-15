package com.application.warehouseManagement.serviceImpl;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.application.warehouseManagement.dto.UserDTO;
import com.application.warehouseManagement.exceptions.MessageCodes;
import com.application.warehouseManagement.exceptions.RoleIsNotValidException;
import com.application.warehouseManagement.model.User;
import com.application.warehouseManagement.repository.UserRepository;
import com.application.warehouseManagement.service.UserService;
import com.application.warehouseManagement.util.Convertor;
import com.application.warehouseManagement.util.StoreAndCategoryValidatior;
import com.application.warehouseManagement.util.UserRoles;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private Convertor convertor;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserRepository userRepository;
	
	private StoreAndCategoryValidatior validator;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = convertor.convertUserDTOToEntity(userDTO);
		boolean role = EnumUtils.isValidEnum(UserRoles.class, userDTO.getRole().toUpperCase());
		if(!role) {
			throw new RoleIsNotValidException(messageSource.getMessage(MessageCodes.roleNotValid, null, LocaleContextHolder.getLocale()));
		}
		user.setRole(userDTO.getRole());
		User savedUser = userRepository.save(user);
		userDTO = convertor.convertUserEntityToDTO(savedUser);
		return userDTO;
	}

	@Override
	public void deleteUser(String userId) {
		validator.validateUser(userId);
		User user = userRepository.findById(userId).get();
		userRepository.delete(user);
	}

	@Override
	public UserDTO getUserById(String userId) {
		validator.validateUser(userId);
		User user = userRepository.findById(userId).get();
		UserDTO userDTO = convertor.convertUserEntityToDTO(user);
		return userDTO;
	}

}
