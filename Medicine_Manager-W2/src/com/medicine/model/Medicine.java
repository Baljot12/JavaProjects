package com.medicine.model;

import java.util.Date;

//medicine model class
public class Medicine {
	private int medId;
	private String medName;
	private Date dateOfManufacturing;
	private Date dateOfExpiry;
	private String medQuantity;
	private String disease;

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public Date getDateOfManufacturing() {
		return dateOfManufacturing;
	}

	public void setDateOfManufacturing(Date dateOfManufacturing) {
		this.dateOfManufacturing = dateOfManufacturing;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getMedQuantity() {
		return medQuantity;
	}

	public void setMedQuantity(String medQuantity) {
		this.medQuantity = medQuantity;
	}

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicine(int medId, String medName, Date dateOfManufacturing, Date dateOfExpiry, String medQuantity,
			String disease) {
		super();
		this.medId = medId;
		this.medName = medName;
		this.dateOfManufacturing = dateOfManufacturing;
		this.dateOfExpiry = dateOfExpiry;
		this.medQuantity = medQuantity;
		this.disease = disease;
	}

	@Override

	public String toString() {
		return "Medicine [medId=" + medId + ", medName=" + medName + ", dateOfManufacturing=" + dateOfManufacturing
				+ ", dateOfExpiry=" + dateOfExpiry + ", medQuantity=" + medQuantity + ", disease=" + disease + "]";
	}

}
