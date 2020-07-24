package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private int cId;
	private String cName;
	private String cEmail;
	
	public Customer() {}
	
	public Customer(int cId, String cName, String cEmail) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cEmail = cEmail;
	}
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cEmail=" + cEmail + "]";
	}
	
	
}
