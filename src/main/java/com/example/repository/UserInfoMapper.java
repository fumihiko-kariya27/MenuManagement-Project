package com.example.repository;

import java.util.List;

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
	
	/* ユーザー複数件取得 */
	public List<UserInfo> findManyUser();
	
	/* ユーザー１件取得 */
	public UserInfo findOneUser(String userId);
}
