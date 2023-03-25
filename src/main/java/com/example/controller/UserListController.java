package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.UserInfo;
import com.example.domain.user.service.UserService;

/**
 * @author kariyafumihiko
 * ユーザー一覧の取得を制御するコントローラー
 */

@Controller
@RequestMapping("/user")
public class UserListController {
	
	@Autowired
	private UserService service;
	
	// ユーザー一覧画面に遷移
	@GetMapping("/list")
	public String getUserList(Model model)
	{
		// ユーザー一覧を取得してモデルに登録
		List<UserInfo> userList = service.getUsers();
		model.addAttribute("userList", userList);
		
		return "user/list";
	}
	
}
