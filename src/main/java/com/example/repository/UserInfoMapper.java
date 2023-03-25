package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.user.model.UserInfo;

/**
 * @author kariyafumihiko
 * user_masterテーブル用のリポジトリ
 */

@Mapper
public interface UserInfoMapper {
	
	/* ユーザー登録 */
	public int insertOneUser(UserInfo user);
}
