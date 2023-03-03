package com.fidelity.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.fidelity.factory.CurrencyFactory;
import com.fidelity.model.Denomination;

/**
 * BalanceServiceImpl
 * @author bilalilyas
 *
 */
@Service
public class BalanceServiceImpl implements BalanceService {

	@Override
	public Map<String, Integer> convertBalanceIntoDenomination(Integer balance,String currency) throws Exception {
		
		List<Denomination> currencyDenominations = null;
		try {
			currencyDenominations = CurrencyFactory.getCurrencyDenominationsByCountry(currency);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		final ListIterator<Denomination> iterator = currencyDenominations.listIterator();
		//TODO : 
		final Map<String, Integer> result = new LinkedHashMap<>();
		while (iterator.hasNext()) {
			Denomination currencyDenomication = (Denomination)iterator.next();
			int remainingCount = balance/currencyDenomication.getValue();
			if (remainingCount > 0) {
				result.put(currencyDenomication.getTitle(), remainingCount);
                balance %= currencyDenomication.getValue();
            }
		}
		return result;
	}

}
