package com.yemzashop.Entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class ProductEntityDAO {
	
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private Long id ;
	
	@Column(name = "title")
	private String title ;
	
	@Column(name = "description")
	private String description ; 
	
	@Column(name = "price")
	private String price  ;
	
	@Column(name = "quantity")
	private String quantity ;
	
	@Column(name = "shortDesc")
	private String shortDesc ;
	
	@Column(name = "images")
	private String images;
	
	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = false)
	private CategoryEntityDAO  categoryEntityDAO ;
	
   @OneToMany(mappedBy = "productEntityDAO", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
   List<OrderDetailsEntityDAO> orderDetails  = new ArrayList<>();


	
	public ProductEntityDAO() {
		// TODO Auto-generated constructor stub
	}


	public ProductEntityDAO(Long id, String title, String description, String price, String quantity, String shortDesc,
			CategoryEntityDAO categoryEntityDAO, String images) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.shortDesc = shortDesc;
		this.categoryEntityDAO = categoryEntityDAO;
		this.images = images;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getShortDesc() {
		return shortDesc;
	}


	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}


	public CategoryEntityDAO getCategory() {
		return categoryEntityDAO;
	}


	public void setCategory(CategoryEntityDAO categoryEntityDAO) {
		this.categoryEntityDAO = categoryEntityDAO;
	}


	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}
	
	

}
