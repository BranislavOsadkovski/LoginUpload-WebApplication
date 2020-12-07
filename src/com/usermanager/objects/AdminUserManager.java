/**
 * Copyright the original author or authors.
 */
package com.usermanager.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Branislav
 *
 */
@Entity
@Table(name = "adminusermanager")
public class AdminUserManager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "adminname", length = 60)
	private String username;

	@Column(name = "adminpassword", length = 80)
	private String password;

	@Column(name = "name", length = 150)
	private String name;
	
	@Column(name = "lastname", length = 150)
	private String lastname;
	
	@Column(name = "email", length = 50)
	private String email;

	@OneToOne
	private Address address;

	
	/**
	 *  must not be null
	 */
	public AdminUserManager() {
		super();
	}


	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param name
	 * @param lastname
	 * @param email
	 * @param address must not be null
	 */
	public AdminUserManager(Long id, String username, String password, String name, String lastname, String email,
			Address address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}


	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
