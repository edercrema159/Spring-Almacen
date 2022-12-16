package com.example.demo.modelo.entidad;

public class IngresoDetalle {
	private int IdIngresoDetalle;
	private int IdIngreso;
	private int IdProducto;
	private double Cantidad;
	private double Costo;
	private String Producto;
	private String Documento;
	private String Proveedor;
	private String Fecha;
	private String Almacen;
	
	//CONSTRUCTOR VACIO//
	public IngresoDetalle() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public IngresoDetalle(int IdIngresoDetalle, int IdIngreso, int IdProducto, double Cantidad, double Costo, 
	String Producto, String Documento, String Proveedor, String Fecha, String Almacen) {
		super();
		this.IdIngresoDetalle = IdIngresoDetalle;
		this.IdIngreso = IdIngreso;
		this.IdProducto = IdProducto;
		this.Cantidad = Cantidad;
		this.Costo = Costo;
		this.Producto = Producto;
		this.Documento = Documento;
		this.Proveedor = Proveedor;
		this.Fecha = Fecha;
		this.Almacen = Almacen;
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
	public String getProducto() {
		return Producto;
	}
	public void setProducto(String producto) {
		Producto = producto;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String documento) {
		Documento = documento;
	}
	public String getProveedor() {
		return Proveedor;
	}
	public void setProveedor(String proveedor) {
		Proveedor = proveedor;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getAlmacen() {
		return Almacen;
	}
	public void setAlmacen(String almacen) {
		Almacen = almacen;
	}
}

