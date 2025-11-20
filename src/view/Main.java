package view;

import models.Usuarios;

import java.util.Scanner;

import static models.Usuarios.mostrarPerfil;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Objetos
        Usuarios usuario1 = new Usuarios("admin", "1234", "admin@gmail.com");
        Usuarios usuario2 = new Usuarios("Javier", "1234", "javier@gmail.com");
        Usuarios usuarioActual = null;
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
        while (usuarioActual == null){
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
            if (usuario1.verificarCredenciales(emailTeclado, claveTeclado)) {
                usuarioActual = usuario1;
                System.out.println("\nBienvenido " + usuarioActual.getNombre() + "!");
            } else if (usuario2.verificarCredenciales(emailTeclado, claveTeclado)) {
                usuarioActual = usuario2;
                System.out.println("\nBienvenido " + usuarioActual.getNombre() + "!");
            } else System.out.println("\nCredenciales incorrectas. Inténtalo de nuevo.");
        }
        do {
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
            op = Integer.parseInt(s.nextLine());
            if (op < 0 || op > 9) System.out.println("Opción incorrecta");
            else {
                switch (op) {
                    case 1: //Mostrar mi perfil de usuario
                        mostrarPerfil(usuarioActual);
                        break;
                    case 2: //Cambiar mis datos personales
                        int op2;
                        do {
                            System.out.println("Tu usuario actual es " + usuarioActual.getNombre());
                            System.out.print("""
                                    =========================================
                                    CAMBIAR MIS DATOS PERSONALES
                                    1.Cambiar Nombre
                                    2.Cambiar clave
                                    Introduzca una opción:\s""");
                            op2 = Integer.parseInt(s.nextLine());
                            if (op2 < 1 || op2 > 2) System.out.println("Opción incorrecta");
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
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            }
                        } while (op2 < 1 || op2 > 2);
                        break;
                    case 3: //Ver mis productos en venta
                        break;
                    case 4: //Cerrar la venta de un producto o quitarlo de la venta
                        break;
                    case 5: //Poner a la venta un nuevo producto
                        break;
                    case 6: //Ver todos los productos en venta de la aplicación
                        break;
                    case 7: //Ver mi histórico de ventas
                        break;
                    case 8: //Ver mi histórico de compras
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
}
