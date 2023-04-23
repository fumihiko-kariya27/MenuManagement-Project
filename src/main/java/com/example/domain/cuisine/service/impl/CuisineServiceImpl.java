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

	@Override
	public List<CuisineInfo> getAllCuisine() {
		return mapper.getAllCuisine();
	}

}
