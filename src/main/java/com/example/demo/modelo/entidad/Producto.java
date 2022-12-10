package com.example.demo.modelo.entidad;

public class Producto {
	private int idProducto;
	private String descripcion;
	private int idProductoCategoria;
	private int estado;
	// private String proveedor; La columna proveedor no debe ir en la BDs
	private Number cantidad;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdProductoCategoria() {
		return idProductoCategoria;
	}

	public void setIdProductoCategoria(int idProductoCategoria) {
		this.idProductoCategoria = idProductoCategoria;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Number getCantidad() {
		return cantidad;
	}

	public void setCantidad(Number cantidad) {
		this.cantidad = cantidad;
	}

	public Producto() {
	}

	public Producto(int idProducto, String descripcion, int idProductoCategoria, int estado, Number cantidad) {
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.idProductoCategoria = idProductoCategoria;
		this.estado = estado;
		this.cantidad = cantidad;
	}
}
