package com.example.testdriven.frontservice.dao;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.testdriven.frontservice.dao.TtdUnitConverterDao;

@Component
@Profile({"test"})
public class TtdUnitConverterDaoImplStatic  implements TtdUnitConverterDao{
	
	
	@Override
	public String getFormula(String convertedUnit)  {
		System.out.println("inside daoimpl static java file");
		
		Map<String,String> map = new HashMap<>();
		map.put("km-meter","*1000");
		map.put("meter-km", "/1000");
		map.put("inch-meter","*0.025");
		map.put("meter-inch","/0.025");
		map.put("mm-meter","/1000");
		map.put("meter-mm","*1000");
		map.put("cm-meter","/100");
		map.put("meter-cm","*100");
		
		
			return map.get(convertedUnit);
		
		
	}

}
