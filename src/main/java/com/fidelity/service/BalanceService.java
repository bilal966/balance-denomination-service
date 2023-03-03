/**
 * 
 */
package com.fidelity.service;

import java.util.Map;

/**
 * @author bilalilyas
 *
 */
public interface BalanceService {
	
	public Map<String, Integer> convertBalanceIntoDenomination(Integer balance,String currency) throws Exception;

}
