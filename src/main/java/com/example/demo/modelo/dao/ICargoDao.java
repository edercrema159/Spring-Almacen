package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.Cargo;

public interface ICargoDao {
	public List<Cargo>listar();
	  public int guardar(Cargo cargo);
	  public Cargo buscarID(int idCargo);
	  public int actualizar(Cargo cargo);
	  public int borrar(int idCargo);

}
