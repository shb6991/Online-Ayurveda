package com.bhs.com.bhs.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "The Page Is Not Constructed !");

		mv.addObject("errorDescription", "The Page That You're Looking For Is Not Available Now !");

		mv.addObject("title", "404 Error Page");

		return mv;

	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "TheProduct Is Not Available !");

		mv.addObject("errorDescription", "The Product That You're Looking For Is Not Available Right Now !");

		mv.addObject("title", "Product Unavailable");

		return mv;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Please Contact Your Administrator !");

		/* only for debuging your application */

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		ex.printStackTrace(pw);

		mv.addObject("errorDescription", sw.toString());

		mv.addObject("title", "Error");

		return mv;

	}

}
