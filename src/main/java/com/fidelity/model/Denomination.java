/**
 * 
 */
package com.fidelity.model;

/**
 * @author bilalilyas
 * mutable class
 *
 */

public class Denomination {
	
	private String title;
	private Integer value;
	
	public Denomination(String title,Integer value) {
		this.setTitle(title);
		this.setValue(value);
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public Integer getValue() {
		return value;
	}

	private void setValue(Integer value) {
		this.value = value;
	}

	
}
