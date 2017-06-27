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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bhs.com.bhs.util.FileUploadUtility;
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
		}
		
		return mv;
	}
	
	//handling product submission
	
	@RequestMapping(value = "/products", method =RequestMethod.POST) 
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request){
		
		//check if any errors
		
		if(results.hasErrors()){
			
			model.addAttribute("userClickManageProducts", true);
			
			model.addAttribute("title", "Manage Products");
			
			model.addAttribute("message", "Validation Falied");
			
			
			return "page";	
		}
		
		logger.info(mProduct.toString());
		
		//creating new product
		
		productDAO.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
			
		}
		
		
		
						
		return "redirect:/manage/products?operation = product";
	}
	
	
	
	
	//returning all the categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
	}
}
