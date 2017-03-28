package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

public class OtherCurrency implements CotizacionStrategy {

	@Override
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	public ResponseEntity<String> show() {
		return new ResponseEntity<String>("401 - Unauthorized",HttpStatus.UNAUTHORIZED);
	}

}
