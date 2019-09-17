/**
 * @author cleilton
 * File: CustomErrorType.java - Date: Sep 11, 2019
 */
package br.com.springboot.error;

public class CustomErrorType {
	private String errorMessage;

	public CustomErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
