package com.example.domain.cuisine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.cuisine.model.CuisineInfo;
import com.example.domain.cuisine.service.CuisineService;
import com.example.repository.CuisineInfoMapper;

/**
 * @author kariyafumihiko
 * メニュー情報を受け取り、DBに対する操作を行う
 */

@Service
public class CuisineServiceImpl implements CuisineService {
	
	@Autowired
	private CuisineInfoMapper mapper;

	// メニュー全件取得
	@Override
	public List<CuisineInfo> getAllCuisine() {
		return mapper.getAllCuisine();
	}

	// メニュー登録
	@Override
	public void registCuisine(CuisineInfo cuisineInfo) {
		mapper.registCuisine(cuisineInfo);
	}

	@Override
	public CuisineInfo getCuisineByName(String cuisineName) {
		return mapper.getCuisineByName(cuisineName);
	}

	@Override
	public void deleteCuisine(String cuisineName) {
		mapper.deleteCuisine(cuisineName);
	}

}
