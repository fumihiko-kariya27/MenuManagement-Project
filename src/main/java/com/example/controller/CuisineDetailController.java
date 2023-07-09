package com.example.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.cuisine.model.CuisineInfo;
import com.example.domain.cuisine.service.CuisineService;
import com.example.form.CuisineDetailForm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kariyafumihiko
 * メニュー詳細内容を制御するコントローラー
 */


@Controller
@RequestMapping("/menu")
@Slf4j
public class CuisineDetailController {
	
	@Autowired
	private CuisineService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/detail/{cuisineName}")
	public String getCuisineDetail(Model model, @PathVariable("cuisineName") String cuisineName)
	{
		CuisineInfo cuisineInfo = service.getCuisineByName(cuisineName);
		// まだ調理されていない場合は初期メッセージを設定
		if(cuisineInfo.getCookDate() == null)
		{
			cuisineInfo.setCookDate(messageSource.getMessage("cuisine.regist.only.msg", null, Locale.getDefault()));
		}
		CuisineDetailForm form = modelMapper.map(cuisineInfo, CuisineDetailForm.class);
		
		List<String> ingredients = Arrays.asList(form.getIngredients().split(","));
		model.addAttribute("ingredients", ingredients);
		
		log.info(form.toString());
		
		model.addAttribute("cuisineDetailForm", form);
		
		return "menu/detail";
	}
}
