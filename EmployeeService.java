package com.example.first.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.first.demo.entity.Employee;
import com.example.first.demo.mathutils.MathCalculation;
import com.example.first.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
    @Autowired
	EmployeeRepository employeeRepository;
	
	
	public String addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee Added successfully";
		}
	
	public List<Employee> getAllEmployees(int pageNo, int pageSize, String sortOrder){
//		Pageable pageable = PageRequest.of(pageNo,pageSize, sortOrder.equals("asc") ? Sort.by("name").ascending() : Sort.by("name").descending());
//		Page<Employee> empList = employeeRepository.findAll(pageable);
        List<Employee> empList = employeeRepository.findAll();
        empList.forEach(emp -> emp.setName("Mr." + emp.getName()));
        return empList;
        }
	
	public Employee getSingleEmployee(int empId) {
		Optional<Employee> emp = employeeRepository.findById(empId);
        return emp.isPresent() ? emp.get() : null;
        }
	
	public Employee getEmployeeByName(String name) {
		Optional<Employee> emp = employeeRepository.findByName(name);
        return emp.isPresent() ? emp.get() : null;
        }
	
	public String updateEmployee(Employee emp, int empId) {
		Optional<Employee> emp1= employeeRepository.findById(empId);
		if(emp1.isPresent()) {
			emp1.get().setName(emp.getName());
			emp1.get().setEmail(emp.getEmail());
			employeeRepository.save(emp1.get());
			return"Employee updated successfully";
			
		}else {
			return "Employee Not Found";
		}	
	}
	
	public String deleteEmployee(int id) {
		Optional<Employee> deleteEmployee= employeeRepository.findById(id);
		if(deleteEmployee.isPresent()) {
			employeeRepository.deleteById(id);
			return"Employee deleted successfully";
			
		}else {
			return "Employee Not Found";
		}
	}


	public int getEmployeeCount() {
		int count = employeeRepository.getEmpcount();
		return count;
	}

	public long getEmployeeCountByJpa() {
		
		return employeeRepository.count();
	}
	 
	 public int add(int a,int b) {
		 MathCalculation obj = new MathCalculation();
		 return obj.add(a, b);
	 }

	public int addAndDouble(int no1, int no2) {
		MathCalculation obj = new MathCalculation();
		int addition = obj.addAndDouble(no1,no2);
		return addition;
	}
}
