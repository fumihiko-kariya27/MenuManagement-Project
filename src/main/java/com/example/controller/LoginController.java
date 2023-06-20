package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author kariyafumihiko
 * メニュー管理プログラムへのログインを管理するコントローラー
 */
@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getLogin()
	{
		return "login/login";
	}
	
	// ログイン後はメニュー一覧画面に遷移
	@PostMapping("/login")
	public String postLogin(Model model)
	{	
		return "redirect:/menu/list";
	}
}
