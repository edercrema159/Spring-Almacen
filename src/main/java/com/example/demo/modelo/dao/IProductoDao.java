package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.Producto;

public interface IProductoDao {
  public List<Producto>listar();
  public List<Producto>listarCategoria();
  public int guardar(Producto producto);
  public Producto buscarID(int idProducto);
  public int actualizar(Producto producto);
  public int borrar(int idProducto);
}
