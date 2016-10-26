package pl.altkom.shop.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	@Inject
	ProductRepo repo;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String product(Model model,
			@RequestParam(value = "query", required = false) String query)
			throws IOException {

		model.addAttribute("products", repo.getAll(query));

		return "product/product-list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list/pdf")
	public String pdfView(Model model,
			@RequestParam(value = "query", required = false) String query)
			throws IOException {

		model.addAttribute("products", repo.getAll(query));

		return "ProductPDFView";
	}

	@RequestMapping(value = "/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		repo.delete(id);
		return "redirect:/product/list";

	}

	@RequestMapping(value = "/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Product product = repo.find(id);
		model.addAttribute("product", product);
		return "product/product-form";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute @Valid Product product,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		try {
			if (product.getId() == null) {
				repo.insert(product);
			} else {
				repo.update(product);
			}
		} catch (Exception e) {
			bindingResult.reject("backed.error");
		}

		if (bindingResult.hasErrors()) {
			return "product/product-form";
		}

		redirectAttributes.addFlashAttribute("operationDone", true);
		return "redirect:/product/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newProduct(Model model) {
		Product product = new Product();
		product.setQuantity(10);
		product.setPrice(BigDecimal.ONE);
		model.addAttribute("product", product);
		return "product/product-form";

	}

}
