package com.Shopee;

import java.util.List;
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

	@GetMapping(value = "/order/user/{user_id}", produces = "application/json")
	public List<Cart> getCartofUser(@PathVariable String user_id) throws InterruptedException, ExecutionException {
		return cartService.getCartall(user_id);
	}

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

	@PostMapping(value = "/order/product/{orderid}", consumes = "application/json", produces = "application/json")
	// Add product to cart
	public String addProduct(@PathVariable int orderid, @RequestBody Product newproduct)
			throws InterruptedException, ExecutionException {
		Cart cart = cartService.getCart(orderid);
		if (cart == null) {
			return "Not Found";
		}
		cart.addProduct(newproduct);
		cartService.saveCart(cart);

		return "Added";
	}

	@PatchMapping(value = "/order/product/{orderid}", consumes = "application/json", produces = "application/json")
	// Update product in cart
	public String updateProduct(@PathVariable int orderid, @RequestBody Product newproduct)
			throws InterruptedException, ExecutionException {
		Cart cart = cartService.getCart(orderid);
		if (cart == null) {
			return "Not Found";
		}
		String result = cart.replaceProduct(newproduct);
		if (result == "Product replaced") {
			cartService.saveCart(cart);
		}

		return result;

	}

	@PatchMapping(value = "/order/promotion/{orderid}/{promocode}")
	// Update product in cart
	public String updatePromotion(@PathVariable int orderid, @PathVariable String promocode)
			throws InterruptedException, ExecutionException {
		Cart cart = cartService.getCart(orderid);
		if (cart == null) {
			return "Not Found";
		}
		cart.setPromotion(promocode);
		cartService.saveCart(cart);

		return "Pomotion added";

	}

	@DeleteMapping(value = "/order/product/{orderid}/{productid}", produces = "application/json")
	public String deleteCart(@PathVariable int orderid, @PathVariable int productid)
			throws InterruptedException, ExecutionException {
		Cart cart = cartService.getCart(orderid);
		if (cart == null) {
			return "Not Found";
		}
		String result = cart.removeProduct(productid);
		if (result == "Product removed") {
			cartService.saveCart(cart);
		}
		return result;
	}

	@GetMapping(value = "/dummy/product/{id}", produces = "application/json")
	public DummyProdcut getDummyProduct(@PathVariable int id) throws InterruptedException, ExecutionException {
		switch (id) {
		case 1:
			return new DummyProdcut(1, "product1", "abcd", "abcd",
					"https://media.giphy.com/media/jpbnoe3UIa8TU8LM13/giphy.gif", 123, 100, 5, 11);
		case 2:
			return new DummyProdcut(2, "product2", "abcd", "abcd",
					"https://media.giphy.com/media/Nm8ZPAGOwZUQM/giphy.gif", 321, 12, 1, 11);
		case 3:
			return new DummyProdcut(3, "product3", "abcd", "abcd",
					"https://media.giphy.com/media/mlvseq9yvZhba/giphy.gif", 150, 200, 2, 22);

		default:
			return new DummyProdcut(3, "abcd", "abcd", "abcd", "https://media.giphy.com/media/mlvseq9yvZhba/giphy.gif",
					150, 200, 2, 22);
		}
	}

	@GetMapping(value = "/dummy/shop/{id}", produces = "application/json")
	public DummyShop getDummyShop(@PathVariable int id) throws InterruptedException, ExecutionException {
		switch (id) {
		case 11:
			return new DummyShop(11, 1, "aaaa.png", "Too shop", "Sell good thing", "dunno", 112, 0.5f);
		case 22:
			return new DummyShop(22, 2, "bbbb.png", "Pom shop", "Sell not buy", "dunno too", 44, 2.5f);
		case 33:
			return new DummyShop(33, 3, "ccccc.png", "O shop", "Sell nothing bad", "still dunno", 12, 4.5f);

		default:
			return new DummyShop(33, 3, "ccccc.png", "O shop", "Sell nothing bad", "still dunno", 12, 4.5f);
		}
	}

}