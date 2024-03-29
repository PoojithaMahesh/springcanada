package com.jsp.usercanada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.usercanada.dao.UserDao;
import com.jsp.usercanada.dto.User;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;
	
    @PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userDao.saveUser(user);
	}
    
    @GetMapping("/find")
    public User findUser(@RequestParam int id) {
    	return userDao.findUser(id);
    }
	
    @PutMapping("/update")
    public User updateUser(@RequestParam int id,@RequestBody User user) {
    	return userDao.updateUser(id,user);
    }
    @DeleteMapping("/delete")
    public User deleteUser(@RequestParam int id) {
    	return userDao.deleteUser(id);
    }
	
}
