package pl.altkom.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@RestController
@RequestMapping("/rest/product")
@Api("Usluga dla produktow")
public class RestPhoneController {
	@Inject
	ProductRepo repo;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation("Pobiera liste wszystkich produktow")
	public List<Product> list() {
		return repo.getAll(null);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void add(@RequestBody Product product) {
		repo.insert(product);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void update(@RequestBody Product product) {
		repo.update(product);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestParam("id") Long id) {

		repo.delete(id);
	}
}
