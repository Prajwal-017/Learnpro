package com.example.demo.Services;

import com.example.demo.entities.Users;

public interface UserService {

	boolean checkEmail(String email);

	String addUser(Users user);

	boolean validate(String email, String password);

	Users getUser(String email);

	String getUserRole(String email);

	String updateUser(Users user);

}
