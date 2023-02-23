package com.codedecode.demo.service;

import java.util.List;
import java.util.Optional;

import com.codedecode.demo.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> findAll();

	public Optional<Employee> getempbyid(Long id);

	public String delete(Long id);

	public Employee update(Employee employee);

}
