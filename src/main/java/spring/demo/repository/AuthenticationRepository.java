package spring.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Repository;

import spring.demo.entity.Usuario;


@Repository
public class AuthenticationRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Usuario login(String correo, String password) throws BadCredentialsException {
		logger.info("login("+correo+","+password+")");
		
		String sql="select count(*) from usuario where correo=? and password=?";
		
		Integer exists = jdbcTemplate.queryForObject(sql, Integer.class, correo, password);
		
		if(exists==0) {
			throw new BadCredentialsException("Usuario y/o clave invalido");
		}
		
		return findByCorreo(correo);
	}
	
	public Usuario findByCorreo(String correo) throws EmptyResultDataAccessException{
		logger.info("findByCorreo("+correo+")");
		
		String sql = "select * from usuario where correo=?";
		
		Usuario usuario = jdbcTemplate.queryForObject(sql, new RowMapper<Usuario>() {
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
				Usuario usuario = new Usuario();
				usuario.setUser_id(rs.getLong("user_id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellidos(rs.getString("apellidos"));
				usuario.setTipo(rs.getString("tipo"));
				usuario.setCorreo(rs.getString("correo"));
				
				return usuario;
				
				
			}
		},correo);
		
		logger.info("user: "+usuario);
		
		return usuario;
	}
}
