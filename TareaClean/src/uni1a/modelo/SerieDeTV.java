package uni1a.modelo;

public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;

    public SerieDeTV(int id, String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(id, titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }

    @Override
    public String toCSV() {
        return "SERIE," + getId() + "," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + temporadas;
    }
}