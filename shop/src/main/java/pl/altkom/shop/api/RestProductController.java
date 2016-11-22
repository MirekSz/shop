package pl.altkom.shop.api;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@RestController
@RequestMapping("/api/products")
public class RestProductController {

	@Inject
	ProductRepo repo;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation("Metoda pobierajaca liste produktow")
	public List<Product> list() {
		return repo.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		repo.delete(id);
	}

}
