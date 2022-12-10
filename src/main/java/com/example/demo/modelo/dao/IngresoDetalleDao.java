package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.IngresoDetalle;

@Repository
public class IngresoDetalleDao implements IIngresoDetalleDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<IngresoDetalle> listar() {
		String sql = "SELECT * FROM ingresodetalle WHERE estado=1";
		List<IngresoDetalle> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(IngresoDetalle.class));
		return lista;
	}

	@Override
	public int guardar(IngresoDetalle ingresodetalle) {
		String sql = "INSERT INTO ingresodetalle (idIngreso, idProducto, cantidad, costo) values (?,?,?,?)";
		return jdbctemplate.update(sql, ingresodetalle.getIdIngreso(), ingresodetalle.getIdProducto(), ingresodetalle.getCosto(), ingresodetalle.getCosto());
	}

	@Override
	public IngresoDetalle buscarID(int idIngresoDetalle) {
		String sql = "SELECT * FROM ingreso where idIngresoDetalle = ?";
		IngresoDetalle ingresodetalle = jdbctemplate.queryForObject(sql, new Object[] {
				idIngresoDetalle },
				BeanPropertyRowMapper.newInstance(IngresoDetalle.class));
		return ingresodetalle;
	}

	@Override
	public int actualizar(IngresoDetalle ingresodetalle) {
		String sql = "UPDATE ingresodetalle set idIngreso=?, idProducto=?, cantidad=?, costo=? where idIngresoDetalle=?";
		return jdbctemplate.update(sql, ingresodetalle.getIdIngreso(), ingresodetalle.getIdProducto(), ingresodetalle.getCantidad(), ingresodetalle.getCosto(), ingresodetalle.getIdIngresoDetalle());
	}

	@Override
	public int borrar(int idIngresoDetalle) {
		String sql = "UPDATE ingresodetalle set estado=0 where idIngreso=?";
		return jdbctemplate.update(sql, idIngresoDetalle);
	}
}
