package com.example.demo.modelo.entidad;

public class Salida {
	private int IdSalida;
	private String Documento;
	private String Fecha;
	private int IdAlmacen;
	private int IdProveedor;
	private int Estado;
	//CONSTRUCTOR VACIO//
	public Salida() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public Salida(int IdSalida, String Documento, String Fecha, int IdAlmacen, int IdProveedor, int Estado) {
		super();
		this.IdSalida = IdSalida;
		this.Documento = Documento;
		this.Fecha = Fecha;
		this.IdAlmacen = IdAlmacen;
		this.IdProveedor = IdProveedor;
		this.Estado = Estado;
	}
	//METODOS GET AND SET//
	public int getIdSalida() {
		return IdSalida;
	}
	public void setIdSalida(int IdSalida) {
		this.IdSalida = IdSalida;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String Documento) {
		this.Documento = Documento;
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
	public int getIdProveedor() {
		return IdProveedor;
	}
	public void setIdProveedor(int IdProveedor) {
		this.IdProveedor = IdProveedor;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int Estado) {
		this.Estado = Estado;
	}

}