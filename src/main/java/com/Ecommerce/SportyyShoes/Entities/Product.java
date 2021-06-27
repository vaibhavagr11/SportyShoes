package com.Ecommerce.SportyyShoes.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product")
@EnableTransactionManagement
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId", updatable = false, nullable = false)
    private int productId;
	
	@Column
    private String productName;
	
	@Column
    private String season;
    
    @Column
    private String brand;
    
    @Column
    private String category;
    
    @Column
    private double price;
    
    @Column
    private String color;
    
    @Column
    private Date createdDate;
    
    @Column
    private int discount;
    
    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Product(int productId, String productName, String season, String brand, String category, double price,
			String color, Date createdDate, int discount, Purchase purchase) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.season = season;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.color = color;
		this.createdDate = createdDate;
		this.discount = discount;
		this.purchase = purchase;
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
	@JsonBackReference
	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", season=" + season + ", brand="
				+ brand + ", category=" + category + ", price=" + price + ", color=" + color + ", createdDate="
				+ createdDate + ", discount=" + discount + ", purchase=" + purchase + "]";
	}

	
    
}
