package com.yemzashop.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="role")
public class RoleEntityDAO {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO ,generator = "SEQ_GEN")
	private Long id ;
   
	@Column(name = "RoleName")
	private String RoleName;
	
	@ManyToMany
    @JoinTable( name = "T_Users_Roles_Associations",
		        joinColumns = @JoinColumn( name = "idRole" ),
		        inverseJoinColumns = @JoinColumn( name = "idUser" ) )
	    private List<UserEntityDAO> users = new ArrayList<>();

	public RoleEntityDAO() {
	}
	
	public RoleEntityDAO(Long id, String roleName, List<UserEntityDAO> users) {
		super();
		this.id = id;
		RoleName = roleName;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public List<UserEntityDAO> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntityDAO> users) {
		this.users = users;
	}
	
	
	
}
