package com.example.domain.cuisine.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kariyafumihiko
 * 食材情報のマッピングクラス
 */

@Data
@AllArgsConstructor
public class Ingredients {
	// 食材名
	private String name;
	// カテゴリー
	private String category;
	//　価格
	private int price;
	// カロリー
	private int calories;
}
