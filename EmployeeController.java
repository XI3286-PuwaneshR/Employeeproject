package com.example.first.demo.controller;

import java.util.List;



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

import com.example.first.demo.entity.Employee;
import com.example.first.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//@Autowired
	//EmployeeRepository employeeRepository;
	
    @PostMapping("/employee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
    	String message = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
    
    @GetMapping("employee/{pageNo}/{pageSize}/{order}")
    public List<Employee> getAllEmployee(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize,@PathVariable("order") String sortOrder) {
    	List<Employee> lstEmp = employeeService.getAllEmployees(pageNo,pageSize,sortOrder);
    	return lstEmp;
    }
    
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getSingleEmployee(@PathVariable("id") int empId) {
        Employee emp = employeeService.getSingleEmployee(empId);
        if (emp!=null) {
        	return ResponseEntity.status(HttpStatus.OK).body(emp);
        }else {
        	return ResponseEntity.status(HttpStatus.NO_CONTENT).body(emp);
        }
    }
    
    @GetMapping("/employee/byName/{name}")
    public ResponseEntity<Employee> getSingleEmployeeByName(@PathVariable("name") String name) {
        Employee emp = employeeService.getEmployeeByName(name);
        if (emp!=null) {
        	return ResponseEntity.status(HttpStatus.OK).body(emp);
        }else {
        	return ResponseEntity.status(HttpStatus.NO_CONTENT).body(emp);
        }
    }
    
    @PutMapping("employee/{id}")
    public String updateEmployee(@RequestBody Employee emp, @PathVariable("id")int empId) {
    	String message = employeeService.updateEmployee(emp,empId);
    	return message;
    }
    
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id")int empId) {
    	String message = employeeService.deleteEmployee(empId);
    	return message;
    }
    
  //  @GetMapping("employee/countBy/Name/{name}")
	//public int getStudentCountByName(@PathVariable String name) {
		//int count = employeeService.getEmployeeCountByName(name); 
		//return count;
	//}
	
	@GetMapping("/add/{no1}/{no2}")
	public int add(@PathVariable int no1, @PathVariable int no2) {
		int result = employeeService.add(no1,  no2);
		return result;
		
	}
	
	@GetMapping("/addAndDouble/{no1}/{no2}") 
		public int addAndDouble(@PathVariable int no1, @PathVariable int no2) {
			int result = employeeService.addAndDouble(no1,no2);
			return result;
		}
    
    
}
