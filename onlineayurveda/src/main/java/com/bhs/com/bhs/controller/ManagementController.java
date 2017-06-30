package com.bhs.com.bhs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bhs.com.bhs.util.FileUploadUtility;
import com.bhs.com.bhs.validator.ProductValidator;
import com.bhs.onlineayurvedaback.dao.CategoryDAO;
import com.bhs.onlineayurvedaback.dao.ProductDAO;
import com.bhs.onlineayurvedaback.dto.Category;
import com.bhs.onlineayurvedaback.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method =RequestMethod.GET)
	
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation){
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Mnage Products");
		
		Product nProduct = new Product();
		
		//set few of the fields
		
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		if(operation != null){
			if(operation.equals("product")){
				mv.addObject("message", "Product Successfully Submitted");
			}
			else if(operation.equals("category")){
				mv.addObject("message", "Category Successfully Submitted");
			}
		}
		
		return mv;
	}
	
	
	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Mnage Products");

		// fetching the product from the database
		Product nProduct = productDAO.get(id);

		// set the product fetch from the db
		mv.addObject("product", nProduct);

		return mv;
	}
	
	//handling product submission
	
	@RequestMapping(value = "/products", method =RequestMethod.POST) 
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request){
		
		//handle image validation for new product
		
		if(mProduct.getId() == 0){
		new ProductValidator().validate(mProduct, results);
		}
		
		else{
			
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);
		}
		}
		//check if any errors
		
		if(results.hasErrors()){
			
			model.addAttribute("userClickManageProducts", true);
			
			model.addAttribute("title", "Manage Products");
			
			model.addAttribute("message", "Validation Falied");
			
			
			return "page";	
		}
		
		logger.info(mProduct.toString());
		
		if(mProduct.getId() == 0){
			
		 // creating new product if id is 0
		productDAO.add(mProduct);
		}
		
		else{
			
			//update the product if id is not 0
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
			
		}
		
		
		
						
		return "redirect:/manage/products?operation = product";
	}
	
	
	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id){
		
		//is going to fetch the product from the database
		
		Product product = productDAO.get(id);
		
		boolean isActive = product.isActive();
		
		//activating and deactivating the product based on the active field
		product.setActive(!product.isActive());
		
		//UPDATING THE PRODUCT
		productDAO.update(product);
		
		
		return (isActive)? "You Have successfully deactivaetd the product with id " + product.getId() : "You Have successfully Activaetd the product with id " + product.getId();
	}
	
	
	//creatin another request mapping to handle category submisssion
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category){
		
		//add new category
		categoryDAO.add(category);
		
		return "redirect:/manage/products?operation=category";
	}
	
	
	//returning all the categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
	}
	
	
	@ModelAttribute("category")
	public Category getCategory(){
		
		
		return new Category();
	}
	
	
	
	
	
	
	
	
	
}
