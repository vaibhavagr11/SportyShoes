package com.Ecommerce.SportyyShoes.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.SportyyShoes.Entities.Purchase;


public interface PurchaseDao extends JpaRepository<Purchase, Integer> {

}
