package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Equipo equipo = null;

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    equipo = crearEquipo(scanner);
                    break;
                case 2:
                    agregarJugador(scanner, equipo);
                    break;
                case 3:
                    agregarPortero(scanner, equipo);
                    break;
                case 4:
                    eliminarJugador(scanner, equipo);
                    break;
                case 5:
                    eliminarPortero(scanner, equipo);
                    break;
                case 6:
                    mostrarDetallesEquipo(equipo);
                    break;
                case 7:
                    mostrarJugadoresMenoresEdad(equipo);
                    break;
                case 8:
                    mostrarJugadoresTitulares(equipo);
                    break;
                case 9:
                    grabarEquipoCSV(scanner, equipo);
                    break;
                case 10:
                    equipo=leerEquipoCSV(scanner);
                    break;
                case 11:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Introduce un número del 1 al 11.");
                    break;
            }
            System.out.println();
        } while (opcion != 11);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Crear equipo");
        System.out.println("2. Agregar jugador");
        System.out.println("3. Agregar portero");
        System.out.println("4. Eliminar jugador");
        System.out.println("5. Eliminar portero");
        System.out.println("6. Mostrar detalles del equipo");
        System.out.println("7. Mostrar jugadores menores de edad");
        System.out.println("8. Mostrar jugadores titulares");
        System.out.println("9. Grabar equipo en fichero CSV");
        System.out.println("10. Leer equipo desde fichero CSV");
        System.out.println("11. Salir");
        System.out.println("Ingrese el número de opción:");
    }

    public static Equipo crearEquipo(Scanner scanner) {
        System.out.println("Ingrese el nombre del equipo:");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa la puntuacion del equipo:");
        int puntuacion=Integer.valueOf(scanner.nextLine());
        System.out.println("Ingrese la ciudad del equipo:");
        String ciudad = scanner.nextLine();
        System.out.println("Ingrese el email de contacto del equipo:");
        String email = scanner.nextLine();


        return new Equipo(nombre,puntuacion, ciudad, email);
    }

    public static void agregarJugador(Scanner scanner, Equipo equipo) {
        if (equipo == null) {
            System.out.println("Crea un equipo antes de agregar jugadores.");
            return;
        }

        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese los apellidos del jugador:");
        String apellidos = scanner.nextLine();
        System.out.println("Ingrese el DNI del jugador:");
        String dni = scanner.nextLine();
        System.out.println("Ingrese el email del jugador:");
        String email = scanner.nextLine();
        System.out.println("Ingrese el teléfono del jugador:");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese el año de nacimiento del jugador:");
        int nacimiento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.println("Ingrese el dorsal del jugador:");
        int dorsal = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.println("Ingrese la cantidad de goles del jugador:");
        int goles = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        Jugador jugador = new Jugador(nombre, apellidos, dni, email, telefono, nacimiento, dorsal, goles);
        boolean agregado = equipo.addJugador(jugador);
        if (agregado) {
            System.out.println("Jugador agregado correctamente al equipo.");
        } else {
            System.out.println("El jugador ya está presente en el equipo.");
        }
    }

    public static void agregarPortero(Scanner scanner, Equipo equipo) {
        if (equipo == null) {
            System.out.println("Crea un equipo antes de agregar porteros.");
            return;
        }

        System.out.println("Ingrese el nombre del portero:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese los apellidos del portero:");
        String apellidos = scanner.nextLine();
        System.out.println("Ingrese el DNI del portero:");
        String dni = scanner.nextLine();
        System.out.println("Ingrese el email del portero:");
        String email = scanner.nextLine();
        System.out.println("Ingrese el teléfono del portero:");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese el año de nacimiento del portero:");
        int nacimiento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.println("Ingrese el dorsal del portero:");
        int dorsal = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.println("Ingrese la cantidad de goles del portero:");
        int goles = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        System.out.println("Ingrese la cantidad de goles encajados del portero:");
        int golesEncajados = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        Portero portero = new Portero(nombre, apellidos, dni, email, telefono, nacimiento, dorsal, goles, golesEncajados);
        boolean agregado = equipo.addPortero(portero);
        if (agregado) {
            System.out.println("Portero agregado correctamente al equipo.");
        } else {
            System.out.println("No se pudo agregar el portero al equipo.");
        }
    }

    public static void eliminarJugador(Scanner scanner, Equipo equipo) {
        if (equipo == null) {
            System.out.println("Crea un equipo antes de eliminar jugadores.");
            return;
        }

        System.out.println("Ingrese el DNI del jugador a eliminar:");
        String dni = scanner.nextLine();
        boolean eliminado = equipo.eliminarJugador(dni);
        if (eliminado) {
            System.out.println("Jugador eliminado correctamente del equipo.");
        } else {
            System.out.println("No se encontró ningún jugador con ese DNI en el equipo.");
        }
    }

    public static void eliminarPortero(Scanner scanner, Equipo equipo) {
        if (equipo == null) {
            System.out.println("Crea un equipo antes de eliminar porteros.");
            return;
        }

        System.out.println("Ingrese el DNI del portero a eliminar:");
        String dni = scanner.nextLine();
        boolean eliminado = equipo.eliminarPortero(dni);
        if (eliminado) {
            System.out.println("Portero eliminado correctamente del equipo.");
        } else {
            System.out.println("No se encontró ningún portero con ese DNI en el equipo.");
        }
    }

    public static void mostrarDetallesEquipo(Equipo equipo) {
        if (equipo == null) {
            System.out.println("Crea un equipo antes de mostrar los detalles.");
            return;
        }

        System.out.println("Detalles del equipo:");
        System.out.println(equipo.toString());
    }

    public static void mostrarJugadoresMenoresEdad(Equipo equipo) {
        if (equipo == null) {
            System.out.println("Crea un equipo antes de mostrar los jugadores menores de edad.");
            return;
        }

        ArrayList<Jugador> menoresEdad = equipo.menoresEdad();
        System.out.println("Jugadores menores de edad:");
        if (menoresEdad.isEmpty()) {
            System.out.println("No hay jugadores menores de edad en el equipo.");
        } else {
            for (Jugador jugador : menoresEdad) {
                System.out.println(jugador.toString());
            }
        }
    }

    public static void mostrarJugadoresTitulares(Equipo equipo) {
        if (equipo == null) {
            System.out.println("Crea un equipo antes de mostrar los jugadores titulares.");
            return;
        }

        ArrayList<Jugador> jugadoresTitulares = equipo.jugadoresTitulares();
        System.out.println("Jugadores titulares:");
        if (jugadoresTitulares.isEmpty()) {
            System.out.println("No hay jugadores titulares en el equipo.");
        } else {
            for (Jugador jugador : jugadoresTitulares) {
                System.out.println(jugador.toString());
            }
        }
    }

    public static void grabarEquipoCSV(Scanner scanner, Equipo equipo) {
        if (equipo == null) {
            System.out.println("Crea un equipo antes de grabarlo en un fichero CSV.");
            return;
        }

        System.out.println("Ingrese el nombre del fichero CSV:");
        String nombreFichero = scanner.nextLine();
        boolean grabado = ControladorFicheros.grabarEquipoCSV(nombreFichero, equipo);
        if (grabado) {
            System.out.println("Equipo grabado correctamente en el fichero " + nombreFichero);
        } else {
            System.out.println("Error al grabar el equipo en el fichero " + nombreFichero);
        }
    }

    public static Equipo leerEquipoCSV(Scanner scanner) {
        System.out.println("Ingrese el nombre del fichero CSV:");
        String nombreFichero = scanner.nextLine();
        Equipo equipo = ControladorFicheros.leerEquipoCSV(nombreFichero);
        if (equipo != null) {
            System.out.println("Equipo leído desde el fichero:");
            System.out.println(equipo.toString());
        } else {
            System.out.println("Error al leer el equipo desde el fichero " + nombreFichero);
        }
        return equipo;
    }





}