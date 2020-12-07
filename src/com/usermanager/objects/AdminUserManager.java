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
}
