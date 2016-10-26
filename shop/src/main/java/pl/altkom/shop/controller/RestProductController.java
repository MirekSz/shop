package pl.altkom.shop.controller;

import java.util.Enumeration;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@RestController
@RequestMapping("/rest/product")
public class RestProductController {

	@Inject
	ProductRepo repo;

	@RequestMapping("/list")
	public List<Product> list(Model model, HttpServletRequest reg) throws Exception {
		Enumeration<String> headerNames = reg.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String nextElement = headerNames.nextElement();
			String header = reg.getHeader(nextElement);
			System.out.println(nextElement + " " + header);
		}
		return repo.getAll();
	}

}
