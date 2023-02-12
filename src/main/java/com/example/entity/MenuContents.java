package com.example.entity;

import lombok.Getter;

/**
 * 
 * @author 刈谷　文彦
 * メニュー管理マスタテーブルの情報を保管するマッピングクラス
 */

@Getter
public class MenuContents {
	
	// メニューIDの最小値、1未満は指定不可
	final int MENU_ID_MIN = 1;
	
	private int id;
	private String name;
	
	public MenuContents(int id, String name)
	{
		if(id < MENU_ID_MIN)
		{
			// メニューIDが1未満の場合は例外をスローする
			throw new IllegalArgumentException("メニューIDに1より小さい値は指定できません");
		}
		
		if(name.isEmpty())
		{
			// メニュー名が空文字の場合は例外をスローする
			throw new IllegalArgumentException("料理名は空にはできません");
		}
		
		this.id = id;
		this.name = name;
	}
}
