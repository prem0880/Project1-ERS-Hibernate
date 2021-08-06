package com.ers.dao;

import org.hibernate.Session;

import com.ers.entity.EmployeeEntity;
import com.ers.model.Employee;
import com.ers.utility.EmployeeMapper;
import com.ers.utility.HibernateUtil;

public class EmployeeLoginDaoImpl implements EmployeeLoginDao {

	
	
	@Override
	public Boolean checkLogin(Employee e) {
	
		Boolean stat=false; 
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			EmployeeEntity ee=EmployeeMapper.mapEmployee(e);
			if (session != null) {
				   try {
				    EmployeeEntity ee1 =  session.get(EmployeeEntity.class, ee.getId());
				    if (e.getPassword().equals(ee1.getPassword())) {
				     System.out.println("User: " + ee1.toString());
				     stat=true;
				    }
				   } 
				   catch (Exception exception) {
				    System.out.println("Exception occured while reading user data: "
				      + exception.getMessage());
				    stat=false;
				   }

				  }
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		return stat;
		
	}
}
