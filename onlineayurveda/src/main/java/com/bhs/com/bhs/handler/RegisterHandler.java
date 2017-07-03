package com.bhs.com.bhs.handler;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bhs.com.bhs.model.RegisterModel;
import com.bhs.onlineayurvedaback.dao.UserDAO;
import com.bhs.onlineayurvedaback.dto.Address;
import com.bhs.onlineayurvedaback.dto.Cart;
import com.bhs.onlineayurvedaback.dto.User;

@Component
public class RegisterHandler implements Serializable{
	
	
	@Autowired
	private UserDAO userDAO;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterModel init() {
		
		
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing){
		
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model) {
		 String transitionValue = "success";
		 
		 //fetch the user 
		 
		 User user = model.getUser();
		 
		 if(user.getRole().equals("USER")) {
			 
			 Cart cart = new Cart();
			 
			 cart.setUser(user);
			 
			 user.setCart(cart);
			 
		 }
		 
		 //save the user
		 
		 userDAO.addUser(user);
		 
		 //get the address
		 
		 Address billing = model.getBilling();
		 
		 billing.setUser(user);
		 billing.setBilling(true);
		 
		 //save the address
		 userDAO.addAddress(billing);
		 
		 return transitionValue;
	}
}
