package com.example.demo.modelo.entidad;

public class Login {
	private int IdLogin;
	private int IdUsuario;
	private String Usuario;
	private String Contraseña;
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	private int Estado;
	//CONSTRUCTOR VACIO//
	public Login() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public Login(int idLogin, int idUsuario, int estado, String usuario, String contraseña) {
		super();
		IdLogin = idLogin;
		IdUsuario = idUsuario;
		Estado = estado;
		Usuario = usuario;
		Contraseña = contraseña;
	}
	//METODOS GET AND SET//
	public int getIdLogin() {
		return IdLogin;
	}
	public void setIdLogin(int idLogin) {
		IdLogin = idLogin;
	}
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}

}
