package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.Salida;

public interface ISalidaDao {
	public List<Salida>listar();
	  public int guardar(Salida salida);
	  public Salida buscarID(int idSalida);
	  public int actualizar(Salida salida);
	  public int borrar(int idSalida);

}
