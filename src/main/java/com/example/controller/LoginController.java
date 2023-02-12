package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
