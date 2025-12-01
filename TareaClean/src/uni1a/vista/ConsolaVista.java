package uni1a.vista;

import uni1a.modelo.*;
import java.util.List;
import java.util.Scanner;

public class ConsolaVista {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- SISTEMA AUDIOVISUAL ---");
        System.out.println("1. Listar Contenidos");
        System.out.println("2. Agregar Película");
        System.out.println("3. Agregar Serie de TV");
        System.out.println("4. Agregar Documental");
        System.out.println("5. Guardar y Salir");
        System.out.print("Seleccione una opción: ");
        return leerEntero();
    }

    public void mostrarLista(List<ContenidoAudiovisual> contenidos) {
        System.out.println("\n--- LISTA DE CONTENIDOS ---");
        if (contenidos.isEmpty()) {
            System.out.println("(Vacío)");
            return;
        }
        
        System.out.printf("%-5s %-20s %-15s %-10s %-15s%n", "ID", "TÍTULO", "TIPO", "MINUTOS", "EXTRA");
        System.out.println("---------------------------------------------------------------------");
        
        for (ContenidoAudiovisual c : contenidos) {
            String tipo = "";
            String extra = "";
            
            if (c instanceof Pelicula) {
                tipo = "Película";
                extra = ((Pelicula) c).getEstudio();
            } else if (c instanceof SerieDeTV) {
                tipo = "Serie";
                extra = ((SerieDeTV) c).getTemporadas() + " temps";
            } else if (c instanceof Documental) {
                tipo = "Documental";
                extra = ((Documental) c).getTema();
            }

            System.out.printf("%-5d %-20s %-15s %-10d %-15s%n", 
                c.getId(), c.getTitulo(), tipo, c.getDuracionEnMinutos(), extra);
        }
    }

    // --- Métodos para pedir datos ---

    public Pelicula pedirDatosPelicula() {
        System.out.println("\n--- NUEVA PELÍCULA ---");
        int id = pedirId();
        String titulo = pedirString("Título: ");
        int duracion = pedirInt("Duración (min): ");
        String genero = pedirString("Género: ");
        String estudio = pedirString("Estudio: ");
        return new Pelicula(id, titulo, duracion, genero, estudio);
    }

    public SerieDeTV pedirDatosSerie() {
        System.out.println("\n--- NUEVA SERIE ---");
        int id = pedirId();
        String titulo = pedirString("Título: ");
        int duracion = pedirInt("Duración prom. (min): ");
        String genero = pedirString("Género: ");
        int temporadas = pedirInt("Nº Temporadas: ");
        return new SerieDeTV(id, titulo, duracion, genero, temporadas);
    }

    public Documental pedirDatosDocumental() {
        System.out.println("\n--- NUEVO DOCUMENTAL ---");
        int id = pedirId();
        String titulo = pedirString("Título: ");
        int duracion = pedirInt("Duración (min): ");
        String genero = pedirString("Género: ");
        String tema = pedirString("Tema: ");
        return new Documental(id, titulo, duracion, genero, tema);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(">> " + mensaje);
    }

    // --- Métodos auxiliares privados para no repetir código ---
    
    private int pedirId() {
        System.out.print("ID Único: ");
        return leerEntero();
    }

    private String pedirString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private int pedirInt(String mensaje) {
        System.out.print(mensaje);
        return leerEntero();
    }

    private int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return numero;
    }
}