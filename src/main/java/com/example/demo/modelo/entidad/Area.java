package com.example.demo.modelo.entidad;

public class Area {
	private int IdArea;
	private String Descripcion;
	private int Estado;
	//CONSTRUCTOR VACIO//
	public Area() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public Area(int IdArea, String Descripcion, int Estado) {
		super();
		this.IdArea = IdArea;
		this.Descripcion = Descripcion;
		this.Estado = Estado;
	}
	//METODOS GET AND SET//
	public int getIdArea() {
		return IdArea;
	}
	public void setIdArea(int IdArea) {
		this.IdArea = IdArea;
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
