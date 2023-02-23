package com.codedecode.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController {
	@Autowired
	EmployeeServiceInterface employeeServiceInterface;

	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}

	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployees() {
		return employeeServiceInterface.findAll();
	}

	@GetMapping("/getEmpById/{id}")
	private Optional<Employee> getempbyid(@PathVariable("id") Long id) {
		return employeeServiceInterface.getempbyid(id);
	}

	@DeleteMapping("/deleteEmpById/{id}")
	private String deleteEmpolyee(@PathVariable("id") Long id) {
		return employeeServiceInterface.delete(id);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee updateResponse = employeeServiceInterface.update(employee);
		return updateResponse;
	}
}
