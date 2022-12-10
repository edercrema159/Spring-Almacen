package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Salida;

@Repository
public class SalidaDao implements ISalidaDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Salida> listar() {
		String sql = "SELECT * FROM salida WHERE estado=1";
		List<Salida> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Salida.class));
		return lista;
	}

	@Override
	public int guardar(Salida salida) {
		String sql = "INSERT INTO salida (documento, fecha, idAlmacen, idProveedor) values (?,?,?,?)";
		return jdbctemplate.update(sql, salida.getDocumento(), salida.getFecha(),
				salida.getIdAlmacen(),
				salida.getIdProveedor());
	}

	@Override
	public Salida buscarID(int idSalida) {
		String sql = "SELECT * FROM salida where idSalida = ?";
		Salida salida = jdbctemplate.queryForObject(sql, new Object[] {
				idSalida },
				BeanPropertyRowMapper.newInstance(Salida.class));
		return salida;
	}

	@Override
	public int actualizar(Salida salida) {
		String sql = "UPDATE salida set documento=?, fecha=?, idAlmacen=?, idProveedor=?  WHERE idSalida = ?";
		return jdbctemplate.update(sql, salida.getDocumento(), salida.getFecha(), salida.getIdAlmacen(),
				salida.getIdProveedor(), salida.getIdSalida());
	}

	@Override
	public int borrar(int idSalida) {
		String sql = "UPDATE salida set estado=0 where idSalida=?";
		return jdbctemplate.update(sql, idSalida);
	}
}
