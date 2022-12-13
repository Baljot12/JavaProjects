package com.hcl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Cloth;

public interface ClothRepo extends JpaRepository<Cloth, Integer>{
	List<Cloth> getClothsBycType(String cType);

}
