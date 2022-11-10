package com.operation.calculator.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.operation.calculator.services.OperationsCalculatorService;
import com.operation.calculator.services.impl.OperationsCalculatorServiceImpl;


 
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@RestController
public class CalcRestController {

    @RequestMapping(value="/calc", method=RequestMethod.POST)
    public ResponseEntity<String>  getCalc (@RequestParam(value = "RequestOperacion", required = true) String requestOperacion) 
    {
    	OperationsCalculatorService operationsCalculatorService = new OperationsCalculatorServiceImpl();
    	String response = operationsCalculatorService.allOperations(requestOperacion);
    	
	//return new ResponseEntity<String>(HttpStatus.OK);
   
		return ResponseEntity.ok().body(response);
    }
}
