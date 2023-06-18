package com.example.domain.user.model;

import lombok.Data;

/**
 * @author kariyafumihiko
 * システム利用ユーザー情報
 * DBのuser_masterのマッピングオブジェクト
 */

@Data
public class UserInfo {
	
	private String userId;
	private String userName;
	private String password;
	private int gender;
	private int role;
	
}
