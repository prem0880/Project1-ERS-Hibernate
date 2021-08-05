package com.ers.utility;

import com.ers.entity.EmployeeEntity;
import com.ers.model.Employee;

public class EmployeeMapper {
	
	public static EmployeeEntity mapEmployee(Employee e) {
		EmployeeEntity entity=new EmployeeEntity();
		entity.setId(e.getId());
		entity.setName(e.getName());
		entity.setPassword(e.getPassword());
		entity.setDesignation(e.getDesignation());
		entity.setDepartment(e.getDepartment());
		entity.setEmail(e.getEmail());
		entity.setType(e.getType());
		return entity;
		
	}

}
