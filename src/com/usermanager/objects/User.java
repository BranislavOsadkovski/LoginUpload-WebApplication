package com.usermanager.objects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name",length = 150)
	private String name;
	@Column(name="lastname",length = 150)
	private String lastname;
	@Column(name="email",length = 50)
	private String email;
	@Column(name="profession",length = 30)
	private String profession;
	@OneToOne
	private Address address;
	
	public User() {
	}

	
	public User(Long id, String name, String profession) {
		this.id = id;
		this.name = name;
		this.profession = profession;
	}

	
	/**
	 * @param id
	 * @param name
	 * @param lastname
	 * @param email
	 * @param profession
	 * @param address must not be null
	 */
	public User(Long id, String name, String lastname, String email, String profession, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.profession = profession;
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
	
}
