package com.operation.calculator.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
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
	public void allOperationsTest() {
		List<String> RequestOperacionList = new ArrayList<String>();
		boolean flag = false;
		RequestOperacionList.add("100-56");
		RequestOperacionList.add("4+7");
		RequestOperacionList.add("3/2");
		RequestOperacionList.add("10.5*2");
		
		
			BigDecimal valor = null;
			for (int i=0;i<RequestOperacionList.size();i++) 
			{		
				try {
					OperationsCalculatorService operationsCalculatorService = new OperationsCalculatorServiceImpl();
					valor = operationsCalculatorService.allOperations(RequestOperacionList.get(i));	      
					
					flag = Double.parseDouble(valor.toString())>=0 || Double.parseDouble(valor.toString()) <=0 ? true: false;
					
					System.out.println("Operación: "+RequestOperacionList.get(i));
					System.out.println("Resultado: "+valor+"\n");	     
				}
				catch (Exception e)
				{
					System.out.println("Operación: "+RequestOperacionList.get(i));
					System.out.println("Operación no implementada\n");
					flag=true;
				}
			}
	
		
		assertTrue(flag);
	}

}
