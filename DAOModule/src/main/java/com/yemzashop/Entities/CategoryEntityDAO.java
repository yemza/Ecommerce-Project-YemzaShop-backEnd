package com.yemzashop.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categories")

public class CategoryEntityDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN")
	   private Long id;
	   
	   @Column(name = "ctegoryName")
	   private String categoryName;
	   
	   @OneToMany(mappedBy = "categoryEntityDAO", cascade = CascadeType.ALL)
	   @JsonIgnore
	   private Set<ProductEntityDAO> productEntityDAO = new HashSet<ProductEntityDAO>(); 
	   
	   public CategoryEntityDAO() {
		// TODO Auto-generated constructor stub
	}


	public CategoryEntityDAO(Long id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	   
	   
	
	
}
