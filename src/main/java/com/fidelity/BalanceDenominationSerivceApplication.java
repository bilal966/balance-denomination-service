package com.fidelity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.fidelity.currency.EuroDenominations;
import com.fidelity.currency.USDDenominations;

/**
 * BalanceDenominationSerivceApplication
 * 
 * @author bilalilyas
 *
 */

@SpringBootApplication
public class BalanceDenominationSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalanceDenominationSerivceApplication.class, args);
		
	}
	
	@Bean
	@Scope("singleton")
	USDDenominations currencyUSDDenominationsSingleton() {
	    return new USDDenominations();
	}
	
	@Bean
	@Scope("singleton")
	EuroDenominations currencyEuroDenominationsSingleton() {
	    return new EuroDenominations();
	}

}
