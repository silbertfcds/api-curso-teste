package br.com.firmino.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.firmino.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
