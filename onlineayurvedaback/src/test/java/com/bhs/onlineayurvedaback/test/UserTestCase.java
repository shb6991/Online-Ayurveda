package com.bhs.onlineayurvedaback.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bhs.onlineayurvedaback.dao.UserDAO;
import com.bhs.onlineayurvedaback.dto.Address;
import com.bhs.onlineayurvedaback.dto.Cart;
import com.bhs.onlineayurvedaback.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.bhs.onlineayurvedaback");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAdd(){
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add user
		assertEquals("Failed To Add User", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//link user with the address using user id
		address.setUserId(user.getId());

		//add user
		assertEquals("Failed To Add Address", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")){
			
			//create caert for this user
			cart = new Cart();
			cart.setUser(user);
			
			//add cart
			assertEquals("Failed To Add Cart", true, userDAO.addCart(cart));

			
			//add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			// set shipping to true
			address.setShipping(true);
			
			//link it with the user
			address.setUserId(user.getId());
			
			//add shipping address
			assertEquals("Failed To Add Shipping Address", true, userDAO.addAddress(address));

			
		}

	}
	
}
