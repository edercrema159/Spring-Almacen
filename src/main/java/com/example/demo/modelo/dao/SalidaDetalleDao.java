package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.SalidaDetalle;

@Repository
public class SalidaDetalleDao implements ISalidaDetalleDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<SalidaDetalle> listar() {
		String sql = "SELECT * FROM salidadetalle WHERE estado=1";
		List<SalidaDetalle> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(SalidaDetalle.class));
		return lista;
	}

	@Override
	public int guardar(SalidaDetalle salida) {
		String sql = "INSERT INTO salidadetalle (idSalida, idProducto, cantidad, costo) values (?,?,?,?)";
		return jdbctemplate.update(sql, salida.getIdSalida(), salida.getIdProducto(), salida.getCantidad(), salida.getCosto());
	}

	@Override
	public SalidaDetalle buscarID(int idSalidaDetalle) {
		String sql = "SELECT * FROM salidadetalle where idSalida = ?";
		SalidaDetalle salidadetalle = jdbctemplate.queryForObject(sql, new Object[] {
				idSalidaDetalle },
				BeanPropertyRowMapper.newInstance(SalidaDetalle.class));
		return salidadetalle;
	}

	@Override
	public int actualizar(SalidaDetalle salidadetalle) {
		String sql = "UPDATE salidadetalle set idSalida=?, idProducto=?, cantidad=?, costo=?  WHERE idSalidaDetalle = ?";
		return jdbctemplate.update(sql, salidadetalle.getIdSalida(), salidadetalle.getIdProducto(), salidadetalle.getCantidad(),
				salidadetalle.getCantidad(), salidadetalle.getIdSalidaDetalle());
	}

	@Override
	public int borrar(int idSalidaDetalle) {
		String sql = "UPDATE salidadetalle set estado=0 where idSalidaDetalle=?";
		return jdbctemplate.update(sql, idSalidaDetalle);
	}
}
