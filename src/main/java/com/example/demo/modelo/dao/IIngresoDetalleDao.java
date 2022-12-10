package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.IngresoDetalle;

public interface IIngresoDetalleDao {
	public List<IngresoDetalle>listar();
	  public int guardar(IngresoDetalle ingresodetalle);
	  public IngresoDetalle buscarID(int idIngresoDetalle);
	  public int actualizar(IngresoDetalle ingresodetalle);
	  public int borrar(int idIngresoDetalle);

}
