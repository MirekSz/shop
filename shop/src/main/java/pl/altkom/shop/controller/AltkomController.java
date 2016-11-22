package pl.altkom.shop.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class AltkomController {

	@RequestMapping("/new")
	public void hello(HttpServletResponse response) throws Exception {
		response.getWriter().print("new");
	}

	@RequestMapping("/edit/{id}")
	public void edit(HttpServletResponse response, @PathVariable("id") Long id)
			throws Exception {
		response.getWriter().print("edit");
	}
}
