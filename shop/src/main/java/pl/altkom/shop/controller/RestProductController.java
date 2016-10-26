package pl.altkom.shop.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.service.ProductService;

@RestController
@RequestMapping("/rest/product")
public class RestProductController {
	@Inject
	ProductService service;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation("Pobiera liste wszystkich produktow")
	public List<Product> list() {
		return service.getAll(null);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void add(@RequestBody Product product) {
		service.insert(product);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void update(@RequestBody Product product) {
		service.update(product);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestParam("id") Long id) {

		service.delete(id);
	}

}
