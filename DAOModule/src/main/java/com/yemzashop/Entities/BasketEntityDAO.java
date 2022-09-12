package com.yemzashop.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Basket")
public class BasketEntityDAO {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN")
	private Long id ;
	private Long quantity;
	
    @ManyToOne
    @JoinColumn( name="idProduct" )
	private ProductEntityDAO product;
	 

    @ManyToOne
    @JoinColumn( name="idUser" )
    private UserEntityDAO user;
    
    
	public BasketEntityDAO() {
		// TODO Auto-generated constructor stub
	}

	public BasketEntityDAO(Long id, Long quantity, ProductEntityDAO product, UserEntityDAO user) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.user = user;
	}








	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public Long getQuantity() {
		return quantity;
	}





	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}





	public ProductEntityDAO getProduct() {
		return product;
	}





	public void setProduct(ProductEntityDAO product) {
		this.product = product;
	}








	public UserEntityDAO getUser() {
		return user;
	}








	public void setUser(UserEntityDAO user) {
		this.user = user;
	}











}
