package com.csp.gql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.csp.gql.entity.UserRegister;
import com.csp.gql.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserResolver {

	private final UserService service;

	// Queries
	@QueryMapping
	public List<UserRegister> getAllUsers() {
		return service.getAllUsers();
	}

	@QueryMapping
	public UserRegister getUserById(@Argument Long id) {
		return service.getUserById(id);
	}

	// Mutations
	@MutationMapping
	public UserRegister createUser(@Argument String firstName, @Argument String lastName, @Argument String email,
			@Argument String password, @Argument Long contactId) {

		return service.createUser(new UserRegister(null, firstName, lastName, email, password, contactId));
	}

	@MutationMapping
	public UserRegister updateUser(@Argument Long id, @Argument String firstName, @Argument String lastName,
			@Argument String email, @Argument String password, @Argument Long contactId) {

		return service.updateUser(id, new UserRegister(id, firstName, lastName, email, password, contactId));
	}

	@MutationMapping
	public String deleteUser(@Argument Long id) {
		return service.deleteUser(id);
	}
}
