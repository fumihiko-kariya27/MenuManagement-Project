package com.example.form;

import lombok.Data;

/**
 * @author 刈谷　文彦
 * ユーザー登録画面の入力情報のマッピングクラス
 */

@Data
public class SignUpForm {
	
	private String userId;
	private String userName;
	private String password;
	private int gender;
}
