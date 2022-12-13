package com.hcl.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.exception.SourceNotFoundException;
import com.hcl.model.User;
import com.hcl.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repouser;
	public User saveUser(User u)
	{
		User saved = repouser.save(u);
		return saved;
		
	}
   public User login(String email,String password)
   {
	   User user = null;
		   Optional<User> uemail =  repouser.findByEmail(email);
		    try {
	        user = uemail.get();
		// throw new UserException("Your email is incorrect");
	  //  if(user != null && user.getPassword().equals(password)==true)
		       //   return user;
	// else return null;
	        
		    }
		    catch(NoSuchElementException e1)
		    {
		    	throw new SourceNotFoundException("Your email id is wrong");
		    }
		    if(user== null)
		    	   throw new SourceNotFoundException("Your email id and password is incorrect");
		    if(user.getPassword().equals(password)==true)
		    	return user;
		    else
		    	throw new SourceNotFoundException("Your password is wrong");
       
}
}
