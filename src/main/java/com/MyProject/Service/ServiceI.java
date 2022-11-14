package com.MyProject.Service;

import java.util.List;

import com.MyProject.Model.Employee;



public interface ServiceI {
	
public Employee addemployee(Employee employee);
	
	public List<Employee> Addmultiple(List<Employee> employee);
	
	public Employee getbyid(Integer id);
	
	public List<Employee> getall();
	
	public Employee update(Employee employee);
	
	public List<Employee> updateMultiple(List<Employee> employee);
	
	public Employee login(String name,String pwd);
	
	public void deleteAll();
	
	public void deletebyid(Integer id);
	

}
