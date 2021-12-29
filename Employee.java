package com.example.first.demo.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
  
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="org_loc_id")
//	private orgLocation orgLocation;
	
	
	//@ManyToOne
	//@JoinColumn(name="dept_id")
    //private Department department;
    



} 