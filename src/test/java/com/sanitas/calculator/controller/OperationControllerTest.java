package com.sanitas.calculator.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitas.calculator.enums.TypeOperationEnum;
import com.sanitas.calculator.exceptions.OperationNoImplementException;
import com.sanitas.calculator.request.RequestOperation;
import com.sanitas.calculator.service.OperationService;

public class OperationControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@InjectMocks
	OperationService operationService;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
	}
	
	@Nested
	@DisplayName("check controller calculate")
	class OperationServiceCalculate{
		
		@Test
		@DisplayName("check controller calculate with operation add")
		void calculateOperationAddTest() throws Exception {
			//Given
			when(operationService.calculate(any(), any(), TypeOperationEnum.add.getValue())).thenReturn(new BigDecimal(100));
			
			RequestOperation request = new RequestOperation();
			request.setOperation(TypeOperationEnum.add.getValue());
			
			//When
			mvc.perform(MockMvcRequestBuilders.get("/api/operation").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(request)))
			
			//Then
			.andExpect(status().isOk());
			
			verify(operationService.calculate(any(), any(), TypeOperationEnum.add.getValue()));
		}
		
		@Test
		@DisplayName("check controller calculate with operation subtract")
		void calculateOperationSubtractTest() throws Exception{
			//Given
			when(operationService.calculate(any(), any(), TypeOperationEnum.subtract.getValue())).thenReturn(new BigDecimal(100));
			
			RequestOperation request = new RequestOperation();
			request.setOperation(TypeOperationEnum.subtract.getValue());
			
			//When
			mvc.perform(MockMvcRequestBuilders.get("/api/operation").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(request)))
			
			//Then
			.andExpect(status().isOk());
			
			verify(operationService.calculate(any(), any(), TypeOperationEnum.subtract.getValue()));
			
		}
		
		@Test
		@DisplayName("check controller calculate with exception")
		void calculateOperationExceptionTest() throws Exception {
			//Given
			when(operationService.calculate(any(), any(), "%")).thenThrow(OperationNoImplementException.class);
			
			RequestOperation request = new RequestOperation();
			request.setOperation("%");
			
			//When
			mvc.perform(MockMvcRequestBuilders.get("/api/operation").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(request)))
			
			//Then
			.andExpect(status().isNotFound());
			
			verify(operationService.calculate(any(), any(), "%"));
		}
	}

}
