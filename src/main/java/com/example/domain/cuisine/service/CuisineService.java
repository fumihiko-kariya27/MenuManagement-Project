package com.example.domain.cuisine.service;

import java.util.List;

import com.example.domain.cuisine.model.CuisineInfo;

public interface CuisineService {
	
	/* メニュー全件取得 */
	public List<CuisineInfo> getAllCuisine();
	
	/* メニュー登録 */
	public void registCuisine(CuisineInfo cuisineInfo);
	
	/* メニュー１件取得 */
	public CuisineInfo getCuisineByName(String cuisineName);
	
	/* メニュー削除 */
	public void deleteCuisine(String cuisineName);
	
	/* カテゴリーによるメニュー検索 */
	public List<CuisineInfo> getCuisineByCategory(String category);
}
