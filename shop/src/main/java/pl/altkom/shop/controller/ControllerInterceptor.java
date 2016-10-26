package pl.altkom.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ControllerInterceptor {

	@ExceptionHandler
	public ResponseEntity handle(HttpMessageNotReadableException e) {
		Map<String, Object> json = new HashMap();
		json.put("error", e.getMessage());
		return new ResponseEntity(json, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	public ResponseEntity handle(Exception e) {
		Map<String, Object> json = new HashMap();
		json.put("error", e.getMessage());
		return new ResponseEntity(json, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
