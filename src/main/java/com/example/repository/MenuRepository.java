package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author 刈谷　文彦
 * メニュー管理マスタテーブルへのアクセスを実行する
 */

@Repository
class MenuRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	Map<String, Object> getMenuById(int id)
	{
		String sql = "SELECT * FROM menu_master WHERE menu_id = ?";
		
		Map<String, Object> menu = jdbcTemplate.queryForMap(sql, id);
		return menu;
	}
	
	void add(String menu_name)
	{
		int idMax = jdbcTemplate.getMaxRows();
		jdbcTemplate.queryForList("INSERT INTO menu_master(menu_id, menu_name) VALUES(?, ?);", idMax + 1, menu_name);
	}
}
