package com.ers.dao;

import java.util.List;

import com.ers.entity.EmployeeReimbursementEntity;
import com.ers.model.EmployeeReimbursement;

public interface EmployeeReimbursementDao {

	public void addRequest(EmployeeReimbursement er);
	
	public List<EmployeeReimbursementEntity>  viewPendingRequest(EmployeeReimbursement er);
	
}
