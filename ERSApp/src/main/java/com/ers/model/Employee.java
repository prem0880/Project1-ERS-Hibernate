package com.ers.model;

public class Employee {

	private Integer Id;
	private String Name;
	private String Password;
	private String Designation;
	private String Department;
	private String Email;
	private String Type;
	
	
	public Employee() {
		super();
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}

	
	
	
}
