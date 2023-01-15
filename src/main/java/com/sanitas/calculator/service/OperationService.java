package com.sanitas.calculator.service;

import java.math.BigDecimal;

public interface OperationService {
	
	BigDecimal calculate(BigDecimal number1, BigDecimal number2, String operation);

}
