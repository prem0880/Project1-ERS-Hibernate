package com.ers.dao;

import org.hibernate.Session;

import com.ers.model.Employee;
import com.ers.utility.EmployeeMapper;
import com.ers.utility.HibernateUtil;


public class EmployeeRegisterDaoImpl implements EmployeeRegisterDao{

	@Override
	public String addEmployee(Employee e) {
		
		String stat=null;
		try {
			System.out.println(e.getMail()+" "+e.getName());
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction(); 
			stat=(String) session.save(EmployeeMapper.mapEmployee(e));
			System.out.println("employee inserted...");
			session.getTransaction().commit();
			
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		return stat;
		
	}
	
}
