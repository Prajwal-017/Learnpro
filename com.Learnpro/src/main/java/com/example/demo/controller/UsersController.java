package com.example.demo.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Services.CommentsService;
import com.example.demo.Services.UserService;
import com.example.demo.entities.Users;


import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UserService uService;
	@Autowired
	CommentsService cService;

	@PostMapping("/addUser")
	public String addUser(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("role") String role) {
		boolean emailExists = uService.checkEmail(email);
		if (emailExists == false) {
			Users user = new Users();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			uService.addUser(user);

			System.out.println("user registered successfully!");
			return "redirect:/login";
		} else {
			System.out.println("user already exists!");
			return "redirect:/register";
		}

	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		if (uService.checkEmail(email)) {
			boolean val = uService.validate(email, password);
			// if user is valid
			if (val == true) {
				Users user = uService.getUser(email); // Assuming you have a method to get the User object
				session.setAttribute("loggedInUser", user); // Saving the User object in session
				if (uService.getUserRole(email).equals("trainer")) {
					return "trainerHome";
				} else {
					return "studentHome";
				}
			}

			else {
				System.out.println("incorrect credentials, try again!");
				return "login";
			}
		} else {
			return "login";
		}

	}

}
