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
		String sql = "SELECT id.*, i.documento, i.fecha, p.razonSocial as proveedor, a.descripcion as almacen, pr.descripcion as producto "
				+
				"FROM ingresodetalle id " +
				"LEFT JOIN ingreso i ON i.idIngreso = id.idIngreso " +
				"LEFT JOIN proveedor p ON p.idProveedor=i.idProveedor " +
				"LEFT JOIN almacen a ON a.idAlmacen=i.idAlmacen " +
				"LEFT JOIN producto pr ON pr.idProducto=id.idProducto " +
				"WHERE id.estado=1 order by id.idIngreso, id.idIngresoDetalle";
		List<IngresoDetalle> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(IngresoDetalle.class));
		return lista;
	}

	@Override
	public List<IngresoDetalle> listarFiltrado(int idIngreso) {
		String sql = "SELECT id.*, i.documento, i.fecha, p.razonSocial as proveedor, a.descripcion as almacen, pr.descripcion as producto "
				+
				"FROM ingresodetalle id " +
				"LEFT JOIN ingreso i ON i.idIngreso = id.idIngreso " +
				"LEFT JOIN proveedor p ON p.idProveedor=i.idProveedor " +
				"LEFT JOIN almacen a ON a.idAlmacen=i.idAlmacen " +
				"LEFT JOIN producto pr ON pr.idProducto=id.idProducto " +
				"WHERE id.estado=1 and id.idIngreso=? order by id.idIngreso, id.idIngresoDetalle";
		List<IngresoDetalle> lista = jdbctemplate.query(sql, new Object[] { idIngreso },
				BeanPropertyRowMapper.newInstance(IngresoDetalle.class));
		return lista;
	}

	@Override
	public List<IngresoDetalle> listarProducto() {
		String sql = "SELECT *, descripcion as producto FROM producto WHERE estado=1";
		List<IngresoDetalle> lista = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(IngresoDetalle.class));
		return lista;
	}

	@Override
	public int guardar(IngresoDetalle ingresodetalle) {
		String sql = "INSERT INTO ingresodetalle (idIngreso, idProducto, cantidad, costo) values (?,?,?,?)";
		return jdbctemplate.update(sql, ingresodetalle.getIdIngreso(), ingresodetalle.getIdProducto(),
				ingresodetalle.getCantidad(), ingresodetalle.getCosto());
	}

	@Override
	public IngresoDetalle buscarID(int idIngresoDetalle) {
		String sql = "SELECT * FROM ingresodetalle where idIngresoDetalle = ?";
		IngresoDetalle ingresodetalle = jdbctemplate.queryForObject(sql, new Object[] {
				idIngresoDetalle },
				BeanPropertyRowMapper.newInstance(IngresoDetalle.class));
		return ingresodetalle;
	}

	@Override
	public IngresoDetalle buscarIDIngreso(int idIngreso) {
		String sql = "SELECT * FROM ingreso where idIngreso = ?";
		IngresoDetalle ingresodetalle = jdbctemplate.queryForObject(sql, new Object[] {
				idIngreso },
				BeanPropertyRowMapper.newInstance(IngresoDetalle.class));
		return ingresodetalle;
	}
	@Override
	public int actualizar(IngresoDetalle ingresodetalle) {
		String sql = "UPDATE ingresodetalle set idProducto=?, cantidad=?, costo=? where idIngresoDetalle=?";
		return jdbctemplate.update(sql, ingresodetalle.getIdProducto(),
				ingresodetalle.getCantidad(), ingresodetalle.getCosto(), ingresodetalle.getIdIngresoDetalle());
	}

	@Override
	public int borrar(int idIngresoDetalle) {
		String sql = "UPDATE ingresodetalle set estado=0 where idIngresoDetalle=?";
		return jdbctemplate.update(sql, idIngresoDetalle);
	}
}
