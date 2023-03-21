package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kariyafumihiko
 * メニュー管理プログラムのログアウトを管理するコントローラー
 */

@Controller
@Slf4j
public class LogoutController {

	// ログアウト後はログイン画面に遷移
	@PostMapping("/logout")
	public String postLogout()
	{
		log.info("ログアウト");
		return "redirect:/login";
	}
}
