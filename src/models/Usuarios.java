package models;

import java.time.LocalDateTime;

public class Usuarios {
    //Variable de la clase Usuarios
    private String nombre;
    private String clave;
    private String email;

    //Variables de las ventas y las compras
    private double precioFinal;
    private String puntuacion;
    private String comentario;
    private LocalDateTime fecha;

    //Constructor principal
    public Usuarios(String nombre, String clave, String email) {
        //Estos tres datos son los principales que pide el Main
        this.nombre = nombre;
        this.clave = clave;
        this.email = email;
        //Valores por defecto
        this.precioFinal = 0;
        this.puntuacion = "Sin calificar";
        this.comentario = "Sin comentarios";
        this.fecha = null;
    }

    //Constructor secundario
    public Usuarios(double precioFinal, String puntuacion, String comentario, LocalDateTime fecha) {
        this.precioFinal = precioFinal;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    //Otros métodos
    //Método de validación de Login
    public boolean verificarCredenciales(String emailTeclado, String claveTeclado) {
        // Compara si el email y la clave coinciden con los datos almacenados
        return this.email.equals(emailTeclado) && this.clave.equals(claveTeclado);
    }
}

