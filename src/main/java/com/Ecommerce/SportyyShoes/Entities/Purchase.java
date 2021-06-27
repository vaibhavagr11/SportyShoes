package com.Ecommerce.SportyyShoes.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="purchase")
@EnableTransactionManagement
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Purchase {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchaseId", updatable = false, nullable = false)
    private int purchaseId;
	
	
    private LocalDate purchaseDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
    private User user;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase", fetch = FetchType.LAZY)
	private List<Product> purchasedProducts;

	public Purchase(int purchaseId, LocalDate purchaseDate, User user, List<Product> purchasedProducts) {
		super();
		this.purchaseId = purchaseId;
		this.purchaseDate = purchaseDate;
		this.user = user;
		this.purchasedProducts = purchasedProducts;
	}

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@JsonManagedReference
	public List<Product> getPurchasedProducts() {
		return purchasedProducts;
	}

	public void setPurchasedProducts(List<Product> purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", purchaseDate=" + purchaseDate + ", user=" + user
				+ ", purchasedProducts=" + purchasedProducts + "]";
	}
	
	
	
}
