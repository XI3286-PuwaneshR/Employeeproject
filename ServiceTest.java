package com.example.first.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.first.demo.entity.Employee;
import com.example.first.demo.repository.EmployeeRepository;

@SpringBootTest
public class ServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Test
	public void testGetAllEmployees() {
		
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "user1", "user1@email.com"));
		empList.add(new Employee(2, "user2", "user2@email.com"));
		empList.add(new Employee(3, "user3", "user3@email.com"));
		
		when(employeeRepository.findAll()).thenReturn(empList);
		
		List<Employee> actualEmpList =employeeService.getAllEmployees(0, 0, "asc");
		
		assertEquals(empList.size(),actualEmpList.size ());
	}
	@Test
	public void testGetSingleEmployee() {
		
		int id=3;
		Employee emp = new Employee (id,"user", "user@gmail.com");
		when(employeeRepository.findById(id)).thenReturn(Optional.of(emp));
		
		Employee actualEmp = employeeService.getSingleEmployee(id);
		
		assertEquals(emp.getName(), actualEmp.getName() );		
		
	}
	
	@Test
	public void testAddEmployee() {
		Employee employee = new Employee (1, "user", "user1@email.com");
		
		when(employeeRepository.save(employee)).thenReturn(null);
		
		String Msg="Employee Added successfully";
		String actualMsg = employeeService.addEmployee(employee);
		assertEquals(Msg,actualMsg);
	}
	
	@Test
	public void testUpdateEmployee()  {
		int id = 3;
		Employee emp = new Employee(id,"user","user@gmail.com");
		when(employeeRepository.findById(id)).thenReturn(Optional.of(emp));
		
		String Msg = "Employee updated successfully";
		String actualMsg = employeeService.updateEmployee(emp,id);
		assertEquals(Msg,actualMsg);
	}
	
	@Test
	public void testDeleteEmployee()  {
		int id = 3;
		Employee employee = new Employee(id,"user","user@gmail.com");
		when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
		
		String Msg = "Employee deleted successfully";
		String actualMsg = employeeService.deleteEmployee(id);
		assertEquals(Msg,actualMsg);
	}
}
//All test cases are running successfully