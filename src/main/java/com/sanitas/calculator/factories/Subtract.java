package com.sanitas.calculator.factories;

import java.math.BigDecimal;

public class Subtract implements Operation{

	@Override
	public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
		return number1.subtract(number2);
	}

}
