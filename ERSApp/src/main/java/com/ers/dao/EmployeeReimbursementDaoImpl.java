package com.ers.dao;

import org.hibernate.Session;

import com.ers.model.EmployeeReimbursement;
import com.ers.utility.HibernateUtil;
import com.ers.utility.EmployeeReimbursementMapper;

public class EmployeeReimbursementDaoImpl implements EmployeeReimbursementDao {

	
	
	@Override
	public void addRequest(EmployeeReimbursement er) {
		
		
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction(); 
			session.save(EmployeeReimbursementMapper.mapReimbursement(er));
			System.out.println("employee inserted...");
			session.getTransaction().commit();
			
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}

		
		
		
	}
}
