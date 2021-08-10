package com.ers.dao;

import org.hibernate.Session;

import com.ers.model.Employee;
import com.ers.utility.EmployeeMapper;
import com.ers.utility.HibernateUtil;


public class EmployeeRegisterDaoImpl implements EmployeeRegisterDao{

	@Override
	public void addEmployee(Employee e) {
		
		try {
			System.out.println(e.getMail()+" "+e.getName());
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction(); 
			session.save(EmployeeMapper.mapEmployee(e));
			System.out.println("employee inserted...");
			session.getTransaction().commit();
			
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}

		
	}
	
}
