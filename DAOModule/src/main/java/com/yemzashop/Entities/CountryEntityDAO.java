package com.yemzashop.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class CountryEntityDAO {
	
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private Long id ;

    @Column(name = "nameContry")
	private String nameCountry;
	
	 @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	 @JoinColumn(name = "cities")
	 private Set<CityEntityDAO> cityEntityDAO;

	
	public CountryEntityDAO() {
		// TODO Auto-generated constructor stub
	}


	public CountryEntityDAO(Long id, String nameCountry) {
		super();
		this.id = id;
		this.nameCountry = nameCountry;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNameCountry() {
		return nameCountry;
	}


	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}


	public Set<CityEntityDAO> getCityEntityDAO() {
		return cityEntityDAO;
	}


	public void setCityEntityDAO(Set<CityEntityDAO> cityEntityDAO) {
		this.cityEntityDAO = cityEntityDAO;
	}
	
	
	
	

	
	
	
	
}
