package com.sanitas.calculator.enums;

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
		for(TypeOperationEnum typeOperation : TypeOperationEnum.values()) {
			if(typeOperation.getValue().equalsIgnoreCase(symbol)) {
				return typeOperation;
			}
		}
		return null;
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
