package uni1a;

import uni1a.controlador.AudioVisualController;

public class Main {
    public static void main(String[] args) {
        // Principio de Inversión de Control: Main solo inicia, no hace lógica.
        AudioVisualController controlador = new AudioVisualController();
        controlador.iniciar();
    }
}