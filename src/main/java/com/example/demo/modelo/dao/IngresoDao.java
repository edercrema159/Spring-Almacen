package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Ingreso;

@Repository
public class IngresoDao implements IIngresoDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Ingreso> listar() {
		String sql = "SELECT i.*, a.descripcion as almacen, p.razonSocial as proveedor FROM ingreso i LEFT JOIN almacen a ON a.idAlmacen=i.idAlmacen LEFT JOIN proveedor p ON p.idProveedor=i.idProveedor WHERE i.estado=1";
		List<Ingreso> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Ingreso.class));
		return lista;
	}

	@Override
	public List<Ingreso> listarProveedor() {
		String sql = "SELECT *, razonSocial as proveedor FROM proveedor WHERE estado=1";
		List<Ingreso> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Ingreso.class));
		return lista;
	}
	@Override
	public List<Ingreso> listarAlmacen() {
		String sql = "SELECT *, descripcion as almacen FROM almacen WHERE estado=1";
		List<Ingreso> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Ingreso.class));
		return lista;
	}
	@Override
	public int guardar(Ingreso ingreso) {
		String sql = "INSERT INTO ingreso (documento, idProveedor, fecha, idAlmacen) values (?,?,?,?)";
		return jdbctemplate.update(sql, ingreso.getDocumento(), ingreso.getIdProveedor(), ingreso.getFecha(), ingreso.getIdAlmacen());
	}

	@Override
	public Ingreso buscarID(int idIngreso) {
		String sql = "SELECT * FROM ingreso where idIngreso = ?";
		Ingreso ingreso = jdbctemplate.queryForObject(sql, new Object[] {
				idIngreso },
				BeanPropertyRowMapper.newInstance(Ingreso.class));
		return ingreso;
	}

	@Override
	public int actualizar(Ingreso ingreso) {
		String sql = "UPDATE ingreso set documento=?, idProveedor=?, fecha=?, idAlmacen=? where idIngreso=?";
		return jdbctemplate.update(sql, ingreso.getDocumento(), ingreso.getIdProveedor(), ingreso.getFecha(), ingreso.getIdAlmacen(), ingreso.getIdIngreso());
	}

	@Override
	public int borrar(int idIngreso) {
		String sql = "UPDATE ingreso set estado=0 where idIngreso=?";
		return jdbctemplate.update(sql, idIngreso);
	}
}