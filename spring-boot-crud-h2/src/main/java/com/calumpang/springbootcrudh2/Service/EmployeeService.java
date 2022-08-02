package com.calumpang.springbootcrudh2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calumpang.springbootcrudh2.Entity.Employee;
import com.calumpang.springbootcrudh2.IService.IEmployeeService;
import com.calumpang.springbootcrudh2.Repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(Integer empId) {
		return employeeRepository.findById(empId).orElse(null);
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee existingEmployee = employeeRepository.findById(emp.getEmpId()).orElse(null);
		if(existingEmployee != null) {
			existingEmployee.setEmpFirstName(emp.getEmpFirstName());
			existingEmployee.setEmpLastName(emp.getEmpLastName());
			existingEmployee.setEmpAddress(emp.getEmpAddress());
			return employeeRepository.save(existingEmployee);
		}else {
			throw new NullPointerException("Employee does not exist!");
		}
	}

	@Override
	public void deleteEmployee(Integer empId) {
		employeeRepository.deleteById(empId);
	}
}
