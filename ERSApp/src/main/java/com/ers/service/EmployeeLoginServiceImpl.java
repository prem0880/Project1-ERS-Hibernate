package com.ers.service;

import com.ers.dao.EmployeeLoginDao;
import com.ers.dao.EmployeeLoginDaoImpl;
import com.ers.model.Employee;

public class EmployeeLoginServiceImpl implements EmployeeLoginService {

	EmployeeLoginDao edao = new EmployeeLoginDaoImpl();
	
	@Override
	public Boolean checkLogin(Employee e) {
	
		return edao.checkLogin(e);
		
	}
}
