package com.sanitas.calculator.enums;

import java.util.Arrays;

public enum TypeOperationEnum {
	
	add("+"),
	subtract("-");
	
	private String value;

	private TypeOperationEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static TypeOperationEnum getTypeOperation(String symbol) {
		return Arrays.stream(TypeOperationEnum.values())
		.filter(typeOperation -> typeOperation.getValue().equalsIgnoreCase(symbol))
		.findAny()
		.orElse(null);
	}
	
	public static boolean contains(String value) {
		boolean res = false;
		for(TypeOperationEnum typeOperation : TypeOperationEnum.values()) {
			if(typeOperation.getValue().equals(value)) {
				res = true;
				break;
			}
		}
		return res;
	}

}
