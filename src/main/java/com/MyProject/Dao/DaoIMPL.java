package com.MyProject.Dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MyProject.Model.Employee;


@Repository
public class DaoIMPL implements DaoI{
	

	@Autowired
	private SessionFactory sf;
	
	

	@Override
	public Employee addemployee(Employee employee) {
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		 Serializable save = session.save(employee);
		session.getTransaction().commit();
	
		System.out.println(save);
		
		Employee employee2 = session.get(Employee.class,save);
		
		
		return employee2;
		
		
	}

	@Override
	public List<Employee> Addmultiple(List<Employee> employee) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		for(Employee e:employee)
		{
			session.save(e);
		}
		session.getTransaction().commit();
	
		
		
		
		return employee;
	}

	@Override
	public Employee getbyid(Integer id) {
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		String hql=" from Employee";
		
		Query query = session.createQuery(hql);
		
		List<Employee> resultList = query.getResultList();
		
		for(Employee e:resultList)
		{
			if(id==e.getId())
			{
				return e;
			}
		}
		
		session.getTransaction().commit();
		
		
		return null;
	}

	@Override
	public List<Employee> getall() {
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		String hql="from Employee";
		Query query = session.createQuery(hql);
		List resultList = query.getResultList();
		
		session.getTransaction().commit();
		
		return resultList;
	}

	@Override
	public Employee update(Employee employee) {

Session session = sf.openSession();
		
		session.beginTransaction();
		
		 session.update(employee);
		 
		 
		 Employee employee2 = session.get(Employee.class,employee.getId() );
		session.getTransaction().commit();
		
		return (Employee) employee2;
		
	}

	@Override
	public List<Employee> updateMultiple(List<Employee> employee) {
		Session session = sf.openSession();
		session.beginTransaction();
		for(Employee e:employee)
		{
			session.update(e);
			
			
			
		}
		session.getTransaction().commit();
		
		return employee;
		
		
	}

	@Override
	public Employee login(String name, String pwd) {
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		String hql="from Employee";
		
		Query query = session.createQuery(hql);
		List<Employee> resultList = query.getResultList();
		
		
		
		for(Employee e:resultList)
		{
			if((e.getName().equals(name))&&( e.getPwd().equals(pwd)))
			{
				session.getTransaction().commit();
				return (Employee)e;
	
			
			}


		}
		
		return null;
		
	}

	@Override
	public void deleteAll() {

		Session session = sf.openSession();
		
		session.beginTransaction();
		
		
		String hql="delete from Employee";
		
		Query query = session.createQuery(hql);
		int executeUpdate = query.executeUpdate();
		
		session.getTransaction().commit();
		
		
		
		
		}

	@Override
	public void deletebyid(Integer id) {

		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		Employee employee = session.get(Employee.class,id);
		session.delete(employee);
		session.getTransaction().commit();
		 
	}

	
}
