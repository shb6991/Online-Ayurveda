package com.bhs.onlineayurvedaback.dao;

import java.util.List;

import com.bhs.onlineayurvedaback.dto.Address;
import com.bhs.onlineayurvedaback.dto.Cart;
import com.bhs.onlineayurvedaback.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List <Address> listShippingAddresses(User user);  
	
	//update a cart
	boolean updateCart(Cart cart);
	

}
