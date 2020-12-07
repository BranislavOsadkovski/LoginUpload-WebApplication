/**
 * Copyright the original author or authors.
 */
package com.usermanager.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Branislav
 *
 */
@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "address1",length = 150)
	private String address1;
	
	@Column(name = "address2",length = 150)
	private String address2;
	
	@ManyToOne
	private City city;

	/**
	 *  must not be null
	 */
	public Address() {
		super();
	}

	/**
	 * @param id
	 * @param address1
	 * @param address2
	 * @param city must not be null
	 */
	public Address(Long id, String address1, String address2, City city) {
		super();
		this.id = id;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
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
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
	
	
	
}
