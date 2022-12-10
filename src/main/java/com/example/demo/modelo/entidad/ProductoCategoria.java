package com.example.demo.modelo.entidad;

public class ProductoCategoria {
	//CAMPOS//
	private int IdProductoCategoria;
	private String Descripcion;
	private int Estado;
	//CONSTRUCTOR VACIO//
	public ProductoCategoria() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS//
	public int getIdProductoCategoria() {
		return IdProductoCategoria;
	}
	public ProductoCategoria(int IdProductoCategoria, String Descripcion, int Estado) {
		super();
		this.IdProductoCategoria = IdProductoCategoria;
		this.Descripcion = Descripcion;
		this.Estado = Estado;
	}
	// METODOS GET AND SET //
	public void setIdProductoCategoria(int IdProductoCategoria) {
		this.IdProductoCategoria = IdProductoCategoria;
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
