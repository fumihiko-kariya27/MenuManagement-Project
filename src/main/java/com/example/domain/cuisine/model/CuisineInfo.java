package com.example.domain.cuisine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author kariyafumihiko
 * メニュー情報とメニューマスタテーブルのマッピングクラス
 */

@Data
@Entity
public class CuisineInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
