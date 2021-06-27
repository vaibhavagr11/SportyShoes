package com.Ecommerce.SportyyShoes.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.SportyyShoes.Entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	public List<User> findByIsAdmin(boolean isAdmin);
	public User findByEmail (String email);
	
	
}
