package uni1a.persistencia;

import uni1a.modelo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {
    private final String ARCHIVO_CSV = "contenidos.csv";

    // GUARDAR: Convierte la lista de objetos a líneas de texto en el archivo
    public void guardarContenidos(List<ContenidoAudiovisual> contenidos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CSV))) {
            for (ContenidoAudiovisual contenido : contenidos) {
                writer.write(contenido.toCSV());
                writer.newLine(); // Salto de línea
            }
        }
    }

    // CARGAR: Lee el archivo línea por línea y reconstruye los objetos
    public List<ContenidoAudiovisual> cargarContenidos() throws IOException {
        List<ContenidoAudiovisual> lista = new ArrayList<>();
        File file = new File(ARCHIVO_CSV);
        
        // Si el archivo no existe, retornamos una lista vacía para empezar de cero
        if (!file.exists()) {
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length < 5) continue; // Validación básica

                String tipo = partes[0];
                int id = Integer.parseInt(partes[1]);
                String titulo = partes[2];
                int duracion = Integer.parseInt(partes[3]);
                String genero = partes[4];

                // Fábrica simple (Switch) para crear el objeto correcto
                switch (tipo) {
                    case "PELICULA":
                        String estudio = partes[5];
                        lista.add(new Pelicula(id, titulo, duracion, genero, estudio));
                        break;
                    case "SERIE":
                        int temporadas = Integer.parseInt(partes[5]);
                        lista.add(new SerieDeTV(id, titulo, duracion, genero, temporadas));
                        break;
                    case "DOCUMENTAL":
                        String tema = partes[5];
                        lista.add(new Documental(id, titulo, duracion, genero, tema));
                        break;
                }
            }
        }
        return lista;
    }
}