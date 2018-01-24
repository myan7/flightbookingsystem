/**
 * 
 */
package com.bean;

import java.sql.Date;

/**
 * @author: Administrator
 * @date: Jan 4, 2018
 */
public class Customer {
	private int user_id; 
	private String fname;
	private String lname; 
	private String email;
	private String phone;
	private String DOB;
	private String address;
	private String passportNO;
	private String password;
	
	public Customer() 
	{
		
	}

	public Customer(int user_id, String fname, String lname, String email, String phone, String dOB, String address,
			String passportNO, String password) 
	{
		this.user_id = user_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.DOB = dOB;
		this.address = address;
		this.passportNO = passportNO;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassportNO() {
		return passportNO;
	}

	public void setPassportNO(String passportNO) {
		this.passportNO = passportNO;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
