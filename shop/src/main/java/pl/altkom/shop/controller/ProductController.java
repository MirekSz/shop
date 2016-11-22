package pl.altkom.shop.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Inject
	ProductRepo repo;

	@RequestMapping("/list")
	public String list(@RequestParam(required = false, value = "page") Integer page, Model model) throws Exception {
		List<Product> products = repo.getAll();
		model.addAttribute("products", products);
		model.addAttribute("page", page);
		return "product/product-list";
	}

	@RequestMapping("/list.pdf")
	public String listAsPdf(@RequestParam(required = false, value = "page") Integer page, Model model) throws Exception {
		List<Product> products = repo.getAll();
		model.addAttribute("products", products);
		model.addAttribute("page", page);
		return "productPDFView";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String prepareForm(Model model) throws Exception {
		Product product = new Product();
		product.setName("name " + System.currentTimeMillis());
		model.addAttribute("product", product);
		return "product/product-form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute @Valid Product product, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) throws Exception {
		if (bindingResult.hasErrors()) {
			return "product/product-form";
		}

		if (product.getId() != null) {
			repo.update(product);
		} else {
			repo.insert(product);
		}
		redirectAttributes.addFlashAttribute("opDone", true);
		return "redirect:/product/list";
	}

	@RequestMapping("/{id}/delete")
	public String delte(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) throws Exception {
		repo.delete(id);
		redirectAttributes.addFlashAttribute("opDone", true);
		return "redirect:/product/list";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) throws Exception {
		Product product = repo.find(id);
		model.addAttribute("product", product);
		return "product/product-form";
	}

}
