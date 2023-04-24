package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.UserInfo;
import com.example.domain.user.service.UserService;
import com.example.form.UserDetailForm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kariyafumihiko
 * ユーザー詳細情報を制御するコントローラー
 */

@Controller
@RequestMapping("/user")
@Slf4j
public class UserDetailController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// ユーザー詳細画面を表示
	@GetMapping("/detail/{userId}")
	public String getUser(UserDetailForm form, Model model, @PathVariable("userId") String userId)
	{
		// ユーザーIDをキーとしてユーザーを検索して、モデルに登録
		UserInfo user = service.getUser(userId);
		form = modelMapper.map(user, UserDetailForm.class);
		model.addAttribute("userDetail", form);
		
		return "user/detail";
	}
	
	// ユーザー更新処理
	@Transactional
	@PostMapping(value="/detail", params="update")
	public String updateUser(UserDetailForm form, Model model)
	{
		// ユーザー更新後、一覧画面にリダイレクト
		log.info("IDの値：" + form.getUserId());
		service.updateUser(form.getUserId(), form.getUserName());
		return "redirect:/user/list";
	}
	
	// ユーザー削除処理
	@Transactional
	@PostMapping(value="/detail", params="delete")
	public String deleteUser(UserDetailForm form)
	{
		// ユーザー削除後、一覧画面にリダイレクト
		service.deleteUser(form.getUserId());
		return "redirect:/user/list";
	}
}
