package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.cuisine.model.CuisineInfo;

/**
 * @author kariyafumihiko
 * cuisine_masterテーブル用のリポジトリ
 */
	
@Mapper
public interface CuisineInfoMapper {
	
	/* メニュー全件取得 */
	public List<CuisineInfo> getAllCuisine();
	
	/* メニュー登録 */
	public void registCuisine(CuisineInfo cuisineInfo);
}
