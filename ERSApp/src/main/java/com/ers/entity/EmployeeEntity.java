package com.ers.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="Employee")
public class EmployeeEntity {

	@Id
	@Column(name="EmployeeId")
	private Integer Id;
	private String Name;
	private String Password;
	private String Designation;
	private String Department;
	private String Email;
	private String Type;
	
//	@OneToMany(mappedBy="EmployeeEntity",cascade=CascadeType.ALL)
//	private Set<EmployeeReimbursementEntity> rset;
//	
//	public Set<EmployeeReimbursementEntity> getRset() {
//		return rset;
//	}
//
//	public void setRset(Set<EmployeeReimbursementEntity> rset) {
//		this.rset = rset;
//	}

	public EmployeeEntity() {
		super();
	}
	
	public EmployeeEntity(Integer id) {
		super();
		Id = id;
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
	@Override
	public String toString() {
		return "EmployeeEntity [Id=" + Id + ", Name=" + Name + ", Password=" + Password + ", Designation=" + Designation
				+ ", Department=" + Department + ", Email=" + Email + ", Type=" + Type + "]";
	}
	
	

	
}
