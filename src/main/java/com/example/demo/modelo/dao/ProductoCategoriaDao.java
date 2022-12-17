package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.ProductoCategoria;

@Repository
public class ProductoCategoriaDao implements IProductoCategoriaDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<ProductoCategoria> listar() {
		String sql = "SELECT * FROM productocategoria WHERE estado=1";
		List<ProductoCategoria> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(ProductoCategoria.class));
		return lista;
	}
	
	@Override
	public int guardar(ProductoCategoria productocategoria) {
		String sql = "INSERT INTO productocategoria (descripcion) values (?)";
		return jdbctemplate.update(sql, productocategoria.getDescripcion());
	}

	@Override
	public ProductoCategoria buscarID(int idProductoCategoria) {
		String sql = "SELECT * FROM productocategoria where idProductoCategoria = ?";
		ProductoCategoria productocategoria = jdbctemplate.queryForObject(sql, new Object[] {
				idProductoCategoria },
				BeanPropertyRowMapper.newInstance(ProductoCategoria.class));
		return productocategoria;
	}

	@Override
	public int actualizar(ProductoCategoria productocategoria) {
		String sql = "UPDATE productocategoria set descripcion=? WHERE idProductoCategoria = ?";
		return jdbctemplate.update(sql, productocategoria.getDescripcion(), productocategoria.getIdProductoCategoria());
	}

	@Override
	public int borrar(int idProductoCategoria) {
		String sql = "UPDATE productocategoria set estado=0 where idProductoCategoria=?";
		return jdbctemplate.update(sql, idProductoCategoria);
	}
}
