package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.UserInfo;
import com.example.domain.user.service.UserService;
import com.example.form.UserDetailForm;

/**
 * @author kariyafumihiko
 * ユーザー詳細情報を制御するコントローラー
 */

@Controller
@RequestMapping("/user")
public class UserDetailController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/detail/{userId}")
	public String getUser(UserDetailForm form, Model model, @PathVariable("userId") String userId)
	{
		// ユーザーIDをキーとしてユーザーを検索して、モデルに登録
		UserInfo user = service.getUser(userId);
		form = modelMapper.map(user, UserDetailForm.class);
		model.addAttribute("userDetail", form);
		
		return "user/detail";
	}
}
