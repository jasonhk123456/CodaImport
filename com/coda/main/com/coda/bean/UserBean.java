package com.coda.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userbean")
public class UserBean {
	private String first_name;
	private String last_name;
	private String company_name;
	private String address;
	private String city;
	private String county;
	private String state;
	private Integer zip;
	@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Must not contain numbers")
	private String phone1;
	@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Must not contain numbers")
	private String phone2;
	@Email
	private String email;
	private String web;

	public String getFirst_name() {
		return first_name;
	}

	@XmlElement(name = "first_name")
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	@XmlElement(name = "last_name")
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	@XmlElement(name = "company_name")
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getAddress() {
		return address;
	}

	@XmlElement(name = "address")
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	@XmlElement(name = "city")
	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	@XmlElement(name = "county")
	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	@XmlElement(name = "state")
	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	@XmlElement(name = "zip")
	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getPhone1() {
		return phone1;
	}

	@XmlElement(name = "phone1")
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	@XmlElement(name = "phone2")
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	@XmlElement(name = "web")
	public void setWeb(String web) {
		this.web = web;
	}

}
