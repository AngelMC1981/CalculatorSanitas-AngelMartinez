package com.operation.calculator.services;

import java.math.BigDecimal;

public interface OperationsCalculatorService {
	
	String allOperations(String equation);
	String sum(BigDecimal oper1, BigDecimal oper2);
	String sub(BigDecimal oper1, BigDecimal oper2);
	
}
