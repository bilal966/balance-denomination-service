package com.fidelity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.fidelity.factory.CurrencyFactory;
import com.fidelity.service.BalanceService;

/**
 * 
 * @author bilalilyas
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BalanceDenominationSerivceApplicationTests {

	@Autowired
	WebTestClient webTestClient;
	
	@Mock
	public BalanceService balanceService;

	@Test
	void contextLoads() {
	}

	@Test
	void whenGetRequestsThenReturnBalanceDenominationsUSD() {
		webTestClient.get().uri("balance/287/usd").exchange().expectStatus().isOk().expectBodyList(Map.class);

	}
	
	@Test
	void whenGetRequestsThenReturnBalanceDenominationsEuro() {
		webTestClient.get().uri("balance/287/euro").exchange().expectStatus().isOk().expectBodyList(Map.class);

	}
	
	@Test
	void whenGetRequestsThenReturnBalanceDenominationsException() {
		webTestClient.get().uri("balance/287/aed").exchange().expectStatus().isNotFound().expectBodyList(Map.class);

	}
	//Factory Testcases
	@Test
	void getDenominationTestException() throws Exception {

		assertThatThrownBy(()->{CurrencyFactory.getCurrencyDenominationsByCountry("AED");}).isInstanceOf(Exception.class).hasMessage("Unavailable country currency");

	}
	@Test
	void getDenominationTestSuccess() throws Exception {
		//when(CurrencyFactory.getCurrencyDenominationsByCountry("USD")).thenReturn(new LinkedList<>());
		assertThat(CurrencyFactory.getCurrencyDenominationsByCountry("USD")).isNotEmpty();
	}
	

}
