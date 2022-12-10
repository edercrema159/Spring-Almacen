package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Producto;

@Repository
public class ProductoDao implements IProductoDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Producto> listar() {
		String sql = "SELECT p.*, pc.descripcion as categoria FROM producto p LEFT JOIN productocategoria pc on pc.idProductoCategoria=p.idProductoCategoria WHERE p.estado=1";
		List<Producto> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Producto.class));
		return lista;
	}

	public List<Producto> listarCategoria() {
		String sql = "SELECT * FROM productocategoria where estado=1";
		List<Producto> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Producto.class));
		return lista;
	}

	@Override
	public int guardar(Producto producto) {
		String sql = "INSERT INTO producto (descripcion, idProductoCategoria, cantidad) values (?,?,?)";
		return jdbctemplate.update(sql, producto.getDescripcion(), producto.getIdProductoCategoria(), producto.getCantidad());
	}

	@Override
	public Producto buscarID(int idProducto) {
		String sql = "SELECT * FROM producto where idProducto = ?";
		Producto producto = jdbctemplate.queryForObject(sql, new Object[] {
				idProducto },
				BeanPropertyRowMapper.newInstance(Producto.class));
		return producto;
	}

	@Override
	public int actualizar(Producto producto) {
		String sql = "UPDATE producto set descripcion=?, idProductoCategoria=? WHERE idProducto = ?";
		return jdbctemplate.update(sql, producto.getDescripcion(), producto.getIdProductoCategoria(),
				producto.getIdProducto());
	}

	@Override
	public int borrar(int idProducto) {
		String sql = "UPDATE producto set estado=0 where idProducto=?";
		return jdbctemplate.update(sql, idProducto);
	}
}
