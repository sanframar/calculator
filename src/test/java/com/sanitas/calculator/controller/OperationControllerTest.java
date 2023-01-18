package com.sanitas.calculator.controller;


import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sanitas.calculator.enums.TypeOperationEnum;
import com.sanitas.calculator.exceptions.OperationNoImplementException;
import com.sanitas.calculator.request.RequestOperation;
import com.sanitas.calculator.service.OperationService;

public class OperationControllerTest {

	@InjectMocks
	private final OperationController operationController = new OperationController();

	@Mock
	private OperationService operationService;

	/**
	 * Initializes.
	 */
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("check controller calculate with operation add and random numbers")
	void calculate_addOperationWithRandomNumbers_statusOK() {

		ResponseEntity<?> result = this.operationController
				.calculate(new RequestOperation(
					new BigDecimal(Math.random()),
					new BigDecimal(Math.random()),
					TypeOperationEnum.add.getValue()));

		Assertions.assertNotNull(result);
		Assertions.assertTrue(HttpStatus.OK.equals(result.getStatusCode()));

	}
	
	@Test
	@DisplayName("check controller calculate with operation add and corner cases")
	void calculate_addOperationWithCornerCases_statusOK() {

		ResponseEntity<?> result = this.operationController
				.calculate(new RequestOperation(
					new BigDecimal(Double.MAX_VALUE),
					new BigDecimal(Double.MAX_VALUE),
					TypeOperationEnum.add.getValue()));

		Assertions.assertNotNull(result);
		Assertions.assertTrue(HttpStatus.OK.equals(result.getStatusCode()));

	}

	@Test
	@DisplayName("check controller calculate with operation subtract and random numbers")
	void calculate_SubtractOperationWithRandomNumbers_statusOK() throws Exception {

		ResponseEntity<?> result = this.operationController
				.calculate(new RequestOperation(
					new BigDecimal(Math.random()),
					new BigDecimal(Math.random()),
					TypeOperationEnum.subtract.getValue()));

		Assertions.assertNotNull(result);
		Assertions.assertTrue(HttpStatus.OK.equals(result.getStatusCode()));
	}
	
	@Test
	@DisplayName("check controller calculate with operation subtract with corner cases")
	void calculate_SubtractOperationWithCornerCases_statusOK() throws Exception {

		ResponseEntity<?> result = this.operationController
				.calculate(new RequestOperation(
					new BigDecimal(Double.MIN_VALUE),
					new BigDecimal(Double.MIN_VALUE),
					TypeOperationEnum.subtract.getValue()));

		Assertions.assertNotNull(result);
		Assertions.assertTrue(HttpStatus.OK.equals(result.getStatusCode()));


	}

	@Test
	@DisplayName("check controller calculate with exception")
	void calculate_withNoExistOperation_OperationNoImplementException() throws Exception {

		Mockito.when(this.operationService.calculate(
				ArgumentMatchers.any(),
				ArgumentMatchers.any(),
				ArgumentMatchers.any()))
		.thenThrow(OperationNoImplementException.class);
		
		ResponseEntity<?> result = this.operationController
				.calculate(new RequestOperation());

		Assertions.assertNotNull(result);
		Assertions.assertTrue(HttpStatus.NOT_FOUND.value() == result.getStatusCode().value());
	}

}
