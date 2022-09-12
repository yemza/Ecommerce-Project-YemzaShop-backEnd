package com.yemzashop.Entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "user")
@Inheritance(
	    strategy = InheritanceType.TABLE_PER_CLASS
	)
public class UserEntityDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO ,generator = "SEQ_GEN")
	private Long id ;
   
	@Column(name = "firstName")
	private String firstName  ;
	
	@Column(name = "lastName")
	private String lastName  ;
	
	@Column(name = "username",unique = true)
	private String username  ;
	
	@Column(name = "email", unique = true)
	private String email  ;
	
	@Column(name = "password")
	@JsonIgnore
	private String password  ;
	
	@Column(name = "phone")
	private Long phone  ;
	
	@OneToOne
    @JoinColumn(name = "AdresseId")
	private AdresseEntityDAO adresseEntityDAO;
	
    @OneToMany(mappedBy = "userEntityDAO", 
    		   cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
    private List<OrderEntityDAO> orderEntityDAO = new ArrayList<>();
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
	private List<BasketEntityDAO> basketEntityDAO;

	@ManyToMany
	@JoinTable( name = "Users_Role",
	   joinColumns = @JoinColumn(name="idUser"),
	   inverseJoinColumns = @JoinColumn( name = "idRole" ) )
	private List<RoleEntityDAO> roles = new ArrayList<>();
	 
	 public UserEntityDAO() {
	}

	public UserEntityDAO(Long id, String firstName, String lastName, String username, String email, String password,
			Long phone, AdresseEntityDAO adresseEntityDAO, List<OrderEntityDAO> orderEntityDAO,
			List<BasketEntityDAO> basketEntityDAO, List<RoleEntityDAO> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.adresseEntityDAO = adresseEntityDAO;
		this.orderEntityDAO = orderEntityDAO;
		this.basketEntityDAO = basketEntityDAO;
		this.roles = roles;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setAdresseEntityDAO(AdresseEntityDAO adresseEntityDAO) {
		this.adresseEntityDAO = adresseEntityDAO;
	}

	public List<OrderEntityDAO> getOrderEntityDAO() {
		return orderEntityDAO;
	}

	public void setOrderEntityDAO(List<OrderEntityDAO> orderEntityDAO) {
		this.orderEntityDAO = orderEntityDAO;
	}

	public List<BasketEntityDAO> getBasketEntityDAO() {
		return basketEntityDAO;
	}

	public void setBasketEntityDAO(List<BasketEntityDAO> basketEntityDAO) {
		this.basketEntityDAO = basketEntityDAO;
	}

	public List<RoleEntityDAO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntityDAO> roles) {
		this.roles = roles;
	}

	
	
	 
	 
	
}
