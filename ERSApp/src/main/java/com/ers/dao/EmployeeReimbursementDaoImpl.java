package com.ers.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ers.entity.EmployeeEntity;
import com.ers.entity.EmployeeReimbursementEntity;

import com.ers.model.EmployeeReimbursement;
import com.ers.utility.HibernateUtil;
import com.ers.utility.EmployeeReimbursementMapper;

public class EmployeeReimbursementDaoImpl implements EmployeeReimbursementDao {

	@Override
	public Integer addRequest(EmployeeReimbursement er) {
		
		Integer stat=0;
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction(); 
			stat=(Integer)session.save(EmployeeReimbursementMapper.mapReimbursement(er));
			System.out.println("employee inserted...");
			session.getTransaction().commit();

		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		return stat;
	
	}
	
	@Override
	public List<EmployeeReimbursementEntity> viewPendingRequest(EmployeeReimbursement er) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		return session.createQuery("FROM EmployeeReimbursementEntity R WHERE R.StatusOfApplication = 'pending'  ", EmployeeReimbursementEntity.class).getResultList();
	}
	
	@Override
	public List<EmployeeReimbursementEntity> viewResolvedRequest(EmployeeReimbursement er) {
	
		Session session=HibernateUtil.getSessionFactory().openSession();
		return session.createQuery("FROM EmployeeReimbursementEntity R WHERE R.StatusOfApplication = 'approve' OR R.StatusOfApplication = 'reject' ", EmployeeReimbursementEntity.class).getResultList();	
	
	}
	
	
	@Override
	public List<Integer> requestAction() {
		List<Integer> list=new ArrayList<Integer>();
		Session session=HibernateUtil.getSessionFactory().openSession();
		Query query=session.createQuery("select r.id from EmployeeReimbursementEntity r where r.StatusOfApplication= 'pending'");
		list=query.list();
		for(int x:list) {System.out.println(x);}
		return list;
	}
	
	@Override
	public void responseAction(EmployeeReimbursement er) {
	
		try{
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		EmployeeReimbursementEntity rid=session.load(EmployeeReimbursementEntity.class,er.getId());
		rid.setStatusOfApplication(er.getStatusOfApplication());
		session.merge(rid);
		System.out.println("status...");
		session.getTransaction().commit();
		session.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
}
