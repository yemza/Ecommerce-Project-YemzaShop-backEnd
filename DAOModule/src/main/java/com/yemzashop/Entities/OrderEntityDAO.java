package com.yemzashop.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.*;

@Entity
@Table(name = "orders")
public class OrderEntityDAO {
	
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private Long id ;
	
	
	 @ManyToOne
	 @JoinColumn(name="clientId",  insertable = false, updatable = false)
	 private ClientEntityDAO clientEntityDAO;

    @OneToMany(mappedBy = "orderEntityDAO", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<OrderDetailsEntityDAO> orderDetails  = new ArrayList<>();
	
	
	public OrderEntityDAO() {
		// TODO Auto-generated constructor stub
	}


	public OrderEntityDAO(Long id, ClientEntityDAO clientEntityDAO, List<OrderDetailsEntityDAO> orderDetails) {
		super();
		this.id = id;
		this.clientEntityDAO = clientEntityDAO;
		this.orderDetails = orderDetails;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ClientEntityDAO getClientEntityDAO() {
		return clientEntityDAO;
	}


	public void setClientEntityDAO(ClientEntityDAO clientEntityDAO) {
		this.clientEntityDAO = clientEntityDAO;
	}


	public List<OrderDetailsEntityDAO> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(List<OrderDetailsEntityDAO> orderDetails) {
		this.orderDetails = orderDetails;
	}


	

}
