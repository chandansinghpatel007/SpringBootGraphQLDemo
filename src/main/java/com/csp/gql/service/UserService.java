package com.csp.gql.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.csp.gql.entity.UserRegister;
import com.csp.gql.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repo;

	public List<UserRegister> getAllUsers() {
		return repo.findAll();
	}

	public UserRegister getUserById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public UserRegister createUser(UserRegister user) {
		return repo.save(user);
	}

	public UserRegister updateUser(Long id, UserRegister user) {
		UserRegister dbUser = repo.findById(id).orElseThrow();
		
		BeanUtils.copyProperties(user, dbUser);
		
		return repo.save(dbUser);
	}

	public String deleteUser(Long id) {
		repo.deleteById(id);
		return "User deleted successfully";
	}
}
