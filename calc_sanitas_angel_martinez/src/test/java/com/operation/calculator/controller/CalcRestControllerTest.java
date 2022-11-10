package com.operation.calculator.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.http.ResponseEntity;



public class CalcRestControllerTest {


	@Test
	public void test() {
		List<String> RequestOperacionList = new ArrayList<String>();
		
		RequestOperacionList.add("100-2*3-(4+2)/5");
		RequestOperacionList.add("4+7/5");
		RequestOperacionList.add("1-50*3/2");
		RequestOperacionList.add("10.5*2+1");
		
		CalcRestController calc;
		ResponseEntity<String> valor = null;
		for (int i=0;i<RequestOperacionList.size();i++) 
		{
			calc = new CalcRestController();
	      		      
			valor = calc.getCalc(RequestOperacionList.get(i));
			
			System.out.println("Operación: "+RequestOperacionList.get(i));
			System.out.println("Resultado: "+valor.getBody()+"\n");	      		
		}
			
		assertEquals(valor.getStatusCode().name(),"OK");
	}

}
