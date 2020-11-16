package com.Shopee;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String updateCart(@RequestBody Cart cart) throws InterruptedException, ExecutionException {
		return cartService.updateCart(cart);
	}
	
	@DeleteMapping(value = "/order/{id}", produces = "application/json")
	public String  deleteCart(@PathVariable int id) throws InterruptedException, ExecutionException {
		return cartService.deleteCart(id);
	}
	

	/*
	 * @GetMapping(value = "/cart/{cartid}", produces = "application/json") public
	 * OrderFull OrderFullApiGet(@PathVariable int cartid) {
	 * 
	 * // Dummy data Order order = new Order(5); order.addShop("shop06", "shop05");
	 * Order order2 = new Order(6); order2.addShop("shop01", "shop02");
	 * 
	 * OrderFull orderfull = new OrderFull(cartid);
	 * orderfull.setAddress("1/2 zzzzzz somewhere Thailand 123425");
	 * orderfull.addOrder(order, order2); orderfull.setName("zzzzzzz123");
	 * orderfull.setPayment("Some Payment"); orderfull.setShipping("Ship to abcd");
	 * orderfull.setTotalPrice(4999); orderfull.setPayShipping(123);
	 * orderfull.setPromotion("promocode555");
	 * 
	 * // model.addAttribute("hello",hello); // model.addAttribute("person",person);
	 * return orderfull; }
	 */

	/*
	 * @PostMapping(value = "/cart/{cartid}", consumes = "application/json",
	 * produces = "application/json") public OrderFull
	 * OrderFullApiPost(@PathVariable int cartid, @RequestBody OrderFull orderfull)
	 * {
	 * 
	 * // Dummy data Order order = new Order(999); order.addShop("shop44",
	 * "shop55"); Order order2 = new Order(123); order2.addShop("shop12", "shop21");
	 * 
	 * orderfull.addOrder(order, order2);
	 * 
	 * // model.addAttribute("hello",hello); // model.addAttribute("person",person);
	 * return orderfull; }
	 */

}