package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
 * セキュリティの各種設定
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// パスワード暗号化
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
	{		
		// 静的リソースは保護対象外とする
		http.authorizeHttpRequests(
				auth -> auth
				.requestMatchers("/css/**").permitAll()
				.requestMatchers("/webjars/**").permitAll()
				.requestMatchers("/js/**").permitAll()
				.requestMatchers("/h2-console/**").permitAll()
				);

		// ログイン画面とユーザー登録画面以外の直リンクを禁止
		http.authorizeHttpRequests(
				auth -> auth
				.requestMatchers("/login").permitAll()
				.requestMatchers("/user/signup").permitAll()
				.anyRequest().authenticated()
				);

		// ログイン処理の設定
		http.formLogin()
		.loginProcessingUrl("/login")
		.loginPage("/login")
		.failureUrl("/login?error")
		.usernameParameter("userId")
		.passwordParameter("password")
		.defaultSuccessUrl("/menu/list", true);

		http.csrf().disable();

		return http.build();
	}
	
	// インメモリ認証を使用して、仮のユーザーIDとパスワードを使用してログインできるようにする
//	@Bean
//	public UserDetailsService users() {
//
//		UserDetails user = User.builder()
//				.username("user")
//				.password(passwordEncoder().encode("user"))
//				.authorities("USER")
//				.build();
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password(passwordEncoder().encode("admin"))
//				.authorities("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
	
}
