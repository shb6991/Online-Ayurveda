package com.bhs.onlineayurvedaback.dao;

import java.util.List;

import com.bhs.onlineayurvedaback.dto.Category;

public interface CategoryDAO {

	
	boolean add(Category category);
	List<Category> list();
	Category get(int id);

}
