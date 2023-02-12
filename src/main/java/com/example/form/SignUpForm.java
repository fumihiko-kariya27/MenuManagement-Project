package com.example.form;

import lombok.Data;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * @author 刈谷　文彦
 * ユーザー登録画面の入力情報のマッピングクラス
 */

@Data
public class SignUpForm {
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String userId;
	
	@NotBlank
	@Pattern(regexp = "[^!\"#$%&'()\\*\\+\\-\\.,\\/:;<=>?@\\[\\\\\\]^_`{|}~]+")
	private String userName;
	
	@NotBlank
	@Pattern(regexp = "[^!\"#$%&'()\\*\\+\\-\\.,\\/:;<=>?@\\[\\\\\\]^_`{|}~]+")
	@Length(min = 8, max = 16)
	private String password;
	
	private int gender;
}
