package com.medicine.impl;

import java.util.ArrayList;
import java.util.List;

import com.medicine.dao.MedicineDao;
import com.medicine.model.Medicine;

public class MedicineDaoImpl implements MedicineDao {
	// Define arraylist of Name medList of Class Medicine to pass the obj of
	// medicine class
	int count = 50;
	ArrayList<Medicine> medList = new ArrayList<Medicine>(count);

	@Override
	// insert
	public Medicine addMedicine(Medicine medicine) {
		boolean flag = true;
		medList.add(medicine);
		System.out.println(medList);

		System.out.println(medList.size());
		if (flag == false)

			return null;
		else

			return medicine;
		// count ;

	}

	@Override
	// search by name of the disease
	public List<Medicine> findMedByDisease(String disease) {
		// Medicine medicine = new Medicine();
		boolean exist = false;
		for (int i = 0; i < count; i++) {
			if (medList.get(i).getDisease().compareTo(disease) == 0) {

				exist = true;
				break;
			}
		}
		if (exist == true)
			return medList;
		else
			return null;

	}

	@Override
	// delete medicine by name of the medicine Id
	public void delMedById(int medId) {

		Medicine delete = medList.remove(medId);
		if (delete == null) {
			System.out.println("medicine not deleted");
		} else

		{
			System.out.println("medicine deleted successfully!!");
		}

	}

	@Override
	// update medicine by name of the medicine Id
	public void updateMedById(int medId) {

	}

}
