package com.example.testdriven.frontservice.dao;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.testdriven.frontservice.service.TtdUnitConverterServiceImpl;

@Component
@Profile({ "!test" })
public class TtdUnitConverterDaoImpl implements TtdUnitConverterDao {

	
	private static Logger logger = LogManager.getLogger(TtdUnitConverterDaoImpl.class);
	@Autowired
	private RestTemplate restTmp;

	private String formula;

	public String getFormula(String UnitConverterKey) {

		try {

			if (StringUtils.isNotEmpty(UnitConverterKey)) {

				formula = restTmp.getForObject("http://localhost:8080/getConvertedUnit/" + UnitConverterKey, String.class);
				logger.info("formula in front service:" + formula);
			} else {
				logger.info("convertedUnit is either null or empty");
			}

		} catch (Exception e) {
			logger.error("exception at the time of crud microservice callng" + e);
		}

		return formula;
	}

}


