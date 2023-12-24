package com.example.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author kariyafumihiko
 * メニュー登録用のマッピングクラス
 */

@Data
public class CuisineRegistForm {
	
	// メニュー名
	@NotBlank(groups = ValidationGroupFirst.class)
	@Length(min = 2)
	@Pattern(regexp = "[^!\"#$%&'()\\*\\+\\-\\.,\\/:;<=>?@\\[\\\\\\]^_`{|}~]+", groups = ValidationGroupSecond.class)
	private String cuisineName;
	
	// カテゴリー
	@NotBlank(groups = ValidationGroupFirst.class)
	@Pattern(regexp = "[^!\"#$%&'()\\*\\+\\-\\.,\\/:;<=>?@\\[\\\\\\]^_`{|}~]+", groups = ValidationGroupSecond.class)
	private String category;
	
	// 調理方法
	@NotBlank(groups = ValidationGroupFirst.class)
	@Pattern(regexp = "[^!\"#$%&'()\\*\\+\\-\\.,\\/:;<=>?@\\[\\\\\\]^_`{|}~]+", groups = ValidationGroupSecond.class)
	private String cookMethod;
	
	// 食材
	private String[] ingredientsAry;
	private String ingredients = "";
}
