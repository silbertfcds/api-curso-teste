package br.com.firmino.api.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.firmino.api.domain.User;
import br.com.firmino.api.domain.dto.UserDTO;
import br.com.firmino.api.exception.ObjectNotFoundException;
import br.com.firmino.api.repository.UserRepository;

@SpringBootTest
class UserServiceImplTest {

	@InjectMocks
	private UserServiceImpl service;
	
	@Mock
	private UserRepository repository;
	
	@Mock
	private ModelMapper mapper;
	
	private User user;
	private UserDTO userDTO;
	private Optional<User> optionalUser;
	
	private static final Integer ID = 1;
	private static final String NOME = "Silbert";
	private static final String EMAIL = "silbert.fcds@gmail.com";
	private static final String PASSWORD = "123";
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startUser();
	}
	
	@Test
	void whenFindByIdThenReturnAnUserInstance() {
		when(repository.findById(Mockito.anyInt())).thenReturn(optionalUser);
		
		User response = service.findById(ID);
		
		assertNotNull(response);
		assertEquals(User.class, response.getClass());
		assertEquals(ID, response.getId());
		assertEquals(NOME, response.getName());
		assertEquals(EMAIL, response.getEmail());
	}
	
	@Test
	void whenFindByIdThenReturnObjectNotFoundException() {
		when(repository.findById(Mockito.anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

		try {
			service.findById(ID);
		} catch (Exception e) {
			assertEquals(ObjectNotFoundException.class, e.getClass());
			assertEquals("Objeto não encontrado", e.getMessage());
		}
	}
	
	@Test
	void findAll() {
		
	}
	
	private void startUser() {
		user = new User(ID, NOME, EMAIL, PASSWORD);
		userDTO = new UserDTO(ID, NOME, EMAIL, PASSWORD);
		optionalUser = Optional.of(new User(ID, NOME, EMAIL, PASSWORD));
	}
}
