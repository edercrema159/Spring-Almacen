package com.example.demo.modelo.entidad;

public class SalidaDetalle {
	private int IdSalidaDetalle;
	private int IdSalida;
	private int IdProducto;
	private double Cantidad;
	private double Costo;
	//CONSTRUCTOR VACIO//
	public SalidaDetalle() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public SalidaDetalle(int IdSalidaDetalle, int IdSalida, int IdProducto, double Cantidad, double Costo) {
		super();
		this.IdSalidaDetalle = IdSalidaDetalle;
		this.IdSalida = IdSalida;
		this.IdProducto = IdProducto;
		this.Cantidad = Cantidad;
		this.Costo = Costo;
	}
	//METODOS GET AND SET//
	public int getIdSalidaDetalle() {
		return IdSalidaDetalle;
	}
	public void setIdSalidaDetalle(int IdSalidaDetalle) {
		this.IdSalidaDetalle = IdSalidaDetalle;
	}
	public int getIdSalida() {
		return IdSalida;
	}
	public void setIdSalida(int IdSalida) {
		this.IdSalida = IdSalida;
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
