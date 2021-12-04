package com.yemzashop.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class CityEntityDAO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN")
	private Long id ;
	
	@Column(name = "nameCity")
	private String nameCity;

	
	public CityEntityDAO() {
		// TODO Auto-generated constructor stub
	}


	public CityEntityDAO(Long id, String nameCity) {
		super();
		this.id = id;
		this.nameCity = nameCity;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNameCity() {
		return nameCity;
	}


	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}
	

}
