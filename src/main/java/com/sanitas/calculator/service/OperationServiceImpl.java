package com.sanitas.calculator.service;

import java.math.BigDecimal;

import io.corp.calculator.TracerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sanitas.calculator.factories.Operation;
import com.sanitas.calculator.factories.OperationFactoryImpl;

@Service
public class OperationServiceImpl implements OperationService{

	@Override
	@Cacheable("calculates")
	public BigDecimal calculate(BigDecimal number1, BigDecimal number2, String operation) {
		TracerImpl tracer = new TracerImpl();
		
		OperationFactoryImpl operationFactory = new OperationFactoryImpl();
		Operation operationToApply = operationFactory.createOperation(operation);
		
		StringBuilder startOperation = new StringBuilder();
		startOperation.append("Start operation ").append(operation).append(" with numbers ").append(number1).append(" and ").append(number2);
		tracer.trace(startOperation);
		
		BigDecimal result = operationToApply.calculate(number1, number2);
		
		StringBuilder endOperation = new StringBuilder();
		endOperation.append("Finish operation with result: ").append(result);
		tracer.trace(endOperation);
		
		return result;
	}

}
