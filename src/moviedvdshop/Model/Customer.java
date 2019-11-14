/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedvdshop.Model;

import moviedvdshop.Util.IdFactory;

/**
 *
 * @author thor
 */
public class Customer {
	int customerid;
	String phone;
	String email;
	String name;
	String address;
	String city;
	String postalcode;

	public Customer(String phone) {
		//for new customer
		this.phone = phone;
		this.customerid = IdFactory.getCustomerId();
	}
	public Customer(int id) {
		// for existing  customer
		this.customerid = id;
	}

	public int getCustomerid() {
		return customerid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	

		
}
