package com.example.demo.modelo.entidad;

public class IngresoDetalle {
	private int IdIngresoDetalle;
	private int IdIngreso;
	private int IdProducto;
	private double Cantidad;
	private double Costo;
	//CONSTRUCTOR VACIO//
	public IngresoDetalle() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public IngresoDetalle(int IdIngresoDetalle, int IdIngreso, int IdProducto, double Cantidad, double Costo) {
		super();
		this.IdIngresoDetalle = IdIngresoDetalle;
		this.IdIngreso = IdIngreso;
		this.IdProducto = IdProducto;
		this.Cantidad = Cantidad;
		this.Costo = Costo;
	}
	//METODOS GET AND SET//
	public int getIdIngresoDetalle() {
		return IdIngresoDetalle;
	}
	public void setIdIngresoDetalle(int IdIngresoDetalle) {
		this.IdIngresoDetalle = IdIngresoDetalle;
	}
	public int getIdIngreso() {
		return IdIngreso;
	}
	public void setIdIngreso(int IdIngreso) {
		this.IdIngreso = IdIngreso;
	}
	public int getIdProducto() {
		return IdProducto;
	}
	public void setIdProducto(int IdProducto) {
		this.IdProducto = IdProducto;
	}
	public double getCantidad() {
		return Cantidad;
	}
	public void setCantidad(double Cantidad) {
		this.Cantidad = Cantidad;
	}
	public double getCosto() {
		return Costo;
	}
	public void setCosto(double Costo) {
		this.Costo = Costo;
	}
}

