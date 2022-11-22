package com.operation.calculator.dto;


public enum OperacionesEnumDto {

	add("+","add"), 
	subtract("-","subtract");
	//multiply("*","multiply") ,
	//divide("/","divide") ,
	//pow("^","pow");

	private String operator;
	private String value;

	private OperacionesEnumDto(String operator,String value) {
		this.operator=operator;
		this.value = value;
	}

	public static String getOperatorByValue(String operator) {

		for (OperacionesEnumDto operacionesEnum : OperacionesEnumDto.values()) {
			if(operacionesEnum.getOperator().equalsIgnoreCase(operator)) {
				return operacionesEnum.getValue();
			}
		}
		return "";
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
		
}
