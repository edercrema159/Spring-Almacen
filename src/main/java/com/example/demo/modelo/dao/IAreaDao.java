package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.Area;

public interface IAreaDao {
	public List<Area>listar();
	  public int guardar(Area area);
	  public Area buscarID(int idArea);
	  public int actualizar(Area area);
	  public int borrar(int idArea);

}
