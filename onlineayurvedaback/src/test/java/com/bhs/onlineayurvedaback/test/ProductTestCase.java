package com.bhs.onlineayurvedaback.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bhs.onlineayurvedaback.dao.ProductDAO;
import com.bhs.onlineayurvedaback.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.bhs.onlineayurvedaback");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");

	}

//	 @Test
//	 public void testCRUDProduct() {
//	
//	 // creating product
//	
//	 product = new Product();
//	
//	 product.setName("Kottakkal Arya Vaidya Sala Chyavanaprasam ");
//	 product.setBrand("sarc");
//	 product.setDescription("xyz about Kottakkal Arya Vaidya Sala Chyavanaprasam ");
//	 product.setUnitPrice(2164);
//	 product.setActive(true);
//	 product.setCategoryId(3);
//	 product.setSupplierId(3);
//	
//	 assertEquals("something went wrong while added roduct ", true,
//	 productDAO.add(product));
//	
//	// product = new Product();
//	//
//	// product.setName("Ayurvedic cream");
//	// product.setDescription("description for the medecines");
//	// product.setImageURL("CAT_2.jpg");
//	//
//	// assertEquals("successfully added a category into the table", true,
//	 productDAO.add(product));
//	
//	 // updating and fetching product
//	 product = productDAO.get(2);
//	 product.setName("Natures Formulary");
//	 assertEquals("something went wrong while updating existing records ",
//	 true, productDAO.update(product));
//	
//	 // delelting category
//	
//	
//	 //category = categoryDAO.get(1);
//	 assertEquals("something went wrong while deleting product", true,
//	 productDAO.delete(product));
//	
//	 //fetching the list after deactivating product
//	
//	 //category = categoryDAO.get(1);
//	 assertEquals("successfully fetched categories from the table", 6,
//	 productDAO.list().size());
//	
//	 }
//	
	
	@Test
	public void testListActiveProducts(){
		assertEquals("successfully fetched categories from the table", 5,productDAO.listActiveProducts().size());
	}
	
	
	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("successfully fetched categories from the table", 3,productDAO.listActiveProductsByCategory(3).size());
		
		assertEquals("successfully fetched categories from the table", 2,productDAO.listActiveProductsByCategory(1).size());
	}
	
	
	@Test
	public void testGetLatestActiveProducts(){
		
		assertEquals("successfully fetched categories from the table", 3,productDAO.getLatestActiveProducts(3).size());
		
		
		
	}
	
	
	
	
}
