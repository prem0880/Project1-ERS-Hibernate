package com.ers.service;

import java.util.List;

import com.ers.entity.EmployeeEntity;
import com.ers.model.Employee;

public interface EmployeeLoginService {

	public Boolean checkLogin(Employee e);
	
	public String checkLoginType(Employee e);
	
	public Employee ViewDetails(Employee e);
	
	public List<EmployeeEntity> ViewAllDetails();
}
