package pl.altkom.shop.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/altkom")
@Controller
public class AltkomController {
	@RequestMapping
	public void action(HttpServletResponse res) throws Exception {
		System.out.println("mam");
		res.getWriter().append("siem");
	}
}
