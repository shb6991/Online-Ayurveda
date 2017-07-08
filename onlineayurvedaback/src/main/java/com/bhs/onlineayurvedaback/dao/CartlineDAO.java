package com.bhs.onlineayurvedaback.dao;

import java.util.List;

import com.bhs.onlineayurvedaback.dto.CartLine;

public interface CartlineDAO {
	
	List<CartLine> list(int cartid);
	boolean add(CartLine cartline);
	boolean update(CartLine cartline);
	boolean delete(CartLine cartline);
	
	CartLine ifExists(int cartId,int prodId);
	CartLine getById(int id);

}
