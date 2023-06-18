package com.example.domain.cuisine.model;

/*
 * 料理のカテゴリを定義する
 */

public enum CuisineCategory {
	// 和食
	JAPANESE("Japanese"),
	// 洋食
	WESTERN("Western"),
	// 中華
	CHINESE("Chinese");
	
	private String category;
	
	private CuisineCategory(String category)
	{
		this.category = category;
	}
	
	@Override
	public String toString()
	{
		return this.category;
	}
	
}
