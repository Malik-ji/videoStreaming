package com.example.Test.model;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeDetails")
public class EmployeeDetails implements Serializable{

	private static final long serialVersionUID = 3741437190869694001L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;


	private String name;
	
	private int Age;
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	private String DoDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	
	private FirstDetails firstname;
	public FirstDetails getFirstname() {
		return firstname;
	}
	public void setFirstname(FirstDetails firstname) {
		this.firstname = firstname;
	}
	private String Lastname;
	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", Age=" + Age + ", DoDate=" + DoDate + ", Firstname="
				+ firstname + ", Lastname=" + Lastname + ", Userame=" + Userame + ", Password=" + Password + "]";
	}
	private String Userame;
	
	private String Password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDoDate() {
		return DoDate;
	}
	public void setDoDate(String doDate) {
		DoDate = doDate;
	}
	
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getUserame() {
		return Userame;
	}
	public void setUserame(String userame) {
		Userame = userame;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
