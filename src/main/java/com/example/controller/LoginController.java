package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.cuisine.model.CuisineInfo;
import com.example.domain.cuisine.service.CuisineService;

/**
 * @author kariyafumihiko
 * メニュー管理プログラムへのログインを管理するコントローラー
 */
@Controller
public class LoginController {
	
	@Autowired
	private CuisineService service;
	
	@GetMapping("/login")
	public String getLogin()
	{
		return "login/login";
	}
	
	// ログイン後はメニュー一覧画面に遷移
	@PostMapping("/login")
	public String postLogin(Model model)
	{
		// メニュー一覧を取得してモデルに登録
		List<CuisineInfo> cuisineList = service.getAllCuisine();
		model.addAttribute("cuisineList", cuisineList);
		
		return "redirect:/menu/list";
	}
}
