package com.example.Test.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loandetails implements Serializable{
	

	private static final long serialVersionUID = -3598657130277032896L;
	private String loanDoc;
	private String loanId;
	private String loanuser;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Override
	public String toString() {
		return "Loandetails [loanDoc=" + loanDoc + ", loanId=" + loanId + ", loanuser=" + loanuser + ", id=" + id + "]";
	}

	public String getLoanDoc() {
		return loanDoc;
	}

	public void setLoanDoc(String loanDoc) {
		this.loanDoc = loanDoc;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getLoanuser() {
		return loanuser;
	}

	public void setLoanuser(String loanuser) {
		this.loanuser = loanuser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
