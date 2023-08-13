package com.example.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.cuisine.model.CuisineCategory;
import com.example.domain.cuisine.model.CuisineInfo;
import com.example.domain.cuisine.service.CuisineService;

/**
 * @author kariyafumihiko
 * メニュー一覧の取得を制御するコントローラー
 */

@Controller
@RequestMapping("/menu")
public class CuisineListController {
	
	@Autowired
	private CuisineService service;
	
	@Autowired
	private MessageSource msgSrc;
	
	@GetMapping("/list")
	public String getAllCuisine(Model model)
	{
		// メニュー一覧をモデルに登録
		List<CuisineInfo> cuisineList = service.getAllCuisine();
		model.addAttribute("cuisineList", cuisineList);
		addCategoroesToModel(model);
		
		return "menu/list";
	}
	
	@PostMapping("/list")
	public String postCuisineByCategory(Model model, @RequestParam Map<String, String> param)
	{
		String category = param.get("categories");
		List<CuisineInfo> cuisineList = service.getCuisineByCategory(category);
		// メニュー一覧をモデルに登録
		model.addAttribute("cuisineList", cuisineList);
		addCategoroesToModel(model);
		
		return "menu/list";
	}
	
	private void addCategoroesToModel(Model model)
	{
		// メニューカテゴリ一覧をモデルに登録
		List<String> cuisineCategories = CuisineCategory.getCategories();
		model.addAttribute("cuisineCategories", cuisineCategories);
		// 選択リストの初期値を「和食」に設定
		String selectedValue = msgSrc.getMessage("selectedValue", null, Locale.getDefault());
		model.addAttribute("selectedValue", selectedValue);	
	}
	
}
