package com.sanitas.calculator.factories;

import com.sanitas.calculator.dto.Add;
import com.sanitas.calculator.dto.Operation;
import com.sanitas.calculator.dto.Subtract;
import com.sanitas.calculator.enums.TypeOperationEnum;
import com.sanitas.calculator.exceptions.OperationNoImplementException;

public class OperationFactoryImpl implements OperationFactory {

	@Override
	public Operation createOperation(String operation) {

		// Check if operation exists
		if (!TypeOperationEnum.contains(operation)) {
			throw new OperationNoImplementException("no implement operation");
		}

		TypeOperationEnum typeOperation = TypeOperationEnum.getTypeOperation(operation);

		if (typeOperation.getValue().equals(TypeOperationEnum.add.getValue())) {
			return new Add();
		} else if (typeOperation.getValue().equals(TypeOperationEnum.subtract.getValue())) {
			return new Subtract();
		} else {
			throw new OperationNoImplementException("no implement operation");
		}
	}
}
