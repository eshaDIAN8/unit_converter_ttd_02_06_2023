package com.example.testdriven.frontservice.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.testdriven.frontservice.dao.TtdUnitConverterDao;

@Service
public class TtdUnitConverterServiceImpl implements TtdUnitConverterServce {
	
	private static Logger logger = LogManager.getLogger(TtdUnitConverterServiceImpl.class);

	@Autowired
	private RestTemplate restTmp;

	@Autowired
	TtdUnitConverterDao dao;

	private double unitToBeConvertedResult;
	private double doubleValue;
	private String formula;
	private double processedResult;

	
	public Double getConvertedResult(String UnitConverterKey, double value) {

		try {
			formula = dao.getFormula(UnitConverterKey);
			logger.info(" inside getConvertedResult() formula ::" + formula);

		unitToBeConvertedResult = getAfterProcessingResult(formula, value);
		logger.info("convertedresult:" + unitToBeConvertedResult);

		} catch (Exception e) {

			logger.error("caught exception at the time of getting formula from crud service::" + e);
		}
		return unitToBeConvertedResult;
	}

	public Double getAfterProcessingResult(String formula, double value) {
		try {

			if (formula.charAt(0) == '*') {

				formula = formula.replace("*", "");
				doubleValue = Double.parseDouble(formula);
				processedResult = value * doubleValue;
				logger.info(" inside service if processing result::" + processedResult);

			} else {
				formula = formula.replace("/", "");
				doubleValue = Double.parseDouble(formula);
				processedResult = value / doubleValue;
				logger.info("  inside service else processing result" + processedResult);
			}

		} catch (Exception e) {
			logger.error("exception in getAfterProcessingResult()::" + e);

		}

		return processedResult;

	}

}
