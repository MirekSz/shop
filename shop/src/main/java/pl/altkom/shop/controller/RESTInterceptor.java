package pl.altkom.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class RESTInterceptor {
	@InitBinder
	public void config(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@ExceptionHandler
	public ResponseEntity<Map> handle(Exception ex) {
		Map<String, String> response = new HashMap();
		response.put("error", ex.toString());
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
