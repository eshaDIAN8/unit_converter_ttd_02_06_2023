package com.example.testdriven.frontservice.dao;

import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.example.testdriven.frontservice.dao.TtdUnitConverterDao;
import com.example.testdriven.frontservice.dao.TtdUnitConverterDaoImpl;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@WebMvcTest
@ExtendWith(MockitoExtension.class)
public class TtdUnitConverterDaoImplTest {
	
	@InjectMocks
	TtdUnitConverterDao dao = new TtdUnitConverterDaoImpl() ;	
	
	@Value(value="${local.server.port}")
	private int port;
	@Mock
	private RestTemplate testRestTemp ;
		
	
	
	

	@Test
	public void test_Integration_Failure_Scenario_getFormula() throws JSONException {
		String convertedUnit = "cm-meter";
		String formula = dao.getFormula(convertedUnit);
		
		System.out.println("getting formula from crud service::"+formula); 
		 Assert.assertEquals("/100",formula );
		
	}
	
	@Test
	public void test_Integration_Success_Scenario_getFormula() throws JSONException {
		String convertedUnit = "cm-meter";
		String formula = dao.getFormula(convertedUnit);
		
		System.out.println("getting formula from crud service::"+formula); 
		 Assert.assertEquals("/100",formula );
		
	}
	
	
	@Test
	public void test_Integration_Mock_Crud_Service_Call()  {
		
		String convertedUnit ="meter-cm";	  	
		Mockito.when(testRestTemp.getForObject("http://localhost:8080" + "/getConvertedUnit/"+convertedUnit, 
    			String.class)).thenReturn("*100");
    	String formula = dao.getFormula(convertedUnit);
    	System.out.println("formula::"+formula);
		 
		 Assert.assertEquals("*100",formula );
		
		
		
	}
	
	
	

}
