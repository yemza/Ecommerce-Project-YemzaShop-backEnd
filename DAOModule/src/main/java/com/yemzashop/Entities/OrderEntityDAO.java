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
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN")
	private Long id ;
	
	@ManyToOne
	@JoinColumn(name="userId",  insertable = false, updatable = false)
	private UserEntityDAO userEntityDAO;

    @OneToMany(mappedBy = "orderEntityDAO", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<OrderDetailsEntityDAO> orderDetails  = new ArrayList<>();
	
	
	public OrderEntityDAO() {
		// TODO Auto-generated constructor stub
	}


	


	public OrderEntityDAO(Long id, UserEntityDAO userEntityDAO, List<OrderDetailsEntityDAO> orderDetails) {
		super();
		this.id = id;
		this.userEntityDAO = userEntityDAO;
		this.orderDetails = orderDetails;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}




	public UserEntityDAO getUserEntityDAO() {
		return userEntityDAO;
	}





	public void setUserEntityDAO(UserEntityDAO userEntityDAO) {
		this.userEntityDAO = userEntityDAO;
	}





	public List<OrderDetailsEntityDAO> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(List<OrderDetailsEntityDAO> orderDetails) {
		this.orderDetails = orderDetails;
	}


	

}
