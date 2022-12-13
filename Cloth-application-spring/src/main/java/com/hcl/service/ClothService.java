package com.hcl.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.exception.SourceNotFoundException;
import com.hcl.model.Cloth;
import com.hcl.repo.ClothRepo;

@Service
public class ClothService {
	@Autowired
	private ClothRepo clothrepo;
	public Cloth saveCloth(Cloth c)
	{
		Cloth savecloth = clothrepo.save(c);
	     return savecloth;
	}
	public List<Cloth> getAll(){
		return clothrepo.findAll();
	}
	
	public List<Cloth> getClothsByT(String cType)
	{
		return clothrepo.getClothsBycType(cType);
	}
	public Cloth getClothById(int id)
	{  
		Cloth dbcloth = null;
		Optional<Cloth> cloth= clothrepo.findById(id);
	    try {
		dbcloth = cloth.get();
	    }
	    catch(NoSuchElementException e)
	    {
	    	throw new SourceNotFoundException("The record with id "+id+ " not exist");
	    }
	return dbcloth;
	}
	
	public Cloth updateCloth(Cloth c)
	{
	int id = c.getId();
	Cloth cget = getClothById(id);
	if(cget != null)
	{
		return clothrepo.save(c);
	}
	else return null;
	}
	public String deleteCloth(int id)
	{
		
		Cloth delcloth = getClothById(id);
		if(delcloth != null)
		{
		clothrepo.delete(delcloth);
		return "The record with id "+id+ "is deleted successfully!!";
		}
		else
			return "The record with "+id+ "not found";
	}
}
