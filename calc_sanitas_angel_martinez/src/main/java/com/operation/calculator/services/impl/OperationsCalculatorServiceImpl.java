package com.operation.calculator.services.impl;

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
	public String sum(String[] sumList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sub(String[] subList) {
		// TODO Auto-generated method stub
		return null;
	}

}
