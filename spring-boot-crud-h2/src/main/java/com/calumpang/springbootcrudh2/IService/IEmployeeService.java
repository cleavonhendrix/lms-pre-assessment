package com.calumpang.springbootcrudh2.IService;

import java.util.List;

import com.calumpang.springbootcrudh2.Entity.Employee;

public interface IEmployeeService {
	List<Employee> getAllEmployee();
	
	Employee findEmployeeById(Integer empId);
	
	Employee saveEmployee(Employee emp);
	
	Employee updateEmployee(Employee emp);
	
	void deleteEmployee(Integer empId);
}
