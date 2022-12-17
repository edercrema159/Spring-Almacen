package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Usuario;

@Repository
public class UsuarioDao implements IUsuarioDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Usuario> listar() {
		String sql = "SELECT * FROM usuario WHERE estado=1";
		List<Usuario> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Usuario.class));
		return lista;
	}

	@Override
	public List<Usuario> listarCargo() {
		String sql = "SELECT *, descripcion as cargo FROM cargo WHERE estado=1";
		List<Usuario> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Usuario.class));
		return lista;
	}

	@Override
	public int guardar(Usuario usuario) {
		String sql = "INSERT INTO usuario (Usuario, contraseña, idCargo, nombres, apellidos, documento, telefono, correo) values (?,?,?,?,?,?,?,?)";
		return jdbctemplate.update(sql, usuario.getUsuario(), usuario.getContraseña(),
				usuario.getIdCargo(), usuario.getNombres(), usuario.getApellidos(), usuario.getDocumento(), usuario.getTelefono(), usuario.getCorreo());
	}

	@Override
	public Usuario buscarID(int idUsuario) {
		String sql = "SELECT * FROM usuario where idUsuario = ?";
		Usuario Usuario = jdbctemplate.queryForObject(sql, new Object[] {
				idUsuario },
				BeanPropertyRowMapper.newInstance(Usuario.class));
		return Usuario;
	}

	@Override
	public int actualizar(Usuario usuario) {
		String sql = "UPDATE usuario set Usuario=?, contraseña=?, idCargo=?, nombres=?, apellidos=?, documento=?, telefono=?, correo=? WHERE idUsuario = ?";
		return jdbctemplate.update(sql, usuario.getUsuario(), usuario.getContraseña(), usuario.getIdCargo(),
				usuario.getNombres(), usuario.getApellidos(), usuario.getDocumento(), usuario.getTelefono(), usuario.getCorreo(), usuario.getIdUsuario());
	}

	@Override
	public int borrar(int idUsuario) {
		String sql = "UPDATE usuario set estado=0 where idUsuario=?";
		return jdbctemplate.update(sql, idUsuario);
	}
}
