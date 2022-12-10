package com.example.demo.modelo.entidad;

public class Almacen {
	private int IdAlmacen;
	private String Descripcion;
	private int IdArea;
	private String Area;
	private int Estado;
	//CONSTRUCTOR VACIO//
	public Almacen() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public Almacen(int IdAlmacen, String Descripcion, int IdArea, int Estado, String Area) {
		super();
		this.IdAlmacen = IdAlmacen;
		this.Descripcion = Descripcion;
		this.IdArea = IdArea;
		this.Estado = Estado;
		this.Area = Area;
	}
	//METODOS GET AND SET//
	public int getIdAlmacen() {
		return IdAlmacen;
	}
	public void setIdAlmacen(int IdAlmacen) {
		this.IdAlmacen = IdAlmacen;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String Area) {
		this.Area = Area;
	}
	public int getIdArea() {
		return IdArea;
	}
	public void setIdArea(int IdArea) {
		this.IdArea = IdArea;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int Estado) {
		this.Estado = Estado;
	}
}