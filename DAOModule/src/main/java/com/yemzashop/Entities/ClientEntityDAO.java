package com.yemzashop.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "clients")
public class ClientEntityDAO {
	
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private Long id ;
   
	@Column(name = "firstName")
	private String firstName  ;
	
	@Column(name = "lastName")
	private String lastName  ;
	
	@Column(name = "email")
	private String email  ;
	
	@Column(name = "phone")
	private Long phone  ;
	
	@OneToOne
    @JoinColumn(name = "AdresseId")
	private AdresseEntityDAO adresseEntityDAO;
	
    @OneToMany(mappedBy = "clientEntityDAO", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<OrderEntityDAO> orderEntityDAO = new ArrayList<>();
    
	@OneToOne(mappedBy="client")
	private BasketEntityDAO basketEntityDAO;
	
	
public ClientEntityDAO() {
	// TODO Auto-generated constructor stub
}

public ClientEntityDAO(Long id, String firstName, String lastName, String email, Long phone, AdresseEntityDAO adresseEntityDAO,
		List<OrderEntityDAO> orderEntityDAO) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	adresseEntityDAO = adresseEntityDAO;
	this.orderEntityDAO = orderEntityDAO;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Long getPhone() {
	return phone;
}

public void setPhone(Long phone) {
	this.phone = phone;
}

public AdresseEntityDAO getAdresseEntityDAO() {
	return adresseEntityDAO;
}

public void setAdresse(AdresseEntityDAO adresseEntityDAO) {
	adresseEntityDAO = adresseEntityDAO;
}

public List<OrderEntityDAO> getOrderEntityDAO() {
	return orderEntityDAO;
}

public void setOrderEntityDAO(List<OrderEntityDAO> orderEntityDAO) {
	this.orderEntityDAO = orderEntityDAO;
}




}
