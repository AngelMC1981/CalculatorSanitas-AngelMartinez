package com.operation.calculator.dto;

import java.io.Serializable;

public class CalcResponseDto implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    public String operacion;
 
    public String resultado;
 
    public CalcResponseDto() {
        super();
    }
     
    public CalcResponseDto(String operacion, String resultado) {
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
 
    public String getResultado() {
        return resultado;
    }
 
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
 
}