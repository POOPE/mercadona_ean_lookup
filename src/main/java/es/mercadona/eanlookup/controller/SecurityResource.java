package es.mercadona.eanlookup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.mercadona.eanlookup.application.security.jwt.JwtRequest;
import es.mercadona.eanlookup.application.security.jwt.JwtResponse;
import es.mercadona.eanlookup.application.security.jwt.JwtUtils;
import es.mercadona.eanlookup.service.UserService;


@RestController
@RequestMapping("/security")
public class SecurityResource {
	
	@Autowired
	AuthenticationManager authenticationManager;
//
	@Autowired
	UserService userService;

//	@Autowired
//	RoleRepository roleRepository;
//
//	@Autowired
//	PasswordEncoder encoder;
//
	@Autowired
	JwtUtils jwtUtils;
//
	@PostMapping("/login")
	public JwtResponse authenticateUser(@Valid @RequestBody JwtRequest request) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
//
//		return new JwtResponse(jwt);
		return new JwtResponse(jwt);
	}
	
	@PostMapping("register")
	public JwtResponse registerUser(@Valid @RequestBody JwtRequest request) {
		userService.registerUser(request);
		
		return authenticateUser(request);
	}

}
