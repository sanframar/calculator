package com.sanitas.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.sanitas.calculator.enums.TypeOperationEnum;
import com.sanitas.calculator.exceptions.OperationNoImplementException;

public class OperationServiceTest {
	
	@InjectMocks
	private OperationServiceImpl operationService = new OperationServiceImpl();
	
	@Nested
	@DisplayName("check method calculate")
	class OperationServiceCalculate{
		
		@Test
		@DisplayName("check method calculate with operation add")
		void calculateOperationAddTest() {
			BigDecimal number1 = new BigDecimal(500);
			BigDecimal number2 = new BigDecimal(400);
			BigDecimal actual = operationService.calculate(number1, number2, TypeOperationEnum.add.getValue());
			BigDecimal expected = new BigDecimal(900);
			assertNotNull(actual);
			assertEquals(expected, actual);
		}
		
		@Test
		@DisplayName("check method calculate with operation subtract")
		void calculateOperationSubtractTest() {
			BigDecimal number1 = new BigDecimal(500);
			BigDecimal number2 = new BigDecimal(400);
			BigDecimal actual = operationService.calculate(number1, number2, TypeOperationEnum.subtract.getValue());
			BigDecimal expected = new BigDecimal(100);
			assertNotNull(actual);
			assertEquals(expected, actual);
		}
		
		@Test
		@DisplayName("check method calculate with exception")
		void calculateOperationExceptionTest() {
			BigDecimal number1 = new BigDecimal(500);
			BigDecimal number2 = new BigDecimal(400);
			
			assertThrows(OperationNoImplementException.class, () -> {
				operationService.calculate(number1, number2, "%");
			});
		}
	}

}
