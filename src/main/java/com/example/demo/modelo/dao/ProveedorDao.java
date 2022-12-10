package com.example.demo.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Proveedor;

@Repository
public class ProveedorDao implements IProveedorDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Proveedor> listar() {
		String sql = "SELECT * FROM proveedor WHERE estado=1";
		List<Proveedor> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Proveedor.class));
		return lista;
	}

	@Override
	public int guardar(Proveedor proveedor) {
		String sql = "INSERT INTO proveedor (razonSocial, ruc, direccion, departamento, telefono, correo) values (?,?,?,?,?,?)";
		return jdbctemplate.update(sql, proveedor.getRazonSocial(), proveedor.getRuc(),
				proveedor.getDireccion(),
				proveedor.getDepartamento(), proveedor.getTelefono(), proveedor.getCorreo());
	}

	@Override
	public Proveedor buscarID(int idProveedor) {
		String sql = "SELECT * FROM proveedor where idProveedor = ?";
		Proveedor proveedor = jdbctemplate.queryForObject(sql, new Object[] {
				idProveedor },
				BeanPropertyRowMapper.newInstance(Proveedor.class));
		return proveedor;
	}

	@Override
	public int actualizar(Proveedor proveedor) {
		String sql = "UPDATE proveedor set razonSocial=?, ruc=?, direccion=?, departamento=?, telefono=?, correo=? WHERE idProveedor = ?";
		return jdbctemplate.update(sql, proveedor.getRazonSocial(), proveedor.getRuc(), proveedor.getDireccion(),
				proveedor.getDepartamento(), proveedor.getTelefono(), proveedor.getCorreo(), proveedor.getIdProveedor());
	}

	@Override
	public int borrar(int idProveedor) {
		String sql = "UPDATE proveedor set estado=0 where idProveedor=?";
		return jdbctemplate.update(sql, idProveedor);
	}
}
