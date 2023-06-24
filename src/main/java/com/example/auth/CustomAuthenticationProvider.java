package com.example.auth;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component("AuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService service;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// 資格情報からユーザー名とパスワードの取得
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String userName = String.valueOf(auth.getPrincipal());
		String password = String.valueOf(auth.getCredentials());
		
		UserDetails user = service.loadUserByUsername(userName);
		if(user == null)
		{
			throw new BadCredentialsException("Wrong password.");
		}
		
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
