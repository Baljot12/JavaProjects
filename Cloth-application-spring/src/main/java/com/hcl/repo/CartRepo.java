package com.hcl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Cart;
import com.hcl.model.User;

public interface CartRepo extends JpaRepository<Cart, Integer>{
	List<Cart> findCartByUserId(User id);

}
