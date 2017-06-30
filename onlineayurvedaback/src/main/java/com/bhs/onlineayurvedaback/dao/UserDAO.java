package com.bhs.onlineayurvedaback.dao;

import com.bhs.onlineayurvedaback.dto.Address;
import com.bhs.onlineayurvedaback.dto.Cart;
import com.bhs.onlineayurvedaback.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	
	//update a cart
	boolean updateCart(Cart cart);
	

}
