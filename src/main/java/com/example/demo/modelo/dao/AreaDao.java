package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Area;

@Repository
public class AreaDao implements IAreaDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Area> listar() {
		String sql = "SELECT * FROM area WHERE estado=1";
		List<Area> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Area.class));
		return lista;
	}

	@Override
	public int guardar(Area area) {
		String sql = "INSERT INTO area (descripcion) values (?)";
		return jdbctemplate.update(sql, area.getDescripcion());
	}

	@Override
	public Area buscarID(int idArea) {
		String sql = "SELECT * FROM area where idArea = ?";
		Area area = jdbctemplate.queryForObject(sql, new Object[] {
				idArea },
				BeanPropertyRowMapper.newInstance(Area.class));
		return area;
	}

	@Override
	public int actualizar(Area area) {
		String sql = "UPDATE area set descripcion=? where idArea=?";
		return jdbctemplate.update(sql, area.getDescripcion(), area.getIdArea());
	}

	@Override
	public int borrar(int idArea) {
		String sql = "UPDATE area set estado=0 where idArea=?";
		return jdbctemplate.update(sql, idArea);
	}
}
