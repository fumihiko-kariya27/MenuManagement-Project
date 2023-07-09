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
}
