package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.Login;

public interface ILoginDao {
	public List<Login>listar();
	  public int guardar(Login login);
	  public Login buscarUsuario(Login login);
	  public int actualizar(Login login);
	  public int borrar(int idLogin);
}
