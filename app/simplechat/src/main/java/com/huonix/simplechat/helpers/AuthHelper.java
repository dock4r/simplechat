package com.huonix.simplechat.helpers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.huonix.simplechat.models.User;

/**
 * Authentication Helpers
 * 
 * @author Kepler Vital
 *
 */
public class AuthHelper {
	
	/**
	 * Loads the authenticated user authorities
	 * 
	 * @return Set<String>
	 */
	public static Set<String> userAuthorities() {
		Set<String> userAuthorities = new HashSet<>();
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			for(Object authority : auth.getAuthorities()) {
				userAuthorities.add(((GrantedAuthority)authority).getAuthority());
			}
		} catch(Exception e) {
			
		}
		return userAuthorities;
	}
	
	/**
	 * Loads the authenticated user authorities
	 * 
	 * @return Set<String>
	 */
	public static User user() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return (User) auth.getDetails();
	}
	
}