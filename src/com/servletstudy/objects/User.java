package com.servletstudy.objects;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement(name = "user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String lastname;
	private String email;
	private String profession;
	
	public User() {	}

	public User(int id,String name,String profession) {
		this.id = id;
		this.name = name;
		this.profession=profession;
	}
	
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
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
}
