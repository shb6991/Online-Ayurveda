package com.bhs.onlineayurvedaback.dao;

import com.bhs.onlineayurvedaback.dto.Address;
import com.bhs.onlineayurvedaback.dto.Cart;
import com.bhs.onlineayurvedaback.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	
	//add an address
	boolean addAddress(Address address);
	
	//add an cart
	boolean addCart(Cart cart);
	

}
