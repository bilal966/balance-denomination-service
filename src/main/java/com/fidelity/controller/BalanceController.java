/**
 * 
 */
package com.fidelity.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fidelity.service.BalanceService;

import reactor.core.publisher.Flux;

/**
 * BalanceController
 * 
 * @author bilalilyas
 *
 */
@RestController
public class BalanceController {
	
	@Autowired
	public BalanceService balanceService;
	// TODO: validation for input
	// TODO: Denominations can store into Database. because its static content.
	// TODO: implement api-gateway project to configure request rate limiter , default error messages etc
	
	@GetMapping("/balance/{balance}/{currency}")
	private Flux<Map<String,Integer>> getDenominations(@PathVariable("balance") Integer balance,@PathVariable("currency") String currency) throws Exception {
		
		return Flux.just(balanceService.convertBalanceIntoDenomination(balance, currency));
	}
	
	@ExceptionHandler({Exception.class,RuntimeException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private ResponseEntity<Object> handleException(Throwable exception) {
		Map<String, String> responseParamsMap = new HashMap<>();
		responseParamsMap.put("code", Integer.toString(HttpStatus.NOT_FOUND.value()));
		responseParamsMap.put("status", HttpStatus.NOT_FOUND.getReasonPhrase());
		responseParamsMap.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(responseParamsMap);
		
	}

}
