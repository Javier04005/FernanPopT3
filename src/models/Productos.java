package models;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Productos {
    //Variable de la clase Productos
    String codigo;
    String nombre;
    String marca;
    double precio;
    int cantidad;
    //Fecha de alta del producto
    LocalDateTime fechaAlta;
    String emailVendedor;
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

    //Otros Métodos
    //Método para añadir un nuevo producto
    public static void nuevoProducto(Scanner s, Productos productoNuevo, String emailUsuarioLogueado){
        System.out.print("Introduce el código del nuevo producto: ");
        productoNuevo.setCodigo(s.nextLine());
        System.out.print("Introduce el nombre del nuevo producto: ");
        productoNuevo.setNombre(s.nextLine());
        System.out.print("Introduce la marca del nuevo producto: ");
        productoNuevo.setMarca(s.nextLine());
        //Validación del precio para que no se rompa el programa
        System.out.print("Introduce el precio del nuevo producto: ");
        if (s.hasNextDouble()){
            productoNuevo.setPrecio(s.nextDouble());
        }else {
            System.out.println("Precio incorrecto, se le asignará un 0");
            productoNuevo.setPrecio(0);
            s.next();
        }
        s.nextLine();
        //Validación de la cantidad para que no se rompa el programa
        System.out.print("Introduce la cantidad del nuevo producto: ");
        if (s.hasNextInt()){
            productoNuevo.setCantidad(s.nextInt());
        }else {
            System.out.println("Precio incorrecto, se le asignará un 0");
            productoNuevo.setCantidad(0);
            s.next();
        }
        s.nextLine();
        //Guardamos la fecha y el email del vendedor del producto nuevo
        productoNuevo.setFechaAlta(LocalDateTime.now());
        productoNuevo.setEmailVendedor(emailUsuarioLogueado);
        //Menú del producto nuevo
        System.out.println("----Producto registrado----");
        System.out.println();
        System.out.println("\n-----Producto " + productoNuevo.getCodigo() + " -----");
        System.out.println("Código: " + productoNuevo.getCodigo());
        System.out.println("Nombre: " + productoNuevo.getNombre());
        System.out.println("Marca: " + productoNuevo.getMarca());
        System.out.println("Precio: " + productoNuevo.getPrecio() + " euros");
        System.out.println("Cantidad: " + productoNuevo.getCantidad());
        System.out.println("Vendedor: " + productoNuevo.getEmailVendedor());
    }
    //Método para el Menú catálogo de la tienda con los tres artículos
    public static void catalogoProductos(Productos productos1,Productos productos2, Productos productos3){
        boolean stock = false;
        //Validación de stock de cada producto
        System.out.println("\n-----CATÁLOGO DE PRODUCTOS-----");
        if (!productos1.getCodigo().isEmpty()){
            System.out.println("Código: " + productos1.getCodigo());
            System.out.println("Nombre: " + productos1.getNombre());
            System.out.println("Marca: " + productos1.getMarca());
            System.out.println("Precio: " + productos1.getPrecio() + " euros");
            System.out.println("Cantidad: " + productos1.getCantidad());
            System.out.println("Fecha: " + productos1.getFechaAlta().toLocalDate());
            System.out.println("-------------------------------");
            stock = true;
        }else {
            System.out.println("¡¡¡NOS HEMOS QUEDADO SIN STOCK!!!");
            System.out.println("----------------------------------");
        }
        if (!productos2.getCodigo().isEmpty()){
            System.out.println("Código: " + productos2.getCodigo());
            System.out.println("Nombre: " + productos2.getNombre());
            System.out.println("Marca: " + productos2.getMarca());
            System.out.println("Precio: " + productos2.getPrecio() + " euros");
            System.out.println("Cantidad: " + productos2.getCantidad());
            System.out.println("Fecha: " + productos2.getFechaAlta().toLocalDate());
            System.out.println("-------------------------------");
            stock = true;
        }else {
            System.out.println("¡¡¡NOS HEMOS QUEDADO SIN STOCK!!!");
            System.out.println("----------------------------------");
        }
        if (!productos3.getCodigo().isEmpty()){
            System.out.println("Código: " + productos3.getCodigo());
            System.out.println("Nombre: " + productos3.getNombre());
            System.out.println("Marca: " + productos3.getMarca());
            System.out.println("Precio: " + productos3.getPrecio() + " euros");
            System.out.println("Cantidad: " + productos3.getCantidad());
            System.out.println("Fecha: " + productos3.getFechaAlta().toLocalDate());
            System.out.println("-------------------------------");
            stock = true;
        }else {
            System.out.println("¡¡¡NOS HEMOS QUEDADO SIN STOCK!!!");
            System.out.println("----------------------------------");
        }
        //Sí no hay productos mandamos este mensaje
        if (!stock)System.out.println("Hemos quebrado....");
    }
}
