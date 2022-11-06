package br.com.firmino.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.firmino.api.domain.dto.UserDTO;
import br.com.firmino.api.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok()
				.body(mapper.map(userService.findById(id), UserDTO.class));
	}
}
