package com.csp.gql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csp.gql.entity.UserRegister;

public interface UserRepository extends JpaRepository<UserRegister, Long> {
}

