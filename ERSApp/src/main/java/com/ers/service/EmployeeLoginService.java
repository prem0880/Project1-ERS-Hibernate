package com.ers.service;

import com.ers.model.Employee;

public interface EmployeeLoginService {

	public Boolean checkLogin(Employee e);
	
	public String checkLoginType(Employee e);
}
