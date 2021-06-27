package com.Ecommerce.SportyyShoes.Controller;

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

import com.Ecommerce.SportyyShoes.Dao.UserDao;
import com.Ecommerce.SportyyShoes.Entities.User;


@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userDao.findAll();
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return this.userDao.save(user);
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		User old=userDao.findById(id).get();
		if(userDao.findById(id).isPresent()) {
			
			old.setEmail(user.getEmail());
			old.setIsAdmin(user.getIsAdmin());
			old.setListOfPurchases(user.getListOfPurchases());
			old.setPassword(user.getPassword());
			old.setPhone_number(user.getPhone_number());
			old.setUserName(user.getUserName());
			userDao.save(old);
		}
		return old;
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId ) {
		return this.userDao.getById(userId);
	}
	
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable String userId){
		this.userDao.deleteById(Integer.parseInt(userId));
	
	}
	
	@GetMapping("/users/type/{isAdmin}")
    public List<User> findUserByType(@PathVariable boolean isAdmin)  {
		return userDao.findByIsAdmin(isAdmin);
    }
	
	@GetMapping("/users/email/{email}")
    public User findUserByEmail(@PathVariable String email)  {
		return  userDao.findByEmail(email);
    }

}
