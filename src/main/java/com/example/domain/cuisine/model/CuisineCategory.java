package com.example.domain.cuisine.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 料理のカテゴリを定義する
 */

public enum CuisineCategory {
	// 和食
	JAPANESE("和食"),
	// 洋食
	WESTERN("洋食"),
	// 中華
	CHINESE("中華"),
	// その他
	OHTER("その他");
	
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
	
	// カテゴリー一覧を返却する
	public static List<String> getCategories()
	{
		return Arrays.asList(CuisineCategory.values()).stream().map(category -> category.toString()).collect(Collectors.toList());
	}
	
}
