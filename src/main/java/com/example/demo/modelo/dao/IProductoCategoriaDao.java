package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.ProductoCategoria;

public interface IProductoCategoriaDao {
	public List<ProductoCategoria>listar();
	  public int guardar(ProductoCategoria productocategoria);
	  public ProductoCategoria buscarID(int idProductoCategoria);
	  public int actualizar(ProductoCategoria productocategoria);
	  public int borrar(int idProductoCategoria);

}
