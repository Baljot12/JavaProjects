package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Cloth;
import com.hcl.service.ClothService;

@RestController
public class ClothController {
	@Autowired
	ClothService clService;

	@PostMapping("/saveCloth")
	public Cloth saveCloth(@RequestBody Cloth c) {
		Cloth saveCloth = clService.saveCloth(c);
		return saveCloth;
	}

	@GetMapping("/cloths")
	public List<Cloth> getAll() {
		return clService.getAll();
	}

	@GetMapping("/cloths/{id}")
	public Cloth findById(@PathVariable("id") int id) {
		return clService.getClothById(id);
	}

	@GetMapping("cloth/{cType}")
	public List<Cloth> getByType(@PathVariable("cType") String cType) {
		return clService.getClothsByT(cType);
	}

	@PutMapping("/updatecloth")
	public Cloth updateCloth(@RequestBody Cloth c) {
		return clService.updateCloth(c);
	}

	@DeleteMapping("/deleteCloth/{id}")
	public String delById(@PathVariable("id") int id) {
		return clService.deleteCloth(id);
	}

}
