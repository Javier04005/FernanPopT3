package models;

public class Usuarios {
    //Variables
    public String nombre;
    private String clave;
    private String email;

    //Constructor
    public Usuarios(String nombre, String clave, String email) {
        this.nombre = nombre;
        this.clave = clave;
        this.email = email;
    }
    //Getters y Setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
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

    //Otros métodos
    //Método de validación de Login
    public boolean verificarCredenciales(String emailTeclado, String claveTeclado) {
        // Compara si el email y la clave coinciden con los datos almacenados
        return this.email.equals(emailTeclado) && this.clave.equals(claveTeclado);
    }
    public static void mostrarPerfil(Usuarios usuario) {
        System.out.println("\n--- Perfil de Usuario ---");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("-------------------------\n");
    }
}

