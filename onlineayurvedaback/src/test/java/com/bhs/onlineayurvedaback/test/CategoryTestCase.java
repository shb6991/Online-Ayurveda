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

	/*
	 * 
	 * this test case is to add category
	 */

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Ayurvedic Medecines");
	 * category.setDescription("description for the medecines");
	 * category.setImageURL("CAT_1.jpg");
	 * 
	 * assertEquals("successfully added a category into the table",true,
	 * categoryDAO.add(category)); }
	 */

	/*
	 * this test case is for fetching the category
	 */

	// @Test
	// public void testGetCategory(){
	//
	// category =categoryDAO.get(1);
	// assertEquals("successfully fetched a category from the table","Ayurvedic
	// Medecines",category.getName());
	// }

	/*
	 * this test case is for updating category
	 */

	// @Test
	// public void testUpdateCategory(){
	//
	// category =categoryDAO.get(1);
	// category.setName("Medecines");
	// assertEquals("successfully updated a category from the
	// table",true,categoryDAO.update(category));
	// }
	//

	// @Test
	// public void testDeleteCategory() {
	//
	// category = categoryDAO.get(1);
	//
	// assertEquals("successfully deleted a category from the table", true,
	// categoryDAO.delete(category));
	// }

	// @Test
	// public void testListCategory() {
	//
	// assertEquals("successfully fetched categories from the table", 3,
	// categoryDAO.list().size());
	// }
	//
	//

	@Test
	public void testCRUDCategory() {

		// creating cateory

		category = new Category();

		category.setName("Ayurvedic Medecines");
		category.setDescription("description for the medecines");
		category.setImageURL("CAT_1.jpg");

		assertEquals("successfully added a category into the table", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Ayurvedic cream");
		category.setDescription("description for the medecines");
		category.setImageURL("CAT_2.jpg");

		assertEquals("successfully added a category into the table", true, categoryDAO.add(category));

		// updating and fetching category
		category = categoryDAO.get(1);
		category.setName("Medecines");
		assertEquals("successfully updated a category from the table", true, categoryDAO.update(category));

		// delelting category 
		
		
		//category = categoryDAO.get(1);
		assertEquals("successfully deleted a category from  the table", true, categoryDAO.delete(category));
		
		//fetching the list after deactivating category 
		
		//category = categoryDAO.get(1);
		assertEquals("successfully fetched categories from the table", 1, categoryDAO.list().size());

	}

}
