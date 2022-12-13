package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Cart;
import com.hcl.model.User;
import com.hcl.repo.CartRepo;

@Service
public class CartService {
	@Autowired
	private CartRepo cartrepo;
	public Cart saveCart(Cart cart)
	{
		return cartrepo.save(cart);
	}
   public List<Cart> getList(int id)
   {
	   User u = new User(id);
	   List<Cart> cartofuser = cartrepo.findCartByUserId(u);
	   return cartofuser;
   }
}
