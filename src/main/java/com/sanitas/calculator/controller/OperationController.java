package com.sanitas.calculator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculator.request.RequestOperation;
import com.sanitas.calculator.service.OperationService;

@RestController
public class OperationController {

	@Autowired
	private OperationService operationService;

	@GetMapping("/api/operation")
	public ResponseEntity<?> calculate(@RequestBody RequestOperation requestOperation) {

		if (!checkRequestOperation(requestOperation)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(operationService.calculate(requestOperation.getNumber1(),
				requestOperation.getNumber2(), requestOperation.getOperation()));
	}

	private boolean checkRequestOperation(RequestOperation requestOperation) {
		boolean result = Boolean.FALSE;
		if (requestOperation != null && requestOperation.getNumber1() != null && requestOperation.getNumber2() != null
				&& requestOperation.getOperation() != null) {
			result = Boolean.TRUE;
		}
		return result;
	}

}
