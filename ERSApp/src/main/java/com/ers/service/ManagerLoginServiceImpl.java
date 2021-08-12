package com.ers.service;

import java.util.List;

import com.ers.dao.ManagerLoginDao;
import com.ers.dao.ManagerLoginDaoImpl;
import com.ers.entity.EmployeeEntity;
import com.ers.entity.EmployeeReimbursementEntity;
import com.ers.model.EmployeeReimbursement;

public class ManagerLoginServiceImpl implements ManagerLoginService{

	
	ManagerLoginDao mld= new ManagerLoginDaoImpl();
	
	@Override
	public List<EmployeeEntity> ViewAllDetails() {

    return	mld.ViewAllDetails();
	
	}
	
	@Override
	public List<Integer> requestAction() {
		return mld.requestAction();
	}
	@Override
	public void responseAction(EmployeeReimbursement er) {
		mld.responseAction(er);
		
	}
	@Override
	public List<EmployeeReimbursementEntity> viewAllPendingRequest(EmployeeReimbursement er) {
		
		return mld.viewAllPendingRequest(er);
	}
	@Override
	public List<EmployeeReimbursementEntity> viewAllResolvedRequest(EmployeeReimbursement er) {
	
		return mld.viewAllResolvedRequest(er);
	}
}
