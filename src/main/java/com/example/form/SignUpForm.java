package com.example.form;

import lombok.Data;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * @author 刈谷　文彦
 * ユーザー登録画面の入力情報のマッピングクラス
 */

@Data
public class SignUpForm {
	
	// ユーザーID
	@NotBlank(groups = ValidationGroupFirst.class)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidationGroupSecond.class)
	private String userId;
	
	// ユーザー名
	@NotBlank(groups = ValidationGroupFirst.class)
	@Pattern(regexp = "[^!\"#$%&'()\\*\\+\\-\\.,\\/:;<=>?@\\[\\\\\\]^_`{|}~]+", groups = ValidationGroupSecond.class)
	private String userName;
	
	// パスワード
	@NotBlank(groups = ValidationGroupFirst.class)
	@Pattern(regexp = "[^!\"#$%&'()\\*\\+\\-\\.,\\/:;<=>?@\\[\\\\\\]^_`{|}~]+", groups = ValidationGroupSecond.class)
	@Length(min = 8, max = 16)
	private String password;
	
	// 性別
	@NotNull(groups = ValidationGroupFirst.class)
	@NotNull
	private int gender;
	
	// 権限
	private int role;
}
