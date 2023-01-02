package com.cdp.spring.database.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "person") // No ned of this annotation if table and entity names are same
@Entity
public class Person {

	@Id
	@GeneratedValue
	private int id;
// 	@Column(name="name") // No ned of this annotation if table and entity column names are same
	private String name;
	private String location;
	private Date birthDate;

	// required no arg constructor as we used BeanPropertyRowMapper on dao
	public Person() {
	}

	public Person(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public Person(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}

}
