package com.yemzashop.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "orderDetails")
public class OrderDetailsEntityDAO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN")
	private Long id ;
	private Long quantity;	
	
	@ManyToOne
    @JoinColumn(name="orderId",insertable = false, updatable = false)
	private OrderEntityDAO orderEntityDAO;
	
	
   @ManyToOne
   @JoinColumn(name="productId", referencedColumnName = "id", insertable = false, updatable = false)
	private ProductEntityDAO productEntityDAO;

	
	
	public OrderDetailsEntityDAO() {
		// TODO Auto-generated constructor stub
	}



	public OrderDetailsEntityDAO(Long id, Long quantity, OrderEntityDAO orderEntityDAO,
			ProductEntityDAO productEntityDAO) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.orderEntityDAO = orderEntityDAO;
		this.productEntityDAO = productEntityDAO;
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



	public OrderEntityDAO getOrderEntityDAO() {
		return orderEntityDAO;
	}



	public void setOrderEntityDAO(OrderEntityDAO orderEntityDAO) {
		this.orderEntityDAO = orderEntityDAO;
	}



	public ProductEntityDAO getProductEntityDAO() {
		return productEntityDAO;
	}



	public void setProductEntityDAO(ProductEntityDAO productEntityDAO) {
		this.productEntityDAO = productEntityDAO;
	}




	
}
