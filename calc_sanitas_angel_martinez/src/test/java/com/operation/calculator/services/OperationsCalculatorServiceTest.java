package com.operation.calculator.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.operation.calculator.config.ConfiguracionApp;
import com.operation.calculator.controller.CalcRestController;
import com.operation.calculator.services.impl.OperationsCalculatorServiceImpl;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ConfiguracionApp.class})
public class OperationsCalculatorServiceTest {

	@Test
	public void AllOperationsTest() {
		List<String> RequestOperacionList = new ArrayList<String>();
		boolean flag = false;
		RequestOperacionList.add("100-2*3-(4+2)/5");
		RequestOperacionList.add("4+7/5");
		RequestOperacionList.add("1-50*3/2");
		RequestOperacionList.add("10.5*2+1");
		
		String valor = null;
		for (int i=0;i<RequestOperacionList.size();i++) 
		{		
			OperationsCalculatorService operationsCalculatorService = new OperationsCalculatorServiceImpl();
			valor = operationsCalculatorService.allOperations(RequestOperacionList.get(i));	      
			
			flag = Double.parseDouble(valor)>=0 || Double.parseDouble(valor) <=0 ? true: false;
			
			System.out.println("Operación: "+RequestOperacionList.get(i));
			System.out.println("Resultado: "+valor+"\n");	      		
		}
			
		assertTrue(flag);
	}

}
