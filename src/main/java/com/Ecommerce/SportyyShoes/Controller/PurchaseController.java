package com.Ecommerce.SportyyShoes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.SportyyShoes.Dao.PurchaseDao;
import com.Ecommerce.SportyyShoes.Entities.Purchase;




@RestController
@CrossOrigin
public class PurchaseController {
	
	@Autowired
	private PurchaseDao purchaseDao;
	
	@PostMapping("/purchases")
	public Purchase addPurchase(@RequestBody Purchase purchase) {
		return this.purchaseDao.save(purchase);
	
	}
	
	@GetMapping("/purchases")
	public List<Purchase> getPurchases(){
		return purchaseDao.findAll();
	}
	
	@GetMapping("/purchases/{purchaseId}")
	public Purchase getPurchaseById(@PathVariable int purchaseId) {
		return purchaseDao.getById(purchaseId);
	}
	
}
