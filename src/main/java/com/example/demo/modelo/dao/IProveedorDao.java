package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.Proveedor;

public interface IProveedorDao {
  public List<Proveedor>listar();
  public int guardar(Proveedor proveedor);
  public Proveedor buscarID(int idProveedor);
  public int actualizar(Proveedor proveedor);
  public int borrar(int idProveedor);
}
