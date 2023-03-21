package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 刈谷　文彦
 * メニュー管理プログラムのホーム画面へのコントローラー
 *
 */

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHome()
	{
		return "home";
	}
	
}
