package com.MyProject.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyProject.Model.Employee;
import com.MyProject.Service.ServiceI;


@RestController
public class EmployeeController {
	

	@Autowired
	private ServiceI impl;
	
	@PostMapping(value = "/addemp",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Employee> add(@RequestBody Employee employee)
	{
		
		Employee employee2 = impl.addemployee(employee);
		
		
		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/addmultii",produces = "application/json",consumes = "application/json")
	public ResponseEntity<List<Employee>> addmulti(@RequestBody List<Employee> employee)
	{
		List<Employee> addmultiple = impl.Addmultiple(employee);
		
		if(addmultiple!=null)
		{
			return new ResponseEntity<List<Employee>>(addmultiple,HttpStatus.CREATED);
		}
		
		List<Employee> ll=new ArrayList<>();
		
		ll.add(null);
		
		return new ResponseEntity<List<Employee>>(ll,HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping(value = "/getall" ,produces  = "application/json")
	public ResponseEntity<List<Employee>> getall()
	{
		List<Employee> getall = impl.getall();
		if(getall!=null)
		{
			return new ResponseEntity<List<Employee>>(getall,HttpStatus.OK);
		}
		return new ResponseEntity<List<Employee>>(getall,HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/getbyid/{id}",produces = "application/json")
	public ResponseEntity<Employee> getbyid(@PathVariable Integer id)
	{
		Employee getbyid = impl.getbyid(id);
		
		if(getbyid!=null)
		{
			return new ResponseEntity<Employee>(getbyid,HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(getbyid,HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(value = "/update",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Employee> update(@RequestBody Employee employee)
	{
		Employee update = impl.update(employee);
		
		
		
		return new ResponseEntity<Employee>(update,HttpStatus.BAD_REQUEST);
		
	}
	
	@PutMapping(value = "/updatemultiple",produces = "application/json",consumes = "application/json")
	public ResponseEntity<List<Employee>> updatemulti(@RequestBody List<Employee> employee)
	{
		List<Employee> updateMultiple = impl.updateMultiple(employee);
		
			return new ResponseEntity<List<Employee>>(updateMultiple,HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/login",produces = "application/json")
	public ResponseEntity<Employee> login(String name,String pwd)
	{
		Employee login = impl.login(name, pwd);
		
		if(login!=null)
		{
			return new ResponseEntity<Employee>(login,HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(login,HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping(value = "/deleteall")
	public ResponseEntity<String> deleteall()
	{
		impl.deleteAll();
		
		return new ResponseEntity<String>("deleted all data",HttpStatus.OK);
		
	}
		
	
	    @DeleteMapping(value = "/deletebyid/{id}")
		public ResponseEntity<String> deletebyid(@PathVariable Integer id)
		{
			impl.deletebyid(id);
			return new ResponseEntity<String>("deleted perticular data",HttpStatus.OK);
		}
	    
	 
}
