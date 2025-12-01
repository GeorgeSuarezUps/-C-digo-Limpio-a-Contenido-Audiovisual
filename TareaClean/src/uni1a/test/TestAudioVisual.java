package uni1a.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import uni1a.modelo.*;
import java.util.ArrayList;
import java.util.List;

// Pruebas unitarias para validar la lógica del negocio
class TestAudioVisual {

    @Test
    void testCreacionPelicula() {
        // Probamos que el constructor asigne bien los datos
        Pelicula p = new Pelicula(1, "Matrix", 136, "Sci-Fi", "Warner Bros");
        
        assertEquals(1, p.getId(), "El ID debe ser 1");
        assertEquals("Matrix", p.getTitulo(), "El título debe coincidir");
        assertEquals("Warner Bros", p.getEstudio(), "El estudio debe coincidir");
    }

    @Test
    void testFormatoCSVPelicula() {
        // Probamos que el formato CSV sea exacto (importante para el archivo)
        Pelicula p = new Pelicula(10, "Up", 90, "Animacion", "Pixar");
        String esperado = "PELICULA,10,Up,90,Animacion,Pixar";
        
        assertEquals(esperado, p.toCSV(), "El CSV generado no es correcto");
    }

    @Test
    void testSerieTemporadas() {
        // Probamos lógica específica de Series
        SerieDeTV s = new SerieDeTV(2, "Dark", 60, "Drama", 3);
        assertEquals(3, s.getTemporadas());
    }
    
    @Test
    void testPolimorfismoLista() {
        // Probamos que la lista acepte diferentes tipos (SOLID - Liskov)
        List<ContenidoAudiovisual> lista = new ArrayList<>();
        lista.add(new Pelicula(1, "A", 100, "B", "C"));
        lista.add(new SerieDeTV(2, "D", 50, "E", 5));
        
        assertEquals(2, lista.size(), "La lista debería contener 2 elementos de distinto tipo");
    }
}