package com.example.demo.modelo.entidad;

public class Proveedor {
  private int idProveedor;
  private String razonSocial;
  private String ruc;
  private int estado;
  private String direccion;
  private String departamento;
  private String telefono;
  private String correo;

  public Proveedor() {
  }

  public Proveedor(int idProveedor, String razonSocial, String ruc, int estado, String direccion, String departamento,
      String telefono,
      String correo) {
    this.idProveedor = idProveedor;
    this.razonSocial = razonSocial;
    this.ruc = ruc;
    this.estado = estado;
    this.direccion = direccion;
    this.departamento = departamento;
    this.telefono = telefono;
    this.correo = correo;
  }

  public int getIdProveedor() {
    return idProveedor;
  }

  public void setIdProveedor(int idProveedor) {
    this.idProveedor = idProveedor;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  public String getRuc() {
    return ruc;
  }

  public void setRuc(String ruc) {
    this.ruc = ruc;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }
}
