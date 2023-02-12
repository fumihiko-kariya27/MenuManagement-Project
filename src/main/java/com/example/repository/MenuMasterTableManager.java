package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.example.entity.MenuContents;

/**
 * メニュー管理マスタテーブルへのアクセスの入り口のクラス
 * @author 刈谷　文彦
 */

@Service
public class MenuMasterTableManager {
	
	@Autowired
	private MenuRepository repository;
	
	/**
	 * メニューIDで指定したメニュー情報を取得する
	 * @param メニューID
	 * @return メニュークラス情報
	 */
	public MenuContents getMenuById(int id)
	{
		Map<String, Object> map = repository.getMenuById(id);
		
		int menuId = (Integer)map.get("menu_id");
		String menuName = (String)map.get("menu_name");
		
		MenuContents menu = new MenuContents(menuId, menuName);
		return menu;
	}
	
	/**
	 * メニューを追加する
	 * メニューIDは自動採番される
	 */
	public void addMenu(String menu_name)
	{
		repository.add(menu_name);
	}
}
