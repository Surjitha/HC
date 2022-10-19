package com.springboot.healthcare.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int userid;
	@Column(name="center_list")
	private String centerlist;
	@Column(name="user_password")
	private int userpassword;
	@Column(name="user_name")
	private String username;
	@Column(name="contact_number")
	private BigInteger contactnumber;
	@Column(name="user_role")
	private String userrole;
	@Column(name="emaild_id")
	private String emailid;
	
	public User() {
		super();
	}

	public User(int userid, String centerlist, int userpassword, String username, BigInteger contactnumber,
			String userrole, String emailid) {
		super();
		this.userid = userid;
		this.centerlist = centerlist;
		this.userpassword = userpassword;
		this.username = username;
		this.contactnumber = contactnumber;
		this.userrole = userrole;
		this.emailid = emailid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getCenterlist() {
		return centerlist;
	}

	public void setCenterlist(String centerlist) {
		this.centerlist = centerlist;
	}

	public int getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(int userpassword) {
		this.userpassword = userpassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigInteger getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(BigInteger contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
	
}
