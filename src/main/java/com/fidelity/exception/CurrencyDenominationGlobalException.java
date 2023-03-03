/**
 * 
 */
package com.fidelity.exception;

/**
 * @author bilalilyas
 *
 */
public class CurrencyDenominationGlobalException extends RuntimeException {

	private static final long serialVersionUID = 5235201698237601392L;
	
	private Integer status;
	private String message;
	
	public CurrencyDenominationGlobalException() {
		super();
	}
	public CurrencyDenominationGlobalException(String errorMessage,Integer httpStatus){
		super(errorMessage);
		this.status = httpStatus;
		this.message = errorMessage;
		
	}
	public CurrencyDenominationGlobalException(Throwable throwable,Integer httpStatus){
		super(throwable);
		this.status = httpStatus;
		this.message = throwable.getMessage();
	}
	public CurrencyDenominationGlobalException(String errorMessage,Throwable throwable,Integer httpStatus){
		super(errorMessage, throwable);
		this.status = httpStatus;
		this.message = errorMessage;
	}
	
	

}
