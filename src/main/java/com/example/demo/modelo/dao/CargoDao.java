package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Cargo;

@Repository
public class CargoDao implements ICargoDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Cargo> listar() {
		String sql = "SELECT * FROM cargo WHERE estado=1";
		List<Cargo> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Cargo.class));
		return lista;
	}

	@Override
	public int guardar(Cargo cargo) {
		String sql = "INSERT INTO cargo (descripcion) values (?)";
		return jdbctemplate.update(sql, cargo.getDescripcion());
	}

	@Override
	public Cargo buscarID(int idCargo) {
		String sql = "SELECT * FROM cargo where idCargo = ?";
		Cargo cargo = jdbctemplate.queryForObject(sql, new Object[] {
				idCargo },
				BeanPropertyRowMapper.newInstance(Cargo.class));
		return cargo;
	}

	@Override
	public int actualizar(Cargo cargo) {
		String sql = "UPDATE cargo set descripcion=? where idCargo=?";
		return jdbctemplate.update(sql, cargo.getDescripcion(), cargo.getIdCargo());
	}

	@Override
	public int borrar(int idCargo) {
		String sql = "UPDATE cargo set estado=0 where idCargo=?";
		return jdbctemplate.update(sql, idCargo);
	}
}