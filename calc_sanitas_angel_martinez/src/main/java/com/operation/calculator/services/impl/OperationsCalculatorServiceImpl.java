package com.operation.calculator.services.impl;

import java.math.BigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.operation.calculator.dto.CalcResponseDto;
import com.operation.calculator.services.OperationsCalculatorService;

public class OperationsCalculatorServiceImpl implements OperationsCalculatorService {

	@Override
	public String allOperations(String equation) {
		CalcResponseDto responseCalc= new CalcResponseDto();
        responseCalc.setOperacion(equation);
        
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        
        try 
        {
			Object result = engine.eval(equation);
			responseCalc.setResultado(result.toString());
		} 
        catch (ScriptException e) 
        {
			e.printStackTrace();
			responseCalc.setResultado(e.getMessage());
		}

        return responseCalc.getResultado();
        
	}

	@Override
	public String sum(BigDecimal oper1, BigDecimal oper2) {	
		BigDecimal response = oper1.add(oper2);
		return (response.toString());
	}

	@Override
	public String sub(BigDecimal oper1, BigDecimal oper2) {
		BigDecimal response = oper1.subtract(oper2);
		return (response.toString());
	}

}
