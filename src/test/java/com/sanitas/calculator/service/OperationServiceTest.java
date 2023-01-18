package com.sanitas.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.sanitas.calculator.enums.TypeOperationEnum;
import com.sanitas.calculator.exceptions.OperationNoImplementException;

public class OperationServiceTest {

	@InjectMocks
	private OperationServiceImpl operationService = new OperationServiceImpl();

	@Test
	@DisplayName("check method calculate with operation add")
	void calculate_addOperation_resultOperation() {
		BigDecimal number1 = new BigDecimal(500);
		BigDecimal number2 = new BigDecimal(400);
		BigDecimal actual = operationService.calculate(number1, number2, TypeOperationEnum.add.getValue());
		BigDecimal expected = new BigDecimal(900);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("check method calculate with operation add and corner cases")
	void calculate_addOperationWWithCornerCases_resultOperation() {
		BigDecimal number1 = new BigDecimal(Double.MAX_VALUE);
		BigDecimal number2 = new BigDecimal(Double.MAX_VALUE);
		BigDecimal actual = operationService.calculate(number1, number2, TypeOperationEnum.add.getValue());
		BigDecimal expected = number1.add(number2);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("check method calculate with operation subtract")
	void calculate_SubtractOperation_resultOperation() {
		BigDecimal number1 = new BigDecimal(500);
		BigDecimal number2 = new BigDecimal(400);
		BigDecimal actual = operationService.calculate(number1, number2, TypeOperationEnum.subtract.getValue());
		BigDecimal expected = new BigDecimal(100);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("check method calculate with operation subtract and corner cases")
	void calculate_SubtractOperationWithCornerCases_resultOperation() {
		BigDecimal number1 = new BigDecimal(Double.MIN_VALUE);
		BigDecimal number2 = new BigDecimal(Double.MIN_VALUE);
		BigDecimal actual = operationService.calculate(number1, number2, TypeOperationEnum.subtract.getValue());
		BigDecimal expected = number1.subtract(number2);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("check method calculate with exception")
	void calculate_OperationWithOperationNoImplementException_operationNoImplementException() {
		BigDecimal number1 = new BigDecimal(500);
		BigDecimal number2 = new BigDecimal(400);

		assertThrows(OperationNoImplementException.class, () -> {
			operationService.calculate(number1, number2, "%");
		});
	}
	
	@Test
	@DisplayName("check method calculate with string instance of umerexception")
	void calculate_OperationWithStringInstanceOfNumber_operationNoImplementException() {
		BigDecimal number1 = new BigDecimal(500);
		BigDecimal number2 = new BigDecimal(400);

		assertThrows(OperationNoImplementException.class, () -> {
			operationService.calculate(number1, number2, "%");
		});
	}

}
