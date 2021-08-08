package com.ers.dao;

import java.util.List;

import org.hibernate.Session;

import com.ers.entity.EmployeeReimbursementEntity;

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
	
	@Override
	public List<EmployeeReimbursementEntity> viewPendingRequest(EmployeeReimbursement er) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
	    return session.createQuery("FROM EmployeeReimbursementEntity R WHERE R.StatusOfApplication = 0 ", EmployeeReimbursementEntity.class).getResultList();		  
		
	}
	
	@Override
	public List<EmployeeReimbursementEntity> viewResolvedRequest(EmployeeReimbursement er) {
	
		Session session=HibernateUtil.getSessionFactory().openSession();
	    return session.createQuery("FROM EmployeeReimbursementEntity R WHERE R.StatusOfApplication = 1 ", EmployeeReimbursementEntity.class).getResultList();	
	
	}
	
	
	
	
}
