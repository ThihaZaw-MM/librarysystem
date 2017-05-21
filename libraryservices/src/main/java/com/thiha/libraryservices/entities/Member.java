package com.thiha.libraryservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
public class Member {
	@Id
	@Column(name = "MemberID")
	private String id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Sex")
	private String sex;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "Address")
	private String address;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "Email")
	private String email;
	@Column(name = "Education")
	private String education;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
}
