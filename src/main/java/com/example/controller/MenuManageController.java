package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.MenuContents;
import com.example.repository.MenuMasterTableManager;

/**
 * @author 刈谷　文彦
 * メニューに関するアクセスを一元管理する
 */

@Controller
public class MenuManageController {
	
	@Autowired
	private MenuMasterTableManager menuMasterTableManager;

	@GetMapping("/menu_search")
	public String getMenuSearch() 
	{
		return "menu/search";
	}
	
	/**
	 * メニューを検索する
	 * @param メニューID
	 * @return メニュー情報（Modelに登録）
	 */
	@PostMapping("/menu_search")
	public String postMenuSearch(@RequestParam("menu_id") String id, Model model)
	{
		MenuContents menu = menuMasterTableManager.getMenuById(Integer.parseInt(id));
		model.addAttribute("menu", menu);
		
		return "menu/search_result";
	}
	
	/**
	 * メニューを追加する
	 */
	@PostMapping("/menu_add")
	public String postMenuAdd(@RequestParam("menu_name") String menu_name, Model model)
	{
		if(menu_name.isEmpty())
		{
			// メニュー名が空欄で入力された場合は例外をスローする
			throw new IllegalArgumentException("メニュー名に空欄は指定できません");
		}
		
		menuMasterTableManager.addMenu(menu_name);
		String retMsg = menu_name.concat("を追加しました");
		
		model.addAttribute("result_message", retMsg);
		
		return "home";
	}
	
}
