package com.example.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public void signUp(UserInfo user) {
		mapper.insertOneUser(user);
	}

	@Override
	public List<UserInfo> getUsers() {
		return mapper.findManyUser();
	}

	@Override
	public UserInfo getUser(String userId) {
		return mapper.findOneUser(userId);
	}

	@Override
	public void updateUser(String userId, String userName) {
		mapper.updateOneUser(userId, userName);
	}

	@Override
	public void deleteUser(String userId) {
		mapper.deleteOneUser(userId);
	}

}
