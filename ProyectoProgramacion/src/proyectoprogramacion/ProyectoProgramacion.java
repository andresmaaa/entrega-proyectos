package proyectoprogramacion;
import java.util.Scanner;

public class ProyectoProgramacion {

    public static String[][] festivales = new String[100][4]; // tenemos capacidad 100 festivales con 4 atributos
    public static int totalFestivales = 0;

    public static String[][] usuarios = new String[100][2];//tenemos capacidad 100 usuarios con 2 atributos

    public static int totalUsuarios = 0;

    public static String[][] inscripciones = new String[100][2];//tenemos capacidad 100 inscripciones con 2 atributos
    public static int totalInscripciones = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("\n--- Sistema de Gestion de Festivales de Espania ---");
            System.out.println("1. Registrar festival");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Inscribirse en un festival");
            System.out.println("4. Mostrar festivales disponibles");
            System.out.println("5. Mostrar inscripciones");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarFestival(sc);
                    break;
                case 2:
                    registrarUsuario(sc);
                    break;
                case 3:
                    inscribirUsuario(sc);
                    break;
                case 4:
                    mostrarFestivales();
                    break;
                case 5:
                    mostrarInscripciones();
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
        sc.close(); // cerramos escaner para no ocupar memoria
    }

    // Metodo para registrar un festival
    private static void registrarFestival(Scanner sc) {
        String nombre, fecha,ubicacion, categoria;
        
        System.out.println("\n--- Registrar Festival ---");
        System.out.print("Nombre del festival: ");
        nombre = sc.nextLine();
        System.out.print("Fecha del festival (dd/mm/aaaa): ");
        fecha = sc.nextLine();
        System.out.print("Ubicacion del festival (ciudad, region): ");
        ubicacion = sc.nextLine();
        System.out.print("Categoria del festival (musica, cine, gastronomia, etc.): ");
        categoria = sc.nextLine();

        //se añade a la posicion total festivales el nombre, la fecha, la ubicacion y la categoria
        festivales[totalFestivales][0] = nombre;
        festivales[totalFestivales][1] = fecha;
        festivales[totalFestivales][2] = ubicacion;
        festivales[totalFestivales][3] = categoria;
        totalFestivales++; // sumamos 1 para añadir mas festivales abajo

        System.out.println("Festival registrado con exito.");
    }

    // Registrar un usuario
    private static void registrarUsuario(Scanner sc) {
        String nombre, correo;
        System.out.println("\n--- Registrar Usuario ---");
        System.out.print("Nombre del usuario: ");
        nombre = sc.nextLine();
        System.out.print("Correo electronico: ");
        correo = sc.nextLine();

        // Guardar el usuario en la matriz
        usuarios[totalUsuarios][0] = nombre;
        usuarios[totalUsuarios][1] = correo;
        totalUsuarios++;// sumamos 1 para añadir mas usuarios abajo

        System.out.println("Usuario registrado con exito.");
    }

    // Inscribir a un usuario en un festival
    private static void inscribirUsuario(Scanner sc) {
        System.out.println("\n--- Inscribirse en un Festival ---");
        if (totalUsuarios == 0 || totalFestivales == 0) {
            System.out.println("No hay usuarios o festivales registrados.");
            return;
        }

        // Mostrar usuarios
        System.out.println("Seleccione un usuario:");
        for (int i = 0; i < totalUsuarios; i++) {
            System.out.println((i + 1) + ". " + usuarios[i][0]); // el i + 1; es para que muestre los festivales enumerandolos y que empiece por el 1; 1.1 festival 1/1.2 festival 2 
        }
        int posicionUsuario = sc.nextInt() - 1;
        sc.nextLine();

        // Mostrar festivales
        System.out.println("Seleccione un festival:");
        for (int i = 0; i < totalFestivales; i++) {
            System.out.println((i + 1) + ". " + festivales[i][0] + " (" + festivales[i][2] + ")");
        }
        int posicionFestival = sc.nextInt() - 1;
        sc.nextLine();

        // Guardar la inscripcion
        inscripciones[totalInscripciones][0] = usuarios[posicionUsuario][0]; // guarda nombre del usuario
        inscripciones[totalInscripciones][1] = festivales[posicionFestival][0];// guarda nombre del festival
        totalInscripciones++;

        System.out.println("Inscripcion realizada con exito.");
    }

    // Mostrar todos los festivales
    private static void mostrarFestivales() {
        System.out.println("\n--- Festivales Disponibles ---");
        if (totalFestivales == 0) {
            System.out.println("No hay festivales registrados.");
        } else {
            for (int i = 0; i < totalFestivales; i++) {
                System.out.println((i + 1) + ". " + festivales[i][0] + " | Fecha: " + festivales[i][1]
                        + " | Ubicacion: " + festivales[i][2] + " | Categoria: " + festivales[i][3]);
            }
        }
    }

    // Mostrar todas las inscripciones
    private static void mostrarInscripciones() {
        System.out.println("\n--- Inscripciones ---");
        if (totalInscripciones == 0) {
            System.out.println("No hay inscripciones registradas.");
        } else {
            for (int i = 0; i < totalInscripciones; i++) {
                System.out.println(inscripciones[i][0] + " esta incrito en:  " + inscripciones[i][1]);// inscripciones[i][0] muestra el nombre del usuario. inscripciones[i][1] muestra el nombre del festival
            }
        }
    }
}
