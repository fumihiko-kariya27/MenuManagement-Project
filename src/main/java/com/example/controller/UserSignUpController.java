package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import com.example.domain.user.model.UserInfo;
import com.example.domain.user.service.UserService;
import com.example.form.SignUpForm;
import com.example.form.ValidationGroupOrder;
import com.example.service.GenderMapGenerater;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kariyafumihiko
 * メニュー管理プログラムのユーザー登録画面のコントローラー
 */

@Controller
@RequestMapping("/user")
@Slf4j
public class UserSignUpController {
	
	@Autowired
	private GenderMapGenerater genderMapGenerater;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// ユーザー登録画面に遷移
	@GetMapping("/signup")
	public String getSignUp(Model model, @ModelAttribute SignUpForm form)
	{
		Map<String, Integer> genderMap = genderMapGenerater.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		
		return "user/signup";
	}
	
	// ユーザー登録処理後ユーザー一覧画面に遷移
	@PostMapping("/signup")
	public String postSignup(Model model, @ModelAttribute @Validated(value = ValidationGroupOrder.class) SignUpForm form, BindingResult bindingResult)
	{
		// バインドでエラーが発生していた場合はユーザー登録画面に戻る
		if(bindingResult.hasErrors())
		{
			log.error("ユーザー登録情報でバインドエラーが発生しました");
			return getSignUp(model, form);
		}
		
		log.info(form.toString());
		
		// Formをユーザー情報に変換し、DBに登録
		UserInfo user = modelMapper.map(form, UserInfo.class);
		userService.signUp(user);
		
		return "redirect:/user/list";
	}
}
