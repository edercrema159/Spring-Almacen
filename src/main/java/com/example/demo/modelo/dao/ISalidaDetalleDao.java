package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.SalidaDetalle;

public interface ISalidaDetalleDao {
	public List<SalidaDetalle>listar();
	  public int guardar(SalidaDetalle salidaDetalle);
	  public SalidaDetalle buscarID(int idSalidaDetalle);
	  public int actualizar(SalidaDetalle salida);
	  public int borrar(int idSalidaDetalle);

}
