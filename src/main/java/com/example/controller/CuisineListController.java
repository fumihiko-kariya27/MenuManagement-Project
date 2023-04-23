package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/list")
	public String getAllCuisine(Model model)
	{
		List<CuisineInfo> cuisineList = service.getAllCuisine();
		model.addAttribute("cuisineList", cuisineList);
		
		return "menu/list";
	}
	
}
