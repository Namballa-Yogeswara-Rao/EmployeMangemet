package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);	
		
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional=employeeRepository.findById( id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
		}else {
			throw new RuntimeException("Employee not found for id ::"+ id);
			
		}
		return employee;
	}
	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
	}
	

}
