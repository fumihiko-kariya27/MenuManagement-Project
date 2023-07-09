package com.example.form;

import lombok.Data;

/**
 * @author kariyafumihiko
 * メニュー詳細フォームクラス
 */

@Data
public class CuisineDetailForm {
	// 料理名
	private String cuisineName;
	// カテゴリ
	private String category;
	// 最近の調理日
	private String cookDate;
	// 具材
	private String ingredients;
}
