package com.ers.dao;

import java.util.List;

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
				    System.out.println(ee1.getType());
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
	@Override
	public String checkLoginType(Employee e) {
	
	String stat="null"; 
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			EmployeeEntity ee=EmployeeMapper.mapEmployee(e);
			if (session != null) {
				   try {
					EmployeeEntity ee1 =  session.get(EmployeeEntity.class, ee.getId());
					System.out.println(ee1.toString());
					if (ee1.getType().equals("manager")) {
							System.out.println("manager here!!!");
				    		stat="manager";
				     }
				    else if(ee1.getType().equals("employee"))
				    {
				    	System.out.println("employee here!!!");
				    		stat="employee";
				    }
				    
				   } 
				   catch (Exception e1) {
					   e1.printStackTrace();
				   }

				  }
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		return stat;

	}
	
	
	
	@Override
	public Employee ViewDetails(Employee e) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		EmployeeEntity ee=EmployeeMapper.mapEmployee(e);
		if (session != null) {
			   try {
				EmployeeEntity ee1 =  session.get(EmployeeEntity.class, ee.getId());
				//System.out.println(ee1.getId()+" "+ee1.getName()+" "+ee1.getDesignation()+" "+ee1.getDepartment()+" "+ee1.getEmail()+" "+ee1.getType()); 
//				e.setId(ee1.getId());
//				e.setName(ee1.getName());
//				e.setDesignation(ee1.getDesignation());
//				e.setDepartment(ee1.getDepartment());
//				e.setEmail(ee1.getEmail());
//				e.setType(ee1.getType());

				e = new Employee(ee1.getId(),ee1.getName(),ee1.getDesignation(),ee1.getDepartment(),ee1.getEmail(),ee1.getType());
				
			   }   catch (Exception e1) {
				   e1.printStackTrace();
			   }
			   
		
		
		}
		   return e;
	}
	
	@Override
	public List<EmployeeEntity> ViewAllDetails() {
	
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		return session.createQuery("FROM EmployeeEntity", EmployeeEntity.class).getResultList();
		
		
	}
	
	
	
	@Override
	public void UpdateDetails(Employee e) {
	
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction(); 
			EmployeeEntity ee=EmployeeMapper.mapEmployee(e);
			if(session!=null) {
				
				EmployeeEntity ee1 =  session.get(EmployeeEntity.class, ee.getId());
				
				if(ee1.getName().equals(e.getName()) == false) {
				ee1.setName(e.getName());}
				if(ee1.getDesignation().equals(e.getDesignation()) == false) {
				ee1.setDesignation(e.getDesignation());}
				if(ee1.getDepartment().equals(e.getDepartment()) == false) {
				ee1.setDepartment(e.getDepartment());}
				if(ee1.getEmail().equals(e.getEmail()) == false) {
				ee1.setEmail(e.getEmail());}
				
				session.saveOrUpdate(ee1);
				System.out.println("Employee Details Updated...");
				session.getTransaction().commit();
				
				
			}
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
	}
	
}
