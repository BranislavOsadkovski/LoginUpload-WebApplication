package com.usermanager.objects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.usermanager.security.UserRole;

@XmlRootElement(name = "user")
@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;
	@NotNull
	@Column(name = "adminname", length = 60,unique = true)
	private String username;
	@NotNull
	@Column(name = "adminpassword", length = 80)
	private String password;
	@NotNull
	@Column(name="name",length = 150)
	private String name;
	@NotNull
	@Column(name="lastname",length = 150)
	private String lastname;
	@NotNull
	@Column(name="email",length = 50,unique = true)
	private String email;
	@NotNull
	@Column(name="profession",length = 30)
	private String profession;
	@NotNull
	@Column(name="role",length=10)
	private UserRole userRole;
	@NotNull
	@OneToOne
	private Address address;
	
	public User() {
	}

	
	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param name
	 * @param lastname
	 * @param email
	 * @param profession
	 * @param userRole
	 * @param address must not be null
	 */
	public User(Long id, String username, String password, String name, String lastname, String email,
			String profession, UserRole userRole, Address address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.profession = profession;
		this.userRole = userRole;
		this.address = address;
	}


	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	@XmlElement
	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getLastname() {
		return lastname;
	}

	@XmlElement
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
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
	 * @return the userRole
	 */
	public UserRole getUserRole() {
		return userRole;
	}


	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	
}
