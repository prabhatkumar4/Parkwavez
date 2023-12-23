package com.example.parkingproviderservice.exception;



public class ResourceNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String meaasage) {
		super(meaasage);
	}
}
