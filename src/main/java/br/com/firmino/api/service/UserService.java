package br.com.firmino.api.service;

import java.util.List;

import br.com.firmino.api.domain.User;
import br.com.firmino.api.domain.dto.UserDTO;

public interface UserService {

	User findById(Integer id);
	List<User> findAll();
	User create(UserDTO obj);
}
