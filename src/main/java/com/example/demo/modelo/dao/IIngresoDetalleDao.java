package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.IngresoDetalle;

public interface IIngresoDetalleDao {
	public List<IngresoDetalle>listar();
	public List<IngresoDetalle>listarFiltrado(int idIngreso);
	public List<IngresoDetalle>listarProducto();
	  public int guardar(IngresoDetalle ingresodetalle);
	  public IngresoDetalle buscarID(int idIngresoDetalle);
		public IngresoDetalle buscarIDIngreso(int idIngreso);
	  public int actualizar(IngresoDetalle ingresodetalle);
	  public int borrar(int idIngresoDetalle);

}
