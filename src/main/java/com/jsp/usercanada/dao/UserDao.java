package com.jsp.usercanada.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.usercanada.dto.User;
import com.jsp.usercanada.repository.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User findUser(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
//			id is present
			User user = optional.get();
			return user;
		} else {
//			id is not present
			return null;
		}
	}

	public User updateUser(int id, User user) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
//			id is present so i can update the data
			user.setId(id);
			return repo.save(user);
		}
		return null;
	}

	public User deleteUser(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
//			id is present then i can delete the data
			User user = optional.get();
			repo.delete(user);
//			repo.deleteById(id);
			return user;
		}
		return null;
	}

	public User findUserByName(String name) {
		Optional<User> optional = repo.findByName(name);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<User> findAllUser() {
		List<User> list = repo.findAll();
		return list;
	}
}
