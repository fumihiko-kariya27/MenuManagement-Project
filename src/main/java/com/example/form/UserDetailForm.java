package com.example.form;

import lombok.Data;

/**
 * @author kariyafumihiko
 * ユーザーの詳細情報を表すフォームクラス
 */

@Data
public class UserDetailForm {
	private String userId;
	private String userName;
	private int gender;
}
