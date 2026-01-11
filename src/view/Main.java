package view;

import models.Productos;
import models.Usuarios;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //OBJETOS
        //Usuario Admin
        Usuarios usuario1 = new Usuarios("admin", "1234", "admin@gmail.com");
        //Datos de venta del usuario Admin
        usuario1.setPrecioFinal(500.50);
        usuario1.setPuntuacion("⭐⭐⭐⭐⭐");
        usuario1.setComentario("Todo perfecto, envío rápido.");
        usuario1.setFecha(LocalDateTime.now().minusDays(3));
        //Usuario Javier
        Usuarios usuario2 = new Usuarios("Javier", "1234", "javier@gmail.com");
        //Datos de compra del usuario Javier
        usuario2.setPrecioFinal(120.00);
        usuario2.setPuntuacion("⭐⭐⭐⭐");
        usuario2.setComentario("El producto estaba bien pero la caja rota.");
        usuario2.setFecha(LocalDateTime.now().minusDays(1));

        //Productos
        Productos producto1 = new Productos("P001", "Laptop Gamer", "ASUS", 1000, 5, LocalDateTime.now().minusDays(5), "admin@gmail.com");
        Productos producto2 = new Productos("P002", "Ratón Inalámbrico", "HP", 30, 10, LocalDateTime.now().minusDays(1), "javier@gmail.com");
        Productos productoNuevo = new Productos("", "", "", 0, 0, null, "null");
        Usuarios usuarioActual = null;
        //Variables
        int op;
        System.out.println("""
                 ________                                                 _______            _______ \s
                /        |                                               /       \\          /       \\\s
                $$$$$$$$/______    ______   _______    ______   _______  $$$$$$$  | ______  $$$$$$$  |
                $$ |__  /      \\  /      \\ /       \\  /      \\ /       \\ $$ |__$$ |/      \\ $$ |__$$ |
                $$    |/$$$$$$  |/$$$$$$  |$$$$$$$  | $$$$$$  |$$$$$$$  |$$    $$//$$$$$$  |$$    $$/\s
                $$$$$/ $$    $$ |$$ |  $$/ $$ |  $$ | /    $$ |$$ |  $$ |$$$$$$$/ $$ |  $$ |$$$$$$$/ \s
                $$ |   $$$$$$$$/ $$ |      $$ |  $$ |/$$$$$$$ |$$ |  $$ |$$ |     $$ \\__$$ |$$ |     \s
                $$ |   $$       |$$ |      $$ |  $$ |$$    $$ |$$ |  $$ |$$ |     $$    $$/ $$ |     \s
                $$/     $$$$$$$/ $$/       $$/   $$/  $$$$$$$/ $$/   $$/ $$/       $$$$$$/  $$/      \s
                
                
                """);
        while (usuarioActual == null) {
            System.out.print("""
                    ==============================================
                    Bienvenido al programa de FernanPop
                    Compra y vende tus artículos en nuestro centro
                    ==============================================\s""");
            System.out.print("\nPulsa enter para continuar: ");
            s.nextLine();
            System.out.print("Introduce tu email: ");
            String emailTeclado = s.nextLine();
            System.out.print("Introduce tu clave de usuario: ");
            String claveTeclado = s.nextLine();
            //Validación de credenciales
            if (usuario1.verificarCredenciales(emailTeclado, claveTeclado)) {
                usuarioActual = usuario1;
                System.out.println("\nBienvenido " + usuarioActual.getNombre() + "!");
            } else if (usuario2.verificarCredenciales(emailTeclado, claveTeclado)) {
                usuarioActual = usuario2;
                System.out.println("\nBienvenido " + usuarioActual.getNombre() + "!");
            } else System.out.println("\nCredenciales incorrectas. Inténtalo de nuevo.");
        }
        do {
            //MENU PRINCIPAL
            System.out.print("""
                    *******************************
                            Menú de usuario
                    1. Mostrar mi perfil de usuario
                    2. Cambiar mis datos personales
                    3. Ver mis productos en venta
                    4. Cerrar la venta de un producto o quitarlo de la venta
                    5. Poner a la venta un nuevo producto
                    6. Ver todos los productos en venta de la aplicación
                    7. Ver mi histórico de ventas
                    8. Ver mi histórico de compras
                    9. Salir
                    Introduzca la opción:\s""");
            //Validamos la entrada de datos para que solo acepte números
            if (s.hasNextInt()) {
                op = s.nextInt(); // Si es número, lo leemos
            } else {
                op = -1; // Si son letras o basura, ponemos opción inválida
            }
            s.nextLine();
            if (op < 0 || op > 9) System.out.println("Opción incorrecta");
            else {
                switch (op) {
                    case 1: //Mostrar mi perfil de usuario
                        //Muestro el método creado en la clase Usuarios
                        mostrarPerfil(usuarioActual);
                        break;
                    case 2: //Cambiar mis datos personales
                        int op2;
                        do {
                            System.out.println("Tu usuario actual es " + usuarioActual.getNombre());
                            System.out.print("""
                                    =========================================
                                    CAMBIAR MIS DATOS PERSONALES
                                    1. Cambiar Nombre
                                    2. Cambiar clave
                                    3. Salir
                                    Introduzca una opción:\s""");
                            //Validamos la entrada de datos para que solo acepte números
                            if (s.hasNextInt()) {
                                op2 = s.nextInt();
                            } else {
                                op2 = -1;
                            }
                            s.nextLine(); // Limpiar el buffer
                            if (op2 < 1 || op2 > 3) System.out.println("Opción incorrecta");
                            else {
                                switch (op2) {
                                    case 1:
                                        System.out.print("Introduce el nuevo nombre: ");
                                        String nuevoNombre = s.nextLine();
                                        usuarioActual.setNombre(nuevoNombre);
                                        System.out.println("Tu nombre ha cambiado a " + usuarioActual.getNombre());
                                        break;
                                    case 2:
                                        System.out.print("Introduce la nueva clave: ");
                                        String nuevaClave = s.nextLine();
                                        usuarioActual.setClave(nuevaClave);
                                        System.out.println("Clave actualizada correctamente.");
                                        break;
                                    case 3:
                                        System.out.println("Volviendo al menú principal del usuario " + usuarioActual.getNombre());
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            }
                        } while (op2 != 3);
                        break;
                    case 3: //Ver mis productos en venta
                        boolean tengoAlgo = false;
                        System.out.println("\n=== MIS PRODUCTOS EN VENTA (" + usuarioActual.getNombre() + ") ===");

                        // Miramos el Producto 1
                        if (producto1.getEmailVendedor().equals(usuarioActual.getEmail())) {
                            System.out.println("- " + producto1.getNombre() + " (" + producto1.getPrecio() + "€) - Código: " + producto1.getCodigo());
                            tengoAlgo = true;
                        }

                        // Miramos el Producto 2
                        if (producto2.getEmailVendedor().equals(usuarioActual.getEmail())) {
                            System.out.println("- " + producto2.getNombre() + " (" + producto2.getPrecio() + "€) - Código: " + producto2.getCodigo());
                            tengoAlgo = true;
                        }

                        // Miramos el Producto Nuevo (si existe)
                        if (!productoNuevo.getCodigo().isEmpty() && productoNuevo.getEmailVendedor().equals(usuarioActual.getEmail())) {
                            System.out.println("- " + productoNuevo.getNombre() + " (" + productoNuevo.getPrecio() + "€) - Código: " + productoNuevo.getCodigo());
                            tengoAlgo = true;
                        }
                        if (!tengoAlgo) System.out.println("No tienes productos en venta.");
                        break;
                    case 4: //Cerrar la venta de un producto o quitarlo de la venta
                        System.out.println("\n=== ELIMINAR PRODUCTOS ===");
                        System.out.println("Tus productos disponibles:");
                        //Variable que válida si hay productos para borrar o no
                        boolean hayParaBorrar = false;

                        if (producto1.getEmailVendedor().equals(usuarioActual.getEmail()) && !producto1.getCodigo().isEmpty()) {
                            System.out.println("- " + producto1.getCodigo() + " (" + producto1.getNombre() + ")");
                            hayParaBorrar = true;
                        }
                        if (producto2.getEmailVendedor().equals(usuarioActual.getEmail()) && !producto2.getCodigo().isEmpty()) {
                            System.out.println("- " + producto2.getCodigo() + " (" + producto2.getNombre() + ")");
                            hayParaBorrar = true;
                        }
                        //La validación de getEmailVendedor sirve para comparar el vendedor con el nombre del usuario
                        if (!productoNuevo.getCodigo().isEmpty() && productoNuevo.getEmailVendedor().equals(usuarioActual.getEmail())) {
                            System.out.println("- " + productoNuevo.getCodigo() + " (" + productoNuevo.getNombre() + ")");
                            hayParaBorrar = true;
                        }

                        if (!hayParaBorrar) {
                            System.out.println("No tienes productos para borrar.");
                        } else {
                            System.out.print("Introduce el código del producto para eliminarlo: ");
                            //Variable que nos ayuda a encontrar el producto mediante su código
                            String codigoBorrar = s.nextLine();
                            boolean borrado = false;
                            //Validación y chequeo del borrado del producto dependiendo del producto que se haya elegido por código
                            if (producto1.getCodigo().equals(codigoBorrar) && producto1.getEmailVendedor().equals(usuarioActual.getEmail())) {
                                producto1.setCodigo(""); // Al dejar el código vacío, el sistema lo ignora
                                producto1.setNombre("Eliminado");
                                producto1.setPrecio(0);
                                producto1.setCantidad(0);
                                producto1.setEmailVendedor(""); // Le quitamos el dueño
                                borrado = true;
                            } else if (producto2.getCodigo().equals(codigoBorrar) && producto2.getEmailVendedor().equals(usuarioActual.getEmail())) {
                                producto2.setCodigo("");
                                producto2.setNombre("Eliminado");
                                producto2.setPrecio(0);
                                producto2.setCantidad(0);
                                producto2.setEmailVendedor("");
                                borrado = true;
                            } else if (productoNuevo.getCodigo().equals(codigoBorrar) && productoNuevo.getEmailVendedor().equals(usuarioActual.getEmail())) {
                                productoNuevo.setCodigo("");
                                productoNuevo.setNombre("");
                                productoNuevo.setPrecio(0);
                                productoNuevo.setCantidad(0);
                                productoNuevo.setEmailVendedor("");
                                borrado = true;
                            }
                            if (borrado) {
                                System.out.println("El producto ha sido eliminado correctamente");
                            } else {
                                System.out.println("""
                                        ======ERROR======
                                        Código no encontrado o no eres el dueño de ese producto""");
                            }
                        }
                        break;
                    case 5: //Poner a la venta un nuevo producto
                        //Le pasamos el scanner, el producto vacío y el dueño asociado
                        nuevoProducto(s, productoNuevo, usuarioActual.getEmail());
                        break;
                    case 6: //Ver todos los productos en venta de la aplicación
                        catalogoProductos(producto1, producto2, productoNuevo);
                        break;
                    case 7: //Ver mi histórico de ventas
                        //Muestro el método creado en la clase Usuarios
                        historicoVenta(usuarioActual);
                        break;
                    case 8: //Ver mi histórico de compras
                        //Muestro el método creado en la clase Usuarios
                        historicoCompra(usuarioActual);
                        break;
                    case 9: //Salir
                        System.out.println("APAGANDO EL PROGRAMA...");
                        break;
                    default:
                        System.out.println("No hay más opciones en el menú");
                }
                if (op != 9) {
                    System.out.print("Pulsa una tecla para continuar...");
                    s.nextLine();
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
                }
            }
        } while (op != 9);
    }
    //MÉTODOS AUXILIARES DEL MAIN
    //Menú Perfil del usuario
    public static void mostrarPerfil(Usuarios usuario) {
        System.out.println("\n--- Perfil de Usuario ---");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("-------------------------\n");
    }

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

    //Método historial de venta del usuario
    public static void historicoVenta(Usuarios usuario) {
        if (usuario.getPrecioFinal() > 0) {
            System.out.println("\n-----Historial de ventas------");
            System.out.println("Precio final: " + usuario.getPrecioFinal());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Puntuación: " + usuario.getPuntuacion());
            System.out.println("Comentario: " + usuario.getComentario());
            if (usuario.getFecha() != null) {
                System.out.println("Fecha: " + usuario.getFecha().toLocalDate());
            }
        } else System.out.println("No hay ventas registradas actualmente");
        System.out.println("------------------------------------------");
    }

    //Método historial de compra del usuario
    public static void historicoCompra(Usuarios usuario) {
        if (usuario.getPrecioFinal() > 0) {
            System.out.println("\n-----Historial de compras------");
            System.out.println("Gasto total: " + usuario.getPrecioFinal() + " euros");
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Puntuación: " + usuario.getPuntuacion());
            System.out.println("Comentario: " + usuario.getComentario());
            if (usuario.getFecha() != null) {
                System.out.println("Fecha: " + usuario.getFecha().toLocalDate());
            }
        } else System.out.println("No hay ventas registradas actualmente");
        System.out.println("------------------------------------------");
    }
}


