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
    public ResponseEntity<BigDecimal>  getCalc (@RequestParam(value = "RequestOperacion", required = true) String requestOperacion) 
    {
    	
    	BigDecimal response = response = operationsCalculatorService.allOperations(requestOperacion);	
    	
    	
    	return ResponseEntity.ok().body(response);
    }
}
