package uni1a.modelo;

public class Pelicula extends ContenidoAudiovisual {
    private String estudio;

    public Pelicula(int id, String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(id, titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
    }

    public String getEstudio() {
        return estudio;
    }

    @Override
    public String toCSV() {
        // Formato: TIPO,ID,TITULO,DURACION,GENERO,ESTUDIO
        return "PELICULA," + getId() + "," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + estudio;
    }
}