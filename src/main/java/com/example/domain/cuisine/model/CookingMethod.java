package com.example.domain.cuisine.model;

/*
 * 調理方法を定義する
 */

public enum CookingMethod {
	// 煮る
	Boil("Boil"),
	// 蒸す
	Steam("Steam"),
	// 焼く
	Grill("Grill"),
	// 揚げる
	Fry("Fry"),
	// 生
	Raw("Raw");
	
	private String cookingMethod;
	
	private CookingMethod(String cookingMethod)
	{
		this.cookingMethod = cookingMethod;
	}
	
	public String toString()
	{
		return this.cookingMethod;
	}
}
