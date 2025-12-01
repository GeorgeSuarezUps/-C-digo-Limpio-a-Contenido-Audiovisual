package uni1a.modelo;

public class Documental extends ContenidoAudiovisual {
    private String tema;

    public Documental(int id, String titulo, int duracionEnMinutos, String genero, String tema) {
        super(id, titulo, duracionEnMinutos, genero);
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    @Override
    public String toCSV() {
        return "DOCUMENTAL," + getId() + "," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + tema;
    }
}