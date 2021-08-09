package com.ers.dao;

import java.util.List;

import org.hibernate.Session;

import com.ers.entity.EmployeeEntity;
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
//		EmployeeReimbursementEntity e=EmployeeReimbursementMapper.mapReimbursement(er);
//		System.out.println(e.getEmployeeEntity().getId());
//		EmployeeEntity e1=new EmployeeEntity(e.getEmployeeEntity().getId());
//		//Integer id=e1.getId();
//		e.setEmployeeEntity(e1);
//		System.out.println(e.getEmployeeEntity().getId());
//		EmployeeReimbursementEntity ee1 =  session.load(EmployeeReimbursementEntity.class, e.getEmployeeEntity().getId());
//		Integer id1=ee1.getId();
//		System.out.println(ee1.getId());
//		Integer id=e.getEmployeeEntity().getId();
//		System.out.println(id);
//	
//		return session.createQuery("FROM EmployeeReimbursementEntity R WHERE R.StatusOfApplication = 0 AND R.employeeEntity = ed1 ", EmployeeReimbursementEntity.class).getResultList();
		
		return session.createQuery("FROM EmployeeReimbursementEntity R WHERE R.StatusOfApplication = 0 ", EmployeeReimbursementEntity.class).getResultList();
	}
	
	@Override
	public List<EmployeeReimbursementEntity> viewResolvedRequest(EmployeeReimbursement er) {
	
		Session session=HibernateUtil.getSessionFactory().openSession();
		return session.createQuery("FROM EmployeeReimbursementEntity R WHERE R.StatusOfApplication = 1 ", EmployeeReimbursementEntity.class).getResultList();	
	
	}
	
	
	
	
}
