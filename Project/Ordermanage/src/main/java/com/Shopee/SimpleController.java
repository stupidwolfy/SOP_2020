package com.Shopee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

	@GetMapping("/")
	public String homePage(ModelMap model) {
		String hello = "Hello Too!";
		model.addAttribute("testHello", hello);
		return "home";
	}

	// @GetMapping("/cart")
	// public String cart() {
	// return "index";
	// }

	@GetMapping("/order")
	public String order() {
		return "index";
	}
}