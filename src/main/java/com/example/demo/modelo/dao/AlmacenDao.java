package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Almacen;

@Repository
public class AlmacenDao implements IAlmacenDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Almacen> listar() {
		String sql = "SELECT a.*, area.descripcion as area FROM almacen a LEFT JOIN area on area.idArea=a.idArea WHERE a.estado=1";
		List<Almacen> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Almacen.class));
		return lista;
	}

	@Override
	public List<Almacen> listarArea() {
		String sql = "SELECT * FROM area WHERE estado=1";
		List<Almacen> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Almacen.class));
		return lista;
	}

	@Override
	public int guardar(Almacen almacen) {
		String sql = "INSERT INTO almacen (descripcion, idArea) values (?,?)";
		return jdbctemplate.update(sql, almacen.getDescripcion(), almacen.getIdArea());
	}

	@Override
	public Almacen buscarID(int idAlmacen) {
		String sql = "SELECT * FROM almacen where idAlmacen = ?";
		Almacen almacen = jdbctemplate.queryForObject(sql, new Object[] {
				idAlmacen },
				BeanPropertyRowMapper.newInstance(Almacen.class));
		return almacen;
	}

	@Override
	public int actualizar(Almacen almacen) {
		String sql = "UPDATE almacen set descripcion=?, idArea=? where idAlmacen=?";
		return jdbctemplate.update(sql, almacen.getDescripcion(), almacen.getIdArea(), almacen.getIdAlmacen());
	}

	@Override
	public int borrar(int idAlmacen) {
		String sql = "UPDATE almacen set estado=0 where idAlmacen=?";
		return jdbctemplate.update(sql, idAlmacen);
	}
}

