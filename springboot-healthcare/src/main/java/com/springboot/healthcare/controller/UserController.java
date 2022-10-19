package com.springboot.healthcare.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.healthcare.exception.ResourceNotFoundException;
import com.springboot.healthcare.model.User;
import com.springboot.healthcare.repository.UserRepository;


@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/api/hc")
public class UserController {
	@Autowired
	private UserRepository userrepository;
    //Get all user
	@GetMapping("user")
	public List<User> getAlluser(){
		return userrepository.findAll();
	}
	
	//Crud operations
		//Create
		@PostMapping("/user")
		public User createEmployee(@RequestBody User user) {
			return userrepository.save(user);
		}
		
		//get employee by Id rest API
		@GetMapping("/user/{userid}")
	    public ResponseEntity<User> getUserById(@PathVariable int userid) {
	        User user = userrepository.findById(userid)
	                .orElseThrow(() ->
	                new ResourceNotFoundException("user not exists with id: " + userid));
	        return ResponseEntity.ok(user);
	    }
		
		//update employee rest API
		@PutMapping("/user/{userid}")
		public ResponseEntity<User> updateUser(@PathVariable int userid,  
				@RequestBody User userDetails){
			User user = userrepository.findById(userid)
					.orElseThrow( ()-> 
					new ResourceNotFoundException("User not exist with id;" +userid));
			user.setCenterlist(userDetails.getCenterlist());
			user.setUserpassword(userDetails.getUserpassword());
			user.setUsername(userDetails.getUsername());
			user.setContactnumber(userDetails.getContactnumber());
			user.setUserrole(userDetails.getUserrole());
			user.setEmailid(userDetails.getEmailid());
			User updateUser=userrepository.save(user);
			return ResponseEntity.ok(updateUser);
			
		}
		@DeleteMapping("/user/{userid}")
	    public Map<String, Boolean> deleteUser(@PathVariable(value = "userid") int userId)
	         throws ResourceNotFoundException {
	        User user = userrepository.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        userrepository.delete(user);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}


