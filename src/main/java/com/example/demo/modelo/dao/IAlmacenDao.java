package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.Almacen;

public interface IAlmacenDao {
	public List<Almacen> listar();
	public List<Almacen> listarArea();

	public int guardar(Almacen almacen);

	public Almacen buscarID(int idAlmacen);

	public int actualizar(Almacen almacen);

	public int borrar(int idAlmacen);

}
