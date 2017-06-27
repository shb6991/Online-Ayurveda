package com.bhs.com.bhs.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bhs.onlineayurvedaback.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product) target;
		
		//whether file has selected or not
		
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")){
			
			errors.rejectValue("file", null, "Please Select A File To Upload(.jpg)");
			
			return;
			
		}
		
		if(!(
				product.getFile().getContentType().equals("image/jpeg") 
				
				|| product.getFile().getContentType().equals("image/png")
						
				|| product.getFile().getContentType().equals("image/gif")
				
			))
				{
			
			errors.rejectValue("file", null, "Please Use Appropriate File (.jpg)");
			
			
			
		}

	}

}
