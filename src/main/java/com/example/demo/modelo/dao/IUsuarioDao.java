package com.example.demo.modelo.dao;

import java.util.List;

import com.example.demo.modelo.entidad.Usuario;

public interface IUsuarioDao {
	public List<Usuario> listar();

	public List<Usuario> listarCargo();

	public int guardar(Usuario usuario);

	public Usuario buscarID(int idUsuario);

	public int actualizar(Usuario usuario);

	public int borrar(int idUsuario);

}
