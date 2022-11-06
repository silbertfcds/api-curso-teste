package br.com.firmino.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.firmino.api.domain.User;
import br.com.firmino.api.exception.ObjectNotFoundException;
import br.com.firmino.api.repository.UserRepository;
import br.com.firmino.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User findById(Integer id) {
		Optional<User> userOptional = repository.findById(id);
		return userOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
