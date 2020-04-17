package com.example.jpa.jpasecurity;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private List<SimpleGrantedAuthority>authorities;

	public MyUserDetails(User user) {
		this.username = user.getUserName();
		this.password = user.getPassword();
		this.authorities= new LinkedList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRoles()));
	}

	public MyUserDetails() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return "pass";
	}

	@Override
	public String getUsername() {
		return this.username;
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

}
