package com.Ecommerce.SportyyShoes.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.SportyyShoes.Entities.Product;


public interface ProductDao extends JpaRepository<Product , Integer>{
	
	public List<Product> findBybrand(String name);
	public List<Product> findByseason(String name);
	public List<Product> findBycategory(String name);
	public List<Product> findBycolor(String name);
	

}
