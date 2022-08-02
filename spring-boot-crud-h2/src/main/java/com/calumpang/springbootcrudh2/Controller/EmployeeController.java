package com.calumpang.springbootcrudh2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calumpang.springbootcrudh2.Entity.Employee;
import com.calumpang.springbootcrudh2.Service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	 
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee getAllEmployee(@PathVariable int id){
		return employeeService.findEmployeeById(id);
	}
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee emp) {
		 return employeeService.saveEmployee(emp);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		 return employeeService.updateEmployee(emp);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable int id){
		employeeService.deleteEmployee(id);
	}
}
