package com.jsp.usercanada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.usercanada.dao.UserDao;
import com.jsp.usercanada.dto.User;
import com.jsp.usercanada.exception.UserIdNotFoundException;
import com.jsp.usercanada.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser = dao.saveUser(user);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setMessage("Data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		User dbUser = dao.findUser(id);

		if (dbUser != null) {
//			id is present
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data Fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		} else {
//			id is not present
			throw new UserIdNotFoundException("Sorry Failed to fetch the data");
		}
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User dbUser = dao.updateUser(id, user);
		if (dbUser != null) {
//			id is present
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data Updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		} else {
//			id is not present
			throw new UserIdNotFoundException("Sorry failed to Update the data");

		}

	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User dbUser = dao.deleteUser(id);

		if (dbUser != null) {
//			id is present
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data Deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		} else {
//			id is not present
			throw new UserIdNotFoundException("Sorry Failed to delete the data");
		}
	}

	public ResponseEntity<ResponseStructure<User>> findUserByName(String name) {
		User dbUser=dao.findUserByName(name);
		if(dbUser!=null) {
//			name is present
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data Fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}else {
//			name is not present
			return null;
//			you guys should raise one exception UserName notfoundexception and handle it
		}
		
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		List<User> users=dao.findAllUser();
		ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();
		structure.setMessage("Data Fetched successfully");
		structure.setHttpStatus(HttpStatus.FOUND.value());
		structure.setData(users);
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
		
	}

}
