package com.Ecommerce.SportyyShoes.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="user")
@EnableTransactionManagement
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", updatable = false, nullable = false)
    private int userId;
	
	@Column
    private String userName;
	
	@Column
    private String password;
	
	@Column
    private String email;
	
	@Column
    private String phone_number;
	
	@Column
	private Boolean isAdmin;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Purchase> listOfPurchases;

	public User(int userId, String userName, String password, String email, String phone_number, Boolean isAdmin,
			List<Purchase> listOfPurchases) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.isAdmin = isAdmin;
		this.listOfPurchases = listOfPurchases;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	@JsonManagedReference
	public List<Purchase> getListOfPurchases() {
		return listOfPurchases;
	}

	public void setListOfPurchases(List<Purchase> listOfPurchases) {
		this.listOfPurchases = listOfPurchases;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", phone_number=" + phone_number + ", isAdmin=" + isAdmin + ", listOfPurchases=" + listOfPurchases
				+ "]";
	}
	
	
	
	
}
