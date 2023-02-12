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
	// 男女の識別値
	private final int MALE = 1;
	private final int FEMALE = 2;
	
	@Autowired
	private MessageSource messageSource;

	// 性別のMapを生成する
	public Map<String, Integer> getGenderMap()
	{
		String male = messageSource.getMessage("gender_male", null, Locale.getDefault());
		String female = messageSource.getMessage("gender_female", null, Locale.getDefault());
		
		Map<String, Integer> genderMap = new HashMap<>();
		genderMap.put(male, MALE);
		genderMap.put(female, FEMALE);
		
		return genderMap;
	}
	
	
}
