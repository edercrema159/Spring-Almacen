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
		String sql = "SELECT sd.*, s.documento, s.fecha, p.razonSocial as proveedor, a.descripcion as almacen, pr.descripcion as producto "+
		"FROM salidadetalle sd "+
		"LEFT JOIN salida s ON s.idSalida = sd.idSalida "+
		"LEFT JOIN proveedor p ON p.idProveedor=s.idProveedor "+
		"LEFT JOIN almacen a ON a.idAlmacen=s.idAlmacen "+
		"LEFT JOIN producto pr ON pr.idProducto=sd.idProducto "+
		"WHERE sd.estado=1 order by sd.idSalida, sd.idSalidaDetalle";
		List<SalidaDetalle> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(SalidaDetalle.class));
		return lista;
	}
	@Override
	public List<SalidaDetalle> listarFiltrado(int idSalida) {
		String sql = "SELECT sd.*, s.documento, s.fecha, p.razonSocial as proveedor, a.descripcion as almacen, pr.descripcion as producto "+
		"FROM salidadetalle sd "+
		"LEFT JOIN salida s ON s.idSalida = sd.idSalida "+
		"LEFT JOIN proveedor p ON p.idProveedor=s.idProveedor "+
		"LEFT JOIN almacen a ON a.idAlmacen=s.idAlmacen "+
		"LEFT JOIN producto pr ON pr.idProducto=sd.idProducto "+
		"WHERE sd.estado=1 and sd.idSalida = ? order by sd.idSalida, sd.idSalidaDetalle";
		List<SalidaDetalle> lista = jdbctemplate.query(sql, new Object[]{idSalida}, BeanPropertyRowMapper.newInstance(SalidaDetalle.class));
		return lista;
	}

	@Override
	public List<SalidaDetalle> listarProducto() {
		String sql = "SELECT *, descripcion as producto FROM producto WHERE estado=1";
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
	public SalidaDetalle buscarIDSalida(int idSalida) {
		String sql = "SELECT * FROM salida where idSalida = ?";
		SalidaDetalle salidadetalle = jdbctemplate.queryForObject(sql, new Object[] {
				idSalida },
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
