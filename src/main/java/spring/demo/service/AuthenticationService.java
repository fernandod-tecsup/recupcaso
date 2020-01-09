package spring.demo.service;

import org.springframework.stereotype.Service;

import spring.demo.entity.Usuario;
import spring.demo.repository.AuthenticationRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
	private AuthenticationRepository authenticationRepository;
	
	public Usuario login(String correo, String password)throws BadCredentialsException {
		
		logger.info("login("+correo+","+password+")");
		
		return authenticationRepository.login(correo, password);
		
	}
	
	public Usuario findByCorreo(String correo) throws EmptyResultDataAccessException{
		
		logger.info("findByCorreo("+correo+")");
		return authenticationRepository.findByCorreo(correo);
	}
}
