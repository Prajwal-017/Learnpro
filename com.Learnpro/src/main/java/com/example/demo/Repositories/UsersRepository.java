package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	boolean existsByEmail(String email);

	Users getByEmail(String email);

}
