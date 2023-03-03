package com.fidelity.currency;

import java.util.Arrays;
import java.util.List;

import com.fidelity.model.Denomination;

public class USDDenominations {

	public List<Denomination> getDenominations() {
		return Arrays.asList(new Denomination("Hundred Dollar", 10000),
				new Denomination("Fifty Dollar", 5000), new Denomination("Twenty Dollar", 2000),
				new Denomination("Ten Dollar", 1000), new Denomination("Five Dollar", 500),
				new Denomination("One Dollar", 100), new Denomination("Quarter", 25),
				new Denomination("Dime", 10), new Denomination("Nickel", 5),
				new Denomination("Penny", 1));
	}

}
