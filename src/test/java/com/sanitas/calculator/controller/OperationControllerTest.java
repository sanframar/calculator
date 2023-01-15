package com.sanitas.calculator.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitas.calculator.enums.TypeOperationEnum;
import com.sanitas.calculator.request.RequestOperation;
import com.sanitas.calculator.service.OperationService;

@WebMvcTest(OperationController.class)
public class OperationControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
//	@InjectMocks
//	private final OperationController operationController = new OperationController();
	
	@MockBean
	private OperationService operationService;

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
			
			RequestOperation request = new RequestOperation();
			request.setNumber1(new BigDecimal(100));
			request.setNumber2(new BigDecimal(200));
			request.setOperation(TypeOperationEnum.add.getValue());
			
			mvc.perform(MockMvcRequestBuilders.get("/api/operation").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(request)))
			
			.andExpect(status().isOk());
		}
		
		@Test
		@DisplayName("check controller calculate with operation subtract")
		void calculateOperationSubtractTest() throws Exception{
			//Given
			
			RequestOperation request = new RequestOperation();
			request.setOperation(TypeOperationEnum.subtract.getValue());
			request.setNumber1(new BigDecimal(200));
			request.setNumber2(new BigDecimal(100));
			
			//When
			mvc.perform(MockMvcRequestBuilders.get("/api/operation").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(request)))
			
			//Then
			.andExpect(status().isOk());
			
			
		}
		
		@Test
		@DisplayName("check controller calculate with exception")
		void calculateOperationExceptionTest() throws Exception {
			
			RequestOperation request = new RequestOperation();
			request.setNumber1(new BigDecimal(200));
			request.setNumber2(new BigDecimal(100));
			request.setOperation("%");
			
			//When
			mvc.perform(MockMvcRequestBuilders.get("/api/operation").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(request)))
			
			//Then
			.andExpect(status().isNotFound());
		}
	}

}
