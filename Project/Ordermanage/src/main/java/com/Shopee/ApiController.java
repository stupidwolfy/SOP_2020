package com.Shopee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@GetMapping(value = "/order/{orderid}", produces = "application/json")
	public Order OrderApiGet(@PathVariable int orderid) {
		Order order = new Order(5);
		order.addShop("shop01");

		// model.addAttribute("hello",hello);
		// model.addAttribute("person",person);
		return order;
	}

	@PostMapping(value = "/order/{orderid}", consumes = "application/json", produces = "application/json")
	public Order PrderApiPost(@PathVariable int orderid, @RequestBody Order order) {
		order.addShop("shop555");
		order.setDatenow();

		// model.addAttribute("hello",hello);
		// model.addAttribute("person",person);
		return order;
	}

}