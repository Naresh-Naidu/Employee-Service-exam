package com.creatingBean.CreatingBean.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creatingBean.CreatingBean.module.Employee;
import com.creatingBean.CreatingBean.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public ResponseEntity<String> createEmplyee(@RequestBody Employee employee){
		log.info("request for creating employee");
		return new ResponseEntity<String>(employeeService.createEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		log.info("request for get all employee");
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<List<Employee>> getEmployee(@PathVariable Integer id){
		log.info("request for get "+id+" employee");
		return new ResponseEntity<List<Employee>>(employeeService.getEmployee(id), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("department/{departmentName}")
	public ResponseEntity<List<Employee>> getBydepartment(@PathVariable String departmentName){
		log.info("request for get "+departmentName+" employee");
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByDepartment(departmentName), HttpStatus.ACCEPTED);
	}
}
