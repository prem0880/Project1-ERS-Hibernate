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
	@Override
	public String checkLoginType(Employee e) {
	
		return edao.checkLoginType(e);
	}
	
	
	@Override
	public Employee ViewDetails(Employee e) {
	
		return edao.ViewDetails(e);
	}
	
	
	
	@Override
	public void UpdateDetails(Employee e) {
	
		edao.UpdateDetails(e);
	}
}
