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
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "name",length = 100)
	private String name;
	
	@ManyToOne
	private Country country;

	public City() {}
	
	
	/**
	 * @param id
	 * @param name
	 * @param country must not be null
	 */
	public City(Integer id, String name, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
}
