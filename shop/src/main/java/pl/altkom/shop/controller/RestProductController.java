package pl.altkom.shop.controller;

import java.util.List;

import javax.inject.Inject;

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
	public List<Product> list(Model model) throws Exception {
		return repo.getAll();
	}

}
