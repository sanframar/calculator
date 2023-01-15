package com.sanitas.calculator.factories;

import com.sanitas.calculator.dto.Operation;

public interface OperationFactory {
	
	Operation createOperation(String operation);

}
