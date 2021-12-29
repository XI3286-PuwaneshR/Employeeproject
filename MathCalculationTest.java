package com.example.first.demo.mathutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathCalculationTest {
	
	@Test
	public void testAdd() {
		
		MathCalculation mathCalculation = new MathCalculation();
		
		int result = mathCalculation.add(0,0);
		assertEquals(0, result);
		
		result = mathCalculation.add(2,2);
		assertEquals(4, result);
		
		result = mathCalculation.add(1,-1);
		assertEquals(0, result);
		
		result = mathCalculation.add(-1,-1);
		assertEquals(-2, result);
		
	}
	
//	@Test
//	public void testmulti() {
//		
//		MathCalculation mathCalculation = new MathCalculation();
//		
//		int result = mathCalculation.multi(0,0);
//		assertEquals(0, result);
//		
//		result = mathCalculation.multi(2,2);
//		assertEquals(4, result);
//		
//		result = mathCalculation.multi(1,-1);
//		assertEquals(-1, result);
//	}
//	
	@Test
	public void testaddAndDouble () {
		
		MathCalculation mathCalculation = new MathCalculation();
		
		int result = mathCalculation.addAndDouble (0,0);
		assertEquals(0, result);
		
		result = mathCalculation.addAndDouble (2,2);
		assertEquals(8, result);
		
		result = mathCalculation.addAndDouble   (1,-1);
		assertEquals(0, result);
	}
}

