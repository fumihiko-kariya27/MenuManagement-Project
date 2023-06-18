package com.example.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.repository.UserInfoMapper;
import com.example.domain.user.model.UserInfo;
import com.example.domain.user.service.UserService;

/**
 * @author kariyafumihiko
 * ユーザー情報を受け取り、DBに対する操作を行う
 */

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserInfoMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	// ユーザー登録
	@Override
	public void signUp(UserInfo user) {
		// パスワード暗号化
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		
		mapper.insertOneUser(user);
	}

	// ユーザー一覧取得
	@Override
	public List<UserInfo> getUsers() {
		return mapper.findManyUser();
	}

	// ユーザー取得
	@Override
	public UserInfo getUser(String userId) {
		return mapper.findOneUser(userId);
	}

	// ユーザー更新
	@Override
	public void updateUser(String userId, String userName) {
		mapper.updateOneUser(userId, userName);
	}

	// ユーザー削除
	@Override
	public void deleteUser(String userId) {
		mapper.deleteOneUser(userId);
	}

	// ログインユーザー取得
	public UserInfo getLoginUser(String userId) {
		return mapper.findLoginUser(userId);
	}

}
