package com.hcl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cloth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cName;
	private String cType;
	private float cPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public float getcPrice() {
		return cPrice;
	}

	public void setcPrice(float cPrice) {
		this.cPrice = cPrice;
	}

	public Cloth() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cloth(int id, String cName, String cType, float cPrice) {
		super();
		this.id = id;
		this.cName = cName;
		this.cType = cType;
		this.cPrice = cPrice;
	}

	@Override
	public String toString() {
		return "Cloth [id=" + id + ", cName=" + cName + ", cType=" + cType + ", cPrice=" + cPrice + "]";
	}

	public Cloth(int id) {
		super();
		this.id = id;
	}

}
