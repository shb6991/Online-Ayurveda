package com.bhs.com.bhs.handler;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

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
	
	
	public String validateUser(User user, MessageContext error) {
		
		String transitionValue = "success";
		
		//confirming password  with the password
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("password does not matched").build());
			
			
			transitionValue = "failure";
		}
		
		//checking uniqueness
		
		if(userDAO.getByEmail(user.getEmail())!=null) {
			
			error.addMessage(new MessageBuilder().error().source("email").defaultText("email is already exist").build());
			
			transitionValue = "failure";
		}
		
		
		
		
		
		return transitionValue;
		
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
		 
		 //encode the password
		 
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		 
		 
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
