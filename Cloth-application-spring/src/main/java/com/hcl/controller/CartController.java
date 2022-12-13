package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Cart;
import com.hcl.service.CartService;

@RestController
public class CartController {
	@Autowired
	private CartService cartService;
	
	@PostMapping("/user/cart")
	public Cart addCart(@RequestBody Cart cart)
	{
		return cartService.saveCart(cart);
	}
	

}
