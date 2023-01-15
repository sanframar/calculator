package com.sanitas.calculator.dto;

import java.math.BigDecimal;

public interface Operation {
	
	BigDecimal calculate (BigDecimal number1, BigDecimal number2);

}
