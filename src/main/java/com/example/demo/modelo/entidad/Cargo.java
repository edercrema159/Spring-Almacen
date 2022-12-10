package com.example.demo.modelo.entidad;

public class Cargo {
	private int IdCargo;
	private String Descripcion;
	private int Estado;
	//CONSTRUCTOR VACIO//
	public Cargo() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public Cargo(int IdCargo, String Descripcion, int Estado) {
		super();
		this.IdCargo = IdCargo;
		this.Descripcion = Descripcion;
		this.Estado = Estado;
	}
	//METODOS GET AND SET//
	public int getIdCargo() {
		return IdCargo;
	}
	public void setIdCargo(int IdCargo) {
		this.IdCargo = IdCargo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int Estado) {
		this.Estado = Estado;
	}
}

