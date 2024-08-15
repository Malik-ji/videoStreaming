package com.example.Test.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DocTransModel")
public class DocTransModel implements Serializable{

	
	private static final long serialVersionUID = -1564436896106881243L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String barcode;
	private String entity_barcode;
	private String application_id;
	private String lan;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getEntity_barcode() {
		return entity_barcode;
	}
	public void setEntity_barcode(String entity_barcode) {
		this.entity_barcode = entity_barcode;
	}
	public String getApplication_id() {
		return application_id;
	}
	public void setApplication_id(String application_id) {
		this.application_id = application_id;
	}
	public String getLan() {
		return lan;
	}
	public void setLan(String lan) {
		this.lan = lan;
	}
	@Override
	public String toString() {
		return "DocTransModel [id=" + id + ", barcode=" + barcode + ", entity_barcode=" + entity_barcode
				+ ", application_id=" + application_id + ", lan=" + lan + "]";
	}
	
	
	
}
