package com.yemzashop.Entities;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class ProductEntityDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN")
	private Long id ;
	
	@Column(name = "title")
	private String title ;
	
	@Column(name = "description")
	private String description ; 
	
	@Column(name = "price")
	private Double price  ;
	
	@Column(name = "quantity")
	private Long quantity ;
	
	@Column(name = "shortDesc")
	private String shortDesc ;
	
	@Column(name = "image")
	private String image;
	
	
	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = false)
	private CategoryEntityDAO  categoryEntityDAO ;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "productid")
	private Set<ProductImages> productImages;
	
	@OneToMany(mappedBy = "productEntityDAO", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	List<OrderDetailsEntityDAO> orderDetails  = new ArrayList<>();


	@OneToOne(mappedBy="product")
	private BasketEntityDAO basketEntityDAO;
	
	public ProductEntityDAO() {
		// TODO Auto-generated constructor stub
	}



	public ProductEntityDAO(Long id, String title, String description, Double price, Long quantity, String shortDesc,
			String image, CategoryEntityDAO categoryEntityDAO, Set<ProductImages> productImages,
			List<OrderDetailsEntityDAO> orderDetails) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.shortDesc = shortDesc;
		this.image = image;
		this.categoryEntityDAO = categoryEntityDAO;
		this.productImages = productImages;
		this.orderDetails = orderDetails;
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



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public Long getQuantity() {
		return quantity;
	}



	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}



	public String getShortDesc() {
		return shortDesc;
	}



	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public CategoryEntityDAO getCategoryEntityDAO() {
		return categoryEntityDAO;
	}



	public void setCategoryEntityDAO(CategoryEntityDAO categoryEntityDAO) {
		this.categoryEntityDAO = categoryEntityDAO;
	}



	public Set<ProductImages> getProductImages() {
		return productImages;
	}



	public void setProductImages(Set<ProductImages> productImages) {
		this.productImages = productImages;
	}



	public List<OrderDetailsEntityDAO> getOrderDetails() {
		return orderDetails;
	}



	public void setOrderDetails(List<OrderDetailsEntityDAO> orderDetails) {
		this.orderDetails = orderDetails;
	}





}
