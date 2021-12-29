package com.example.first.demo.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.first.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findByName(String name);
    
	@Query(value="select count(*) from employee", nativeQuery = true)
	int getEmpcount();

}
	