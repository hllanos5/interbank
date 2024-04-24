package com.interbank.apirest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.interbank.apirest.model.User;
import com.interbank.apirest.repository.UserRepository;

@Service
public class UserDetailServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository userRespository;
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User usuario= userRespository
				.findOneByEmail(email)
				.orElseThrow(()-> new UsernameNotFoundException("El usuario con email "+email+ " no existe"));
		//Se pone esto porque al levantar el proyecto no se tiene data en al base de datos de H2
		/*User usuario = new User();
		
		usuario.setId(1L);
		usuario.setEmail("hans.llanos@gmail.com");
		usuario.setFirstName("Hans");
		usuario.setLastName("Llanos");
		usuario.setPassword("$2a$10$EKbPJBdp0TOdNddyo7eCceNew24o7eoPrqOt.YfJa9an17wNVaMbm");*/
		
		return new UserDetailsImpl(usuario);
	}
}
