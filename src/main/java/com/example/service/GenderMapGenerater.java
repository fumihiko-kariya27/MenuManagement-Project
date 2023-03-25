package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;
import java.util.Locale;

/**
 * @author kariyafumihiko
 * 男性と女性を識別値を設定して登録する
 */

@Service
public class GenderMapGenerater {
	
	@Autowired
	private MessageSource messageSource;

	// 性別のMapを生成する
	public Map<String, Integer> getGenderMap()
	{
		String male = messageSource.getMessage("gender_male", null, Locale.getDefault());
		String female = messageSource.getMessage("gender_female", null, Locale.getDefault());
		
		Map<String, Integer> genderMap = new HashMap<>();
		genderMap.put(male, UserGender.MALE.getGender());
		genderMap.put(female, UserGender.FEMALE.getGender());
		
		return genderMap;
	}
	
	
}
