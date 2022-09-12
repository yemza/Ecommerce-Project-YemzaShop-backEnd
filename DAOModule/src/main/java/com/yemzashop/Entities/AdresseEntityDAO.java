package com.yemzashop.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Adresses")
public class AdresseEntityDAO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN")
	private Long id ;
	
	@Column(name = "line1")
	private String line1 ;
	
	@Column(name = "line2")
	private String line2 ;
	
	@Column(name = "city")
	private String city ;
	
	@Column(name = "state")
	private String state ;
	
	@Column(name = "country")
	private String country ;
	
	@Column(name = "phone")
	private String phone ;
	
	@Column(name = "pinCode")
	private String pinCode ;
	
	@OneToOne(mappedBy ="adresseEntityDAO")
	 private UserEntityDAO userEntityDAO;

	
	public AdresseEntityDAO() {
		// TODO Auto-generated constructor stub
	}


	public AdresseEntityDAO(Long id, String line1, String line2, String city, String state, String country,
			String phone, String pinCode) {
		super();
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone = phone;
		this.pinCode = pinCode;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLine1() {
		return line1;
	}


	public void setLine1(String line1) {
		this.line1 = line1;
	}


	public String getLine2() {
		return line2;
	}


	public void setLine2(String line2) {
		this.line2 = line2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
}
