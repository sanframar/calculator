package com.sanitas.calculator.service;

import java.math.BigDecimal;
import io.corp.calculator.TracerImpl;

import org.springframework.stereotype.Service;

import com.sanitas.calculator.dto.Operation;
import com.sanitas.calculator.factories.OperationFactoryImpl;

@Service
public class OperationServiceImpl implements OperationService{

	@Override
	public BigDecimal calculate(BigDecimal number1, BigDecimal number2, String operation) {
		
		OperationFactoryImpl operationFactory = new OperationFactoryImpl();
		Operation operationToApply = operationFactory.createOperation(operation);
		
		BigDecimal result = operationToApply.calculate(number1, number2);
		
		TracerImpl tracer = new TracerImpl();
		tracer.trace(result);
		
		return result;
	}

}
