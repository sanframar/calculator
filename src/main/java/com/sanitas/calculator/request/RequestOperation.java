package com.sanitas.calculator.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestOperation {

	BigDecimal number1;
	BigDecimal number2;
	String operation;
}
