package com.Ecommerce.SportyyShoes.Controller;

import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.SportyyShoes.Dao.ProductDao;
import com.Ecommerce.SportyyShoes.Entities.Product;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/products")
	public List<Product> getUsers(){
		return productDao.findAll();
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		Date x = new Date(System.currentTimeMillis());
		product.setCreatedDate(x);
		return this.productDao.save(product);
	}
	
	@PutMapping("/products/{id}")
	public void updateProduct(@PathVariable int id, @RequestBody Product product) {
		if(productDao.findById(id).isPresent()) {
			Product old=productDao.findById(id).get();
			old.setBrand(product.getBrand());
			old.setCategory(product.getCategory());
			old.setDiscount(product.getDiscount());
			old.setPrice(product.getPrice());
			old.setProductName(product.getProductName());
			old.setColor(product.getColor());
			old.setCreatedDate(product.getCreatedDate());
			old.setSeason(product.getSeason());
			old.setPurchase(product.getPurchase());
			productDao.save(old);
		}
		
	}
	
	@DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id)  {
		productDao.deleteById(id);
    }
	
	@GetMapping("/products/brand/{brand}")
    public List<Product> findProductByBrandName(@PathVariable String brand)  {
		return productDao.findBybrand(brand);
    }
	
	
	@GetMapping("/products/season/{season}")
    public List<Product> findProductBySeasonName(@PathVariable String season)  {
		return productDao.findByseason(season);
    }
	
	@GetMapping("/products/category/{category}")
    public List<Product> findProductByCategoryName(@PathVariable String category)  {
		return productDao.findBycategory(category);
    }
	
	@GetMapping("/products/color/{color}")
	public List<Product> findProductByColorName(@PathVariable String color)  {
		return productDao.findBycolor(color);
    }
	
	@GetMapping("/products/price/{order}")
	public List<Product> findProductByPrice(@PathVariable String order)  {
		
		List<Product> product = productDao.findAll();
		Collections.sort(product, Comparator.comparing(Product::getPrice));
		
		if (order.toLowerCase().equals("asc")) {
			return product;
		} else if (order.toLowerCase().equals("desc")) {
			Collections.reverse(product);
			return product;
		}
		return null;
    }
	
	
	

}
