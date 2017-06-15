package com.bhs.onlineayurvedaback.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bhs.onlineayurvedaback.dao.CategoryDAO;
import com.bhs.onlineayurvedaback.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.bhs.onlineayurvedaback");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	@Test
	public void testAddCategory() {

		category = new Category();
		
		category.setName("Ayurvedic Medecines");
		category.setDescription("description for the medecines");
		category.setImageURL("CAT_1.jpg");
		
		assertEquals("successfully added a category into the table",true,categoryDAO.add(category));
	}

}
