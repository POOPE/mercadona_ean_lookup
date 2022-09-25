package es.mercadona.eanlookup.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.mercadona.eanlookup.application.security.MercadonaUserDetails;
import es.mercadona.eanlookup.application.security.jwt.JwtRequest;
import es.mercadona.eanlookup.domain.entity.security.RoleEntity;
import es.mercadona.eanlookup.domain.entity.security.UserEntity;
import es.mercadona.eanlookup.repository.RoleRepository;
import es.mercadona.eanlookup.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepo.findById(username).get();
		return MercadonaUserDetails.build(user);
	}
	
	public UserEntity registerUser(JwtRequest request) {
		UserEntity user = new UserEntity();
		RoleEntity userRole = roleRepo.findById(1).get();
		user.getRoles().add(userRole);
		user.setUsername(request.getUsername());
		user.setPassword(encoder.encode(request.getPassword()));
		return userRepo.save(user);
	}

}
