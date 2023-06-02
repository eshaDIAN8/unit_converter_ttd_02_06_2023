package com.example.testdriven.frontservice.service;

public interface TtdUnitConverterServce {
	
	public Double getConvertedResult(String UnitConverterKey, double value) ;
	
	public Double getAfterProcessingResult(String formula, double value);
		
	
	

}
