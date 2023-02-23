package com.codedecode.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.repository.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {

		Employee savedEmployee = crudRepo.save(employee);
		return savedEmployee;

	}

	@Override
	public List<Employee> findAll() {
		List<Employee> emp = crudRepo.findAll();
		return emp;
	}

	@Override
	public Optional<Employee> getempbyid(Long id) {
		Optional<Employee> emp = crudRepo.findById(id);
		return emp;
	}

	@Override
	public String delete(Long id) {
		String msg = "Record Deleted Successfully";
		crudRepo.deleteById(id);
		return msg;
	}

	@Override
	public Employee update(Employee employee) {
		Employee updateResponse = crudRepo.save(employee);
		return updateResponse;
	}

}
