package com.calumpang.springbootcrudh2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calumpang.springbootcrudh2.Entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
