package uni1a.controlador;

import uni1a.modelo.*;
import uni1a.persistencia.GestorArchivos;
import uni1a.vista.ConsolaVista;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudioVisualController {
    private List<ContenidoAudiovisual> contenidos;
    private ConsolaVista vista;
    private GestorArchivos gestorArchivos;

    public AudioVisualController() {
        this.vista = new ConsolaVista();
        this.gestorArchivos = new GestorArchivos();
        this.contenidos = new ArrayList<>();
    }

    public void iniciar() {
        cargarDatosIniciales();
        
        boolean continuar = true;
        while (continuar) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    vista.mostrarLista(contenidos);
                    break;
                case 2:
                    contenidos.add(vista.pedirDatosPelicula());
                    vista.mostrarMensaje("Película agregada con éxito.");
                    break;
                case 3:
                    contenidos.add(vista.pedirDatosSerie());
                    vista.mostrarMensaje("Serie agregada con éxito.");
                    break;
                case 4:
                    contenidos.add(vista.pedirDatosDocumental());
                    vista.mostrarMensaje("Documental agregado con éxito.");
                    break;
                case 5:
                    guardarDatos();
                    continuar = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
        vista.mostrarMensaje("Saliendo del sistema...");
    }

    private void cargarDatosIniciales() {
        try {
            contenidos = gestorArchivos.cargarContenidos();
            vista.mostrarMensaje("Datos cargados correctamente (" + contenidos.size() + " registros).");
        } catch (IOException e) {
            vista.mostrarMensaje("No se pudo cargar el archivo (se creará uno nuevo al guardar).");
        }
    }

    private void guardarDatos() {
        try {
            gestorArchivos.guardarContenidos(contenidos);
            vista.mostrarMensaje("Archivo 'contenidos.csv' guardado correctamente.");
        } catch (IOException e) {
            vista.mostrarMensaje("Error crítico al guardar: " + e.getMessage());
        }
    }
}