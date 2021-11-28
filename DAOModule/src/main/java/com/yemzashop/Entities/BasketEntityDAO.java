package com.yemzashop.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Basket")
public class BasketEntityDAO {

	
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private Long id ;
	private Long quantity;
	
    @OneToOne
	private ProductEntityDAO product;
	 
    @OneToOne
    private ClientEntityDAO client;
    
    
	public BasketEntityDAO() {
		// TODO Auto-generated constructor stub
	}


	public BasketEntityDAO(Long id, Long quantity, ProductEntityDAO product, ClientEntityDAO client) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.client = client;
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





	public ClientEntityDAO getClient() {
		return client;
	}





	public void setClient(ClientEntityDAO client) {
		this.client = client;
	}







}
