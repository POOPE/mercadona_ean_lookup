package es.mercadona.eanlookup.application.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.mercadona.eanlookup.domain.entity.security.UserEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MercadonaUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5278013841113262866L;
	
	String username;
	@JsonIgnore
	String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public static MercadonaUserDetails build(UserEntity user) {
		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole()))
				.collect(Collectors.toSet());

		return new MercadonaUserDetails(
				user.getUsername(), 
				user.getPassword(), 
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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
