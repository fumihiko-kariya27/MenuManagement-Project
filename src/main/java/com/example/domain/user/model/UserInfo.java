package com.example.domain.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author kariyafumihiko
 * システム利用ユーザー情報
 * DBのuser_masterのマッピングオブジェクト
 */

@Data
@Entity
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// ID
	private String userId;
	// ユーザー名
	private String userName;
	// パスワード
	private String password;
	// 性別
	private int gender;
	// 権限
	private String role;
}
