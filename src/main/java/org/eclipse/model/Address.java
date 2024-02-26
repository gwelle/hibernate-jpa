package org.eclipse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id ;
	private String street;
	private String zipCode ;
	private String city ;
	
	
	protected Address() {
	}


	public Address(String street, String zipCode, String city) {
		super();
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", zipCode=" + zipCode + ", city=" + city + "]";
	}

}
