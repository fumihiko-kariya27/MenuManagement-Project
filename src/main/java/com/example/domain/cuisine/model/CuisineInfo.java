package com.example.domain.cuisine.model;

import lombok.Data;

/**
 * @author kariyafumihiko
 * メニュー情報とメニューマスタテーブルのマッピングクラス
 */

@Data
public class CuisineInfo {
	
	private String cuisineId;
	private String cuisineName;
	private String category;
	private String cookDate;
	
}
