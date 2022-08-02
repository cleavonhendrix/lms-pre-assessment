package com.calumpang.springbootcrudh2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.calumpang.springbootcrudh2.Entity.Employee;
import com.calumpang.springbootcrudh2.Repository.EmployeeRepository;

@DataJpaTest
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void testSaveEmployee() {
		Employee employee = Employee.builder()
				.empFirstName("junit")
				.empLastName("test")
				.empAddress("test junit").build();
		
		employeeRepository.save(employee);
		assertThat(employee.getEmpId()).isGreaterThan(0);
	}
	
	@Test
	void testGetAllEmployee() {
		Employee employee = Employee.builder()
				.empFirstName("junit1")
				.empLastName("test1")
				.empAddress("test junit1").build();
		
		employeeRepository.save(employee);
		
		List<Employee> empList = employeeRepository.findAll();
		assertThat(empList).size().isGreaterThan(0);
	}
	
	@Test
	void testGetEmployeeById() {
		Employee employee = Employee.builder()
				.empFirstName("junit1")
				.empLastName("test1")
				.empAddress("test junit1").build();
		
		employeeRepository.save(employee);
		
		assertThat(employeeRepository.findById(employee.getEmpId())).isNotEmpty();
	}

}
