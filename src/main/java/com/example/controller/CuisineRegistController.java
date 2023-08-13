package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.cuisine.model.CuisineCategory;
import com.example.domain.cuisine.model.CuisineInfo;
import com.example.domain.cuisine.service.CuisineService;
import com.example.form.CuisineRegistForm;
import com.example.form.ValidationGroupOrder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kariyafumihiko
 * メニュー登録を制御するコントローラー
 */

@Slf4j
@Controller
@RequestMapping("/menu")
public class CuisineRegistController {
	
	@Autowired
	private CuisineService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/regist")
	public String getRegistCuisine(Model model, @ModelAttribute CuisineRegistForm form)
	{
		// カテゴリ一覧をモデルに追加
		List<String> cuisineCategories = CuisineCategory.getCategories();
		model.addAttribute("cuisineCategories", cuisineCategories);
		
		return "menu/regist";
	}
	
	@PostMapping("/regist")
	public String postRegistCuisine(Model model, @ModelAttribute @Validated(value = ValidationGroupOrder.class) CuisineRegistForm form, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			// バインド結果にエラーがある場合は登録画面に遷移する
			log.error("メニュー登録内容のバインド結果にエラーがあります");
			return getRegistCuisine(model, form);
		}
		
		// 既にメニューが登録されていないか確認する
		CuisineInfo cuisineInfo = service.getCuisineByName(form.getCuisineName());
		if(cuisineInfo != null)
		{
			// 既に登録されている場合は何もしない
			log.error(form.getCuisineName() + "は既に登録されています");
			return "redirect:/menu/list";
		}
		
		cuisineInfo = modelMapper.map(form, CuisineInfo.class);
		service.registCuisine(cuisineInfo);
		
		return "redirect:/menu/list";
	}

}
