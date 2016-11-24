package pl.altkom.shop.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(annotations = Controller.class)
public class MVCInterceptor {
	@InitBinder
	public void config(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@ExceptionHandler
	public String handle(AccessDeniedException ex) {
		return "redirect:/login?error";
	}

	@ExceptionHandler
	public ModelAndView handle(Exception ex) {
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMsg", ex.toString());
		return modelAndView;
	}
}
