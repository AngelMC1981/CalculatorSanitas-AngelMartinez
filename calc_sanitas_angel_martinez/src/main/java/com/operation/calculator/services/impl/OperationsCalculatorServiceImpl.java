package com.operation.calculator.services.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import com.operation.calculator.dto.OperacionesEnumDto;
import com.operation.calculator.services.OperationsCalculatorService;

public class OperationsCalculatorServiceImpl implements OperationsCalculatorService {

	@Override
	public BigDecimal allOperations(String equation) {
		
		BigDecimal response = null;
    	
    	for (OperacionesEnumDto operacionesEnum : OperacionesEnumDto.values()) {
    		int buscaOperator = equation.indexOf(operacionesEnum.getOperator());
			if (buscaOperator>0)
			{
				String operMethod=OperacionesEnumDto.getOperatorByValue(operacionesEnum.getOperator());
				BigDecimal oper1= new BigDecimal(equation.substring(0,buscaOperator));
				BigDecimal oper2= new BigDecimal(equation.substring(buscaOperator+1,equation.length()));
			
				Method[] methods = oper1.getClass().getDeclaredMethods();
				for(Method method : methods)  
		   	    { 
					if (method.getName().equals(operMethod))
					{
						try {
							response = (BigDecimal) method.invoke(oper1,oper2);
						} catch (IllegalAccessException e) {
						} catch (IllegalArgumentException e) {
						} catch (InvocationTargetException e) {
						}
					}
		   	    } 
		
			}
		}
    	return response;
    	
    /*
    	if(true)
    	{		
	        responseCalc.setOperacion(equation);
	        
	        ScriptEngineManager manager = new ScriptEngineManager();
	        ScriptEngine engine = manager.getEngineByName("js");
	        
	        try 
	        {
				Object result = engine.eval(equation);
				responseCalc.setResultado((BigDecimal) result);
			} 
	        catch (ScriptException e) 
	        {
				e.printStackTrace();
			}
    	}
        return responseCalc.getResultado();
        */
	}
}
