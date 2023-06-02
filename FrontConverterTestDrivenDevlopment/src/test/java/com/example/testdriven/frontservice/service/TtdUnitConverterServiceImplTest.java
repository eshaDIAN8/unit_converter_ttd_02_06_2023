package com.example.testdriven.frontservice.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.testdriven.frontservice.dao.TtdUnitConverterDao;
import com.example.testdriven.frontservice.service.TtdUnitConverterServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TtdUnitConverterServiceImplTest {
	
	
	@InjectMocks
	TtdUnitConverterServiceImpl service;


	@Mock
	private TestTemplate testRestTemplate;
	

	@Mock
	TtdUnitConverterDao dao ;
	
	@Test
	public void testService_Unit_Testing() {
		
		String convertedUnit ="meter-cm";
		String formula ="*100";

    	when(dao.getFormula(convertedUnit)).thenReturn("*100");
    	double convertedResult = service.getConvertedResult(convertedUnit, 5);
    	String convertedResult1 = String.valueOf(convertedResult);
    	 Assert.assertEquals("500.0", convertedResult1);
    	
    
	}
	
	
	@Test
	public void testService_Failure_Scenario_Unit_Testing() {
		
		String convertedUnit ="meter-cm";
		String formula ="*100";

    	when(dao.getFormula(convertedUnit)).thenReturn("*100");
    	double convertedResult = service.getConvertedResult(convertedUnit, 5);
    	String convertedResult1 = String.valueOf(convertedResult);
    	 Assert.assertEquals("500.0", convertedResult1);
    	
    
	}
	
	
	@Test
	public void testService_Success_Scenario() {
		
		String convertedUnit ="meter-cm";
		String formula ="*100";

    	when(dao.getFormula(convertedUnit)).thenReturn("*100");
    	double convertedResult = service.getConvertedResult(convertedUnit, 5);
    	String convertedResult1 = String.valueOf(convertedResult);
    	 Assert.assertEquals("500.0", convertedResult1);
    	
    
	}
	
	@Test
	public void testService_Refactor_Scenario() {
		
		String convertedUnit ="meter-cm";
		String formula ="*100";

    	when(dao.getFormula(convertedUnit)).thenReturn("*100");
    	double convertedResult = service.getConvertedResult(convertedUnit, 5);
    	String convertedResult1 = String.valueOf(convertedResult);
    	 Assert.assertEquals("500.0", convertedResult1);
    	
    
	}

}
