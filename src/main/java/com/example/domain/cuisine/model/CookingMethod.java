package com.example.domain.cuisine.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 調理方法を定義する
 */

public enum CookingMethod {
	// 煮る
	Boil("煮込み料理", 0.9),
	// 蒸す
	Steam("蒸し料理", 0.7),
	// 焼く
	Grill("焼き料理", 1.1),
	// 揚げる
	Fry("揚げ料理", 1.3),
	// 生
	Raw("生食", 1.0);
	
	// 調理方法
	private String cookingMethod;
	// カロリー係数
	private double coefficient;
	
	private CookingMethod(String cookingMethod, double coefficient)
	{
		this.cookingMethod = cookingMethod;
		this.coefficient = coefficient;
	}
	
	public String toString()
	{
		return this.cookingMethod;
	}

	public double getCoefficient() {
		return coefficient;
	}
	
	// 調理方法一覧を返却する
	public static List<String> getCookMethods()
	{
		return Arrays.asList(CookingMethod.values()).stream().map(methods -> methods.toString()).collect(Collectors.toList());
	}
}
