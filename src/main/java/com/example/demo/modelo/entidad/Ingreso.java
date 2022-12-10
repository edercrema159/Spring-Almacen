package com.example.demo.modelo.entidad;

public class Ingreso {
	private int IdIngreso;
	private String Documento;
	private int IdProveedor;
	private String Fecha;
	private int IdAlmacen;
	private int Estado;
	//CONSTRUCTO VACIO//
	public Ingreso() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public Ingreso(int IdIngreso, String Documento, int IdProveedor, String Fecha, int IdAlmacen, int Estado) {
		super();
		this.IdIngreso = IdIngreso;
		this.Documento = Documento;
		this.IdProveedor = IdProveedor;
		this.Fecha = Fecha;
		this.IdAlmacen = IdAlmacen;
		this.Estado = Estado;
	}
	//METODOS GET AND SET//
	public int getIdIngreso() {
		return IdIngreso;
	}
	public void setIdIngreso(int IdIngreso) {
		this.IdIngreso = IdIngreso;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String Documento) {
		this.Documento = Documento;
	}
	public int getIdProveedor() {
		return IdProveedor;
	}
	public void setIdProveedor(int IdProveedor) {
		this.IdProveedor = IdProveedor;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String Fecha) {
		this.Fecha = Fecha;
	}
	public int getIdAlmacen() {
		return IdAlmacen;
	}
	public void setIdAlmacen(int IdAlmacen) {
		this.IdAlmacen = IdAlmacen;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int Estado) {
		this.Estado = Estado;
	}
	
}
