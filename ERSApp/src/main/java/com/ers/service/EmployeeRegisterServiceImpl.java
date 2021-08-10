package com.ers.service;

import com.ers.dao.EmployeeRegisterDaoImpl;
import com.ers.model.Employee;

public class EmployeeRegisterServiceImpl implements EmployeeRegisterService {

	EmployeeRegisterDaoImpl edao = new EmployeeRegisterDaoImpl();
	
	@Override
	public String addEmployee(Employee e) {
	
		return edao.addEmployee(e);	
		
	}
}
