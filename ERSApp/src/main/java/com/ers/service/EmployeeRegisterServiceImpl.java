package com.ers.service;

import com.ers.dao.EmployeeRegisterDaoImpl;
import com.ers.model.Employee;

public class EmployeeRegisterServiceImpl implements EmployeeRegisterService {

	EmployeeRegisterDaoImpl edao = new EmployeeRegisterDaoImpl();
	
	@Override
	public void addEmployee(Employee e) {
	
	edao.addEmployee(e);	
		
	}
}
