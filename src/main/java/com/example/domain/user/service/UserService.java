package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.UserInfo;

/**
 * @author kariyafumihiko
 *
 */

public interface UserService {

	/* ユーザー登録 */
	public void signUp(UserInfo user);
	
	/* ユーザー一覧取得 */
	public List<UserInfo> getUsers();
	
	/* ユーザー１件取得 */
	public UserInfo getUser(String userId);
	
}
