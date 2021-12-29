package com.userprofile.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserInfo")
public class UserProfileInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "email_id")
	private String emailid;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "photo_path")
	private String photopath;

	public UserProfileInfo() {
		super();
	}	

	public UserProfileInfo(long id, String fullName, String emailid, String password, String photopath) {
		this.id = id;
		this.fullName = fullName;
		this.emailid = emailid;
		this.password = password;
		this.photopath = photopath;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	
	
}
