package com.operation.calculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.operation.calculator.services.OperationsCalculatorService;


 
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@RestController
public class CalcRestController {
	
	@Autowired
	@Qualifier("operationsCalculatorService")
	OperationsCalculatorService operationsCalculatorService;
	
    @RequestMapping(value="/calc", method=RequestMethod.POST)
    public ResponseEntity<String>  getCalc (@RequestParam(value = "RequestOperacion", required = true) String requestOperacion) 
    {
    	String request = requestOperacion.toString();
    	String response = "";
    	String[] suma=request.indexOf("+")>0?request.split("\\+"):null;
    	String[] resta=request.indexOf("-")>0?request.split("-"):null;
    	
    	if (requestOperacion.indexOf("+")>0 &&  suma.length==2 && resta==null) 
    	{
    		response = operationsCalculatorService.sum(new BigDecimal(suma[0]), new BigDecimal(suma[1]));
    	}
    	else if (requestOperacion.indexOf("-")>0 &&  resta.length==2 && suma==null) 
    	{
    		response = operationsCalculatorService.sub(new BigDecimal(resta[0]), new BigDecimal(resta[1]));
    	}
    	else
    	{
	      	response = operationsCalculatorService.allOperations(requestOperacion);	
    	}
    	
    	return ResponseEntity.ok().body(response);
    }
}
