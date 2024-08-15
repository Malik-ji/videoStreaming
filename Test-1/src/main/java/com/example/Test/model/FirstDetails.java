package com.example.Test.model;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class FirstDetails implements Serializable{

	private static final long serialVersionUID = -6671614360360386369L;
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "FirstDetails [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  id;
	
	private String username;
	private String password;
	
//	@OneToOne(mappedBy =  "firstname")
//	@MAna
//	private EmployeeDetails employeeDetails;
//
//	public EmployeeDetails getEmployeeDetails() {
//		return employeeDetails;
//	}
//	
//	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
//		this.employeeDetails = employeeDetails;
//	}
	
	
	
}
