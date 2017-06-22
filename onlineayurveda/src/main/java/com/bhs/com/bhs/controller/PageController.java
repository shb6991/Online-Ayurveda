package com.bhs.com.bhs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bhs.onlineayurvedaback.dao.CategoryDAO;
import com.bhs.onlineayurvedaback.dao.ProductDAO;
import com.bhs.onlineayurvedaback.dto.Category;
import com.bhs.onlineayurvedaback.dto.Product;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "home");

		// passing the list of categories

		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	// @RequestMapping(value= "/test")
	// public ModelAndView test(@RequestParam(value="greeting",
	// required=false)String greeting)
	// {
	// if(greeting==null)
	// {
	// greeting="Hello There";
	// }
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting", greeting);
	// return mv;
	// }

	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		if (greeting == null) {
			greeting = "Hello There";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}

	@RequestMapping(value = "about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}

	// @RequestMapping(value = "about")
	// public ModelAndView about()
	// {
	// ModelAndView mv = new ModelAndView("page");
	//
	// mv.addObject("title", "About Us");
	// mv.addObject("userClickAbout", true);
	// return mv;
	// }

	/*
	 * methods to load all the products and based on the category
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");

		// passing the list of categories

		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// using categoryDAO to fetch a single ctegory

		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName()); // passing title object

		// passing the list of categories

		mv.addObject("categories", categoryDAO.list()); // passing categories
														// object

		/*
		 * passing the single category object
		 */

		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	/*
	 * viewing the single category product
	 * 
	 * */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id){
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		
		
		//update the view counts
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//----------------------------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		return mv;
		
	}
	
}
