package pl.altkom.shop.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Inject
	ProductRepo repo;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("products", repo.getAll());
		return "product/product-list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) throws Exception {
		model.addAttribute("product", new Product());
		return "product/product-add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute @Valid Product product, BindingResult bindingResult)
			throws Exception {
		if (bindingResult.hasErrors()) {
			return "product/product-add";
		}
		return "product/product-list";
	}
}
