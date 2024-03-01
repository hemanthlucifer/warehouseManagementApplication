package com.application.warehouseManagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.application.warehouseManagement.dto.GetUserDTO;
import com.application.warehouseManagement.dto.UserDTO;
import com.application.warehouseManagement.exceptions.MessageCodes;
import com.application.warehouseManagement.exceptions.RoleIsNotValidException;
import com.application.warehouseManagement.model.Goodown;
import com.application.warehouseManagement.model.User;
import com.application.warehouseManagement.model.UserGoodown;
import com.application.warehouseManagement.repository.GoodownRepository;
import com.application.warehouseManagement.repository.UserGoodownRepository;
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
	
	@Autowired
	private UserGoodownRepository ugRepository;
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private StoreAndCategoryValidatior validator;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = convertor.convertUserDTOToEntity(userDTO);
		String emailId = userDTO.getEmailId();
		userDTO.getGoodownId().forEach(goodownId->{
			validator.goodownValidator(goodownId);
			UserGoodown userGoodown = new UserGoodown();
			userGoodown.setEmailId(emailId);
			userGoodown.setGoodownId(goodownId);
			ugRepository.save(userGoodown);
		});
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
	public GetUserDTO getUserById(String userId) {
		validator.validateUser(userId);
		User user = userRepository.findById(userId).get();
		List <UserGoodown> userGoodowns = ugRepository.findAllByEmailId(userId);
		List<Goodown> goodowns = new ArrayList<>();
		GetUserDTO getUserDTO = new GetUserDTO();
		getUserDTO.setUserId(userId);
		getUserDTO.setUserName(user.getUserName());
		getUserDTO.setUserRole(user.getRole());
		if(user.getRole().equals(UserRoles.ADMIN)) {
			getUserDTO.setGoodowns(null);
		}else {
			userGoodowns.forEach(userGoodown->{
				Goodown goodown = goodownRepository.findByGoodownId(userGoodown.getGoodownId());
				goodowns.add(goodown);
			});
			getUserDTO.setGoodowns(goodowns);
		}
		return getUserDTO;
	}

	@Override
	public Page<Goodown> getAdminGoodowns(int pageNumber, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		Page<Goodown> goodowns = goodownRepository.findAll(pageRequest);
		return goodowns;
	}

}
