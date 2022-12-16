package com.example.demo.modelo.entidad;

public class SalidaDetalle {
	private int IdSalidaDetalle;
	private int IdSalida;
	private int IdProducto;
	private double Cantidad;
	private double Costo;
	private String Producto;
	private String Documento;
	private String Proveedor;
	private String Fecha;
	private String Almacen;

	// CONSTRUCTOR VACIO//
	public SalidaDetalle() {
		super();
	}

	// CONSTRUCTOR CON PARAMETROS//
	public SalidaDetalle(int IdSalidaDetalle, int IdSalida, int IdProducto, double Cantidad, double Costo,
			String Producto, String Documento, String Proveedor, String Fecha, String Almacen) {
		super();
		this.IdSalidaDetalle = IdSalidaDetalle;
		this.IdSalida = IdSalida;
		this.IdProducto = IdProducto;
		this.Cantidad = Cantidad;
		this.Costo = Costo;
		this.Producto = Producto;
		this.Documento = Documento;
		this.Proveedor = Proveedor;
		this.Fecha = Fecha;
		this.Almacen = Almacen;
	}

	// METODOS GET AND SET//
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
