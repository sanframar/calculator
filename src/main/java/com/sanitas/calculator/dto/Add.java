package com.sanitas.calculator.dto;

import java.math.BigDecimal;

public class Add implements Operation{

	@Override
	public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
		return number1.add(number2);
	}

}
