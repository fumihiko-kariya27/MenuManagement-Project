package com.example.domain.cuisine.model;

import lombok.Data;

/**
 * @author kariyafumihiko
 * メニュー情報とメニューマスタテーブルのマッピングクラス
 */

@Data
public class CuisineInfo {
	// ID
	private String cuisineId;
	// 料理名
	private String cuisineName;
	// カテゴリ
	private String category;
	// 調理方法
	private String cookMethod;
	// 最近の調理日
	private String cookDate;
	// 具材
	private String ingredients;
}
