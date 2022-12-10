package com.example.demo.modelo.entidad;

public class Usuario {
	private int IdUsuario;
	private String Usuario;
	private String Contraseña;
	private int IdCargo;
	private String Nombres;
	private String Apellidos;
	private String Documento;
	private int Estado;
	private String Telefono;
	private String Correo;
	//CONSTRUCTOR VACIO
	public Usuario() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public Usuario(int IdUsuario, String Usuario, String Contraseña, int IdCargo, String Nombres, String Apellidos,
			String Documento, int Estado, String Telefono, String Correo) {
		super();
		this.IdUsuario = IdUsuario;
		this.Usuario = Usuario;
		this.Contraseña = Contraseña;
		this.IdCargo = IdCargo;
		this.Nombres = Nombres;
		this.Apellidos = Apellidos;
		this.Documento = Documento;
		this.Estado = Estado;
		this.Telefono = Telefono;
		this.Correo = Correo;
	}
	//METODOS GET AND SET//
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int IdUsuario) {
		this.IdUsuario = IdUsuario;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String Usuario) {
		this.Usuario = Usuario;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String Contraseña) {
		this.Contraseña = Contraseña;
	}
	public int getIdCargo() {
		return IdCargo;
	}
	public void setIdCargo(int IdCargo) {
		this.IdCargo = IdCargo;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String Nombres) {
		this.Nombres = Nombres;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String Apellidos) {
		this.Apellidos = Apellidos;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String Documento) {
		this.Documento = Documento;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int Estado) {
		this.Estado = Estado;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String Correo) {
		this.Correo = Correo;
	}
}
