package com.fidelity.currency;

import java.util.Arrays;
import java.util.List;

import com.fidelity.model.Denomination;



public class EuroDenominations implements CurrencyDenomination{

	@Override
	public List<Denomination> getDenominations() {
	
		return Arrays.asList(new Denomination("Hundred Euro", 10000),
				new Denomination("Fifty Euro", 5000),
				new Denomination("Twenty Euro", 2000),
				new Denomination("Ten Euro", 1000),
				new Denomination("Five Euro", 500),
				new Denomination("One Euro", 100),
				new Denomination("50 cent", 50),
				new Denomination("20 cent", 20),
				new Denomination("10 cent", 10),
				new Denomination("5 cent",5),
				new Denomination("1 cent", 1)
				);
	}
	
	

}
