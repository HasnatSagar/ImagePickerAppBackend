package com.userprofile.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userprofile.main.exception.ResourceNotFoundException;
import com.userprofile.main.model.UserProfileInfo;
import com.userprofile.main.repository.UserProfileRepository;

@CrossOrigin

@RestController
@RequestMapping("/api/v1/")
public class UserProfileController {
	
	@Autowired
	private  UserProfileRepository userProfileRepository;
	
	//Rest API for Getting all Users
	@GetMapping("/users")
	public List<UserProfileInfo> getAllUsers(){
		return userProfileRepository.findAll();
	}
	
	//Rest API for Creating Users
	@PostMapping("/users")
	public UserProfileInfo createUser(@RequestBody UserProfileInfo userprofileinfo) {
		return userProfileRepository.save(userprofileinfo);
	}
	
	//Rest API for Getting Users by ID
	@GetMapping("/users/{id}")
	public ResponseEntity<UserProfileInfo> getUserById(@PathVariable Long id) {
		UserProfileInfo userprofileinfo = userProfileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id!"));
		return ResponseEntity.ok(userprofileinfo);
	}
	
	//Rest API for Update Users
	@PutMapping("/users/{id}")
	public ResponseEntity<UserProfileInfo> updateUserProfile(@PathVariable Long id,@RequestBody UserProfileInfo userProfileDetails) {
		UserProfileInfo userprofileinfo = userProfileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id!"));
		userprofileinfo.setFullName(userProfileDetails.getFullName());
		userprofileinfo.setEmailid(userProfileDetails.getEmailid());
		userprofileinfo.setPassword(userProfileDetails.getPassword());
		userprofileinfo.setPhotopath(userProfileDetails.getPhotopath());
		
		UserProfileInfo updatedUserProfile = userProfileRepository.save(userprofileinfo);
		return ResponseEntity.ok(updatedUserProfile);
	}
}
