package com.Shopee;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@Autowired
	CartService cartService;

	@GetMapping(value = "/order/{id}", produces = "application/json")
	public Cart getCart(@PathVariable int id) throws InterruptedException, ExecutionException {
		return cartService.getCart(id);
	}
	/*
	 * public Cart OrderApiGet(@PathVariable int id) { //Dummy data Product product1
	 * = new Product(12, "Spoon", "https://www.google.com/spoon", 30, 150, 5, 5);
	 * Product product2 = new Product(14, "Table", "https://www.google.com/table",
	 * 200, 2, 2, 7); Promotion promo = new Promotion(5);
	 * 
	 * Cart cart = new Cart(id); cart.setUser_id(1234); cart.setDatenow();
	 * cart.addProduct(product1, product2); cart.setPromotion(promo);
	 * 
	 * return cart; }
	 */

	@PostMapping(value = "/order/", consumes = "application/json")
	public String craeteCart(@RequestBody Cart cart) throws InterruptedException, ExecutionException {
		return cartService.saveCart(cart);
	}
	/*
	 * public Order OrderApiPost(@PathVariable int orderid, @RequestBody Order
	 * order) { //Dummy data order.addShop("shop555"); order.setDatenow();
	 * 
	 * // model.addAttribute("hello",hello); // model.addAttribute("person",person);
	 * return order; }
	 */

	@PutMapping(value = "/order/", consumes = "application/json")
	public String updateAllCart(@RequestBody Cart cart) throws InterruptedException, ExecutionException {
		return cartService.updateCart(cart);
	}

	@PatchMapping(value = "/order/addProduct/{id}", consumes = "application/json", produces = "application/json")
	public String updateCart(@PathVariable int id, @RequestBody Product newproduct)
			throws InterruptedException, ExecutionException {
		// return cartService.PatchCart(id, "product", fieldvalue);
		Cart cart = cartService.getCart(id);
		if (cart == null) {
			return "Not Found";
		}
		cart.addProduct(newproduct);
		cartService.saveCart(cart);
		
		return "Added";
	}

	@DeleteMapping(value = "/order/{id}", produces = "application/json")
	public String deleteCart(@PathVariable int id) throws InterruptedException, ExecutionException {
		return cartService.deleteCart(id);
	}

	@GetMapping(value = "/dummy/product/{id}", produces = "application/json")
	public DummyProdcut getDummyCart(@PathVariable int id) throws InterruptedException, ExecutionException {
		switch (id) {
		case 1:
			return new DummyProdcut(1, "product1", "abcd", "abcd", "zzzz1.jpg", 123, 100, 5, 234);
		case 2:
			return new DummyProdcut(2, "product2", "abcd", "abcd", "zzz2.jpg", 321, 12, 1, 234);
		case 3:
			return new DummyProdcut(3, "product3", "abcd", "abcd", "zzz3.jpg", 150, 200, 2, 555);

		default:
			return new DummyProdcut(3, "abcd", "abcd", "abcd", "abc.jpg", 150, 200, 2, 555);
		}
	}

}