package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.UsersRepository;
import com.example.demo.entities.Users;
@Service
public class UsersServiceImpl implements UserService{
	@Autowired
	UsersRepository rep;
	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return rep.existsByEmail(email);
	}
	@Override
	public String addUser(Users user) {
		rep.save(user);
		return "Student Added Successfully";
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean validate(String email, String password) {
		if(rep.existsByEmail(email)) {
			Users u=rep.getByEmail(email);
			String dbPassword=u.getPassword();
			if(password.equals(dbPassword)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	@Override
	public Users getUser(String email) {
		return rep.getByEmail(email);
	}
	@Override
	public String getUserRole(String email) {
		// TODO Auto-generated method stub
		Users u=rep.getByEmail(email);
		return u.getRole();
	}
	@Override
	public String updateUser(Users user) {
		rep.save(user);
		return "student updated successfully!";
	}
	

}
