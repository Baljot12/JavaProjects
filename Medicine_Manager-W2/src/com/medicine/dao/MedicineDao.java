package com.medicine.dao;

import java.util.List;

import com.medicine.model.Medicine;

//interface for medicine dao operations
public interface MedicineDao {
	public Medicine addMedicine(Medicine medicine);

	public List<Medicine> findMedByDisease(String disease);

	public void delMedById(int medId);

	public void updateMedById(int medId);
}
