package com.hcl.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@OneToOne
	@JoinColumn(name = "userid")
	private User userid;
	@OneToOne
	@JoinColumn(name = "clothid")
	private Cloth clothid;
	private int quanty;

	public Cart(int cartId, User userid, Cloth clothid, int quanty) {
		super();
		this.cartId = cartId;
		this.userid = userid;
		this.clothid = clothid;
		this.quanty = quanty;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub(cascade = CascadeType.ALL)-->dont add this in @one to one
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public Cloth getClothid() {
		return clothid;
	}

	public void setClothid(Cloth clothid) {
		this.clothid = clothid;
	}

	public float getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userid=" + userid + ", clothid=" + clothid + ", quanty=" + quanty + "]";
	}

}
