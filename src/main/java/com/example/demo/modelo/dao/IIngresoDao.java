package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.Ingreso;

public interface IIngresoDao {
	public List<Ingreso>listar();
	  public int guardar(Ingreso ingreso);
	  public Ingreso buscarID(int idIngreso);
	  public int actualizar(Ingreso ingreso);
	  public int borrar(int idIngreso);

}
