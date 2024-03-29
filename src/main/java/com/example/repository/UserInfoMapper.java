package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	
	/* ユーザー更新 */
	public void updateOneUser(@Param("userId") String userId, @Param("userName") String userName);
	
	/* ユーザー削除 */
	public void deleteOneUser(@Param("userId") String userId);
	
	/* ログインユーザー取得 */
	public UserInfo findLoginUser(String userId);
}
