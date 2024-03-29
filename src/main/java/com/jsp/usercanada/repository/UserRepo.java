package com.jsp.usercanada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.usercanada.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
