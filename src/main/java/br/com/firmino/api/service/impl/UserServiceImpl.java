package br.com.firmino.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.firmino.api.domain.User;
import br.com.firmino.api.domain.dto.UserDTO;
import br.com.firmino.api.exception.DataIntegratyViolationException;
import br.com.firmino.api.exception.ObjectNotFoundException;
import br.com.firmino.api.repository.UserRepository;
import br.com.firmino.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public User findById(Integer id) {
		Optional<User> userOptional = repository.findById(id);
		return userOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}

	@Override
	public User create(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}

	private void findByEmail(UserDTO obj) {
		Optional<User> userOptional = repository.findByEmail(obj.getEmail());
		if(userOptional.isPresent() && !userOptional.get().getId().equals(obj.getId())) {
			throw new DataIntegratyViolationException("Email já cadastrado");
		}
	}

	@Override
	public User update(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}

	@Override
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
