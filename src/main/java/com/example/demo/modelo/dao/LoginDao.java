package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Login;

@Repository
public class LoginDao implements ILoginDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Login> listar() {
		String sql = "SELECT * FROM login WHERE estado=1";
		List<Login> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Login.class));
		return lista;
	}
	
	@Override
	public int guardar(Login login) {
		String sql = "INSERT INTO login (IdUsuario) values (?)";
		return jdbctemplate.update(sql, login.getIdUsuario());
	}
	
	@Override
	public Login buscarUsuario(Login login) {
		String sql = "SELECT idUsuario FROM usuario where Usuario = ? and contraseña = ? and estado=1 limit 1";
		
		Login log = jdbctemplate.queryForObject(sql, new Object[] {
			login.getUsuario(), login.getContraseña() },
				BeanPropertyRowMapper.newInstance(Login.class));
		return log;
	}

	@Override
	public int actualizar(Login login) {
		String sql = "UPDATE login set IdUsuario=? WHERE idLogin = ?";
		return jdbctemplate.update(sql, login.getIdUsuario());
	}

	@Override
	public int borrar(int idLogin) {
		String sql = "UPDATE login set estado=0 where idLogin=?";
		return jdbctemplate.update(sql, idLogin);
	}
}
