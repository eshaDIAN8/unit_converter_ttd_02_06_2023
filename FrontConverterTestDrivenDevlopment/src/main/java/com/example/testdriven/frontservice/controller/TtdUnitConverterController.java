package com.example.testdriven.frontservice.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testdriven.frontservice.dao.TtdUnitConverterDao;
import com.example.testdriven.frontservice.dao.TtdUnitConverterDaoImpl;
import com.example.testdriven.frontservice.service.TtdUnitConverterServce;
import com.example.testdriven.frontservice.service.TtdUnitConverterServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/converter")
public class TtdUnitConverterController {
	
	private static Logger logger = LogManager.getLogger(TtdUnitConverterController.class);

	@Autowired
	private TtdUnitConverterServce service;

	
	private  double unitToBeConvertedResult;
	
	@GetMapping("/{fromUnit}/{toUnit}/{value}")
	public ResponseEntity<String> getFormulaFromCrud(@PathVariable String fromUnit, @PathVariable String toUnit,
			@PathVariable double value) {
		
		
		if(StringUtils.isNotEmpty(fromUnit) && StringUtils.isNotEmpty(toUnit) && value != 0 ) 
		{

		String UnitConverterKey = fromUnit + "-" + toUnit;

		unitToBeConvertedResult = service.getConvertedResult(UnitConverterKey, value);
		logger.info("inside front controller " + unitToBeConvertedResult);

		}else {
			logger.info("path variables are either empty or null");
		}
		String finalConvertedResult = String.valueOf(unitToBeConvertedResult);
		logger.info(finalConvertedResult);

		return ResponseEntity.ok(finalConvertedResult);
		
	}

}
