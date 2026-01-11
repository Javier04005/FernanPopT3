package models;

import java.time.LocalDateTime;

public class Productos {
    //Variable de la clase Productos
    private String codigo;
    private String nombre;
    private String marca;
    private double precio;
    private int cantidad;
    //Fecha de alta del producto
    private LocalDateTime fechaAlta;
    private String emailVendedor;
    //Constructor

    public Productos(String codigo, String nombre, String marca, double precio, int cantidad, LocalDateTime fechaAlta,String emailVendedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaAlta = fechaAlta;
        this.emailVendedor = emailVendedor;
    }

    //Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
    }
}
