package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kariyafumihiko
 * メニュー管理プログラムのメニュー一覧表示のコントローラー
 */

@Controller
@RequestMapping("/menu")
public class MenuListController {
	
	@GetMapping("/list")
	public String getMenuList()
	{
		// メニュー一覧画面を表示
		return "menu/list";
	}
}
