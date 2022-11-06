package br.com.firmino.api.service;

import java.util.List;

import br.com.firmino.api.domain.User;

public interface UserService {

	User findById(Integer id);
	List<User> findAll();
}
