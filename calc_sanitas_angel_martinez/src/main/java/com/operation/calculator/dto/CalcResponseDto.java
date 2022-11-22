package com.operation.calculator.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CalcResponseDto implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    public String operacion;
 
    public BigDecimal resultado;
 
    public CalcResponseDto() {
        super();
    }
     
    public CalcResponseDto(String operacion, BigDecimal resultado) {
        super();
        this.operacion = operacion;
        this.resultado = resultado;
    }
 
    public String getOperacion() {
        return operacion;
    }
 
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
 
    public BigDecimal getResultado() {
        return resultado;
    }
 
    public void setResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }
 
}