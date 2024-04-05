package com.jsp.usercanada.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.usercanada.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{
    @Query("select s from User s where s.name=?1")
	Optional<User> findByName(String name);

}
