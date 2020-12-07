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
	
}
