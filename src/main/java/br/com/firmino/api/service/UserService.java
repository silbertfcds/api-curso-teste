package br.com.firmino.api.service;

import br.com.firmino.api.domain.User;

public interface UserService {

	User findById(Integer id);
}
