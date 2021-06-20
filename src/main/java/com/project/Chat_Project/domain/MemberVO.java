package com.project.Chat_Project.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //매개변수를 가지지 않는 생성자 생성
public class MemberVO implements UserDetails{

	private static final long serialVersionUID = 1L;

	private String userId, user_name, userPw, userEmail, auth;
	private char userGender, userDeletedYn;
	private Date userRegDate;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> roles = new HashSet<>();
		for(String role : auth.split(",")) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		return roles;
	}
	@Override
	public String getPassword() {
		return userPw;
	}
	
	@Override
	public String getUsername() {
		return userId;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//생성자
	public MemberVO(String userId, String user_name, String userPw, String userEmail, String auth, char userGender,
			char userDeletedYn, Date userRegDate) {
		this.userId = userId;
		this.user_name = user_name;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.auth = auth;
		this.userGender = userGender;
		this.userDeletedYn = userDeletedYn;
		this.userRegDate = userRegDate;
	}
}
