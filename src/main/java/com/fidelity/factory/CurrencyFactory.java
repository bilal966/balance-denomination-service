package com.fidelity.factory;

import java.util.List;

import com.fidelity.currency.EuroDenominations;
import com.fidelity.currency.USDDenominations;
import com.fidelity.model.CountryCurrencies;
import com.fidelity.model.Denomination;

public class CurrencyFactory {
	
	public static List<Denomination> getCurrencyDenominationsByCountry(String countryCurrency) throws Exception {
		
		if(countryCurrency.equalsIgnoreCase(CountryCurrencies.USD.name())) {
			
			return new USDDenominations().getDenominations();
		
		} else if(countryCurrency.equalsIgnoreCase(CountryCurrencies.EURO.name())) {
		
			return new EuroDenominations().getDenominations();
		
		}
		throw new Exception("Unavailable country currency");
	}
	private CurrencyFactory() {
		
	}

}
