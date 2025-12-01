# Sistema de Gestión de Contenidos Audiovisuales (Java MVC)

Este proyecto es una aplicación de consola en Java diseñada para gestionar una biblioteca de contenidos audiovisuales (Películas, Series y Documentales). Implementa persistencia de datos mediante archivos CSV y sigue estrictos principios de diseño de software.

## 🚀 Características

* **CRUD Completo:** Permite agregar y listar contenidos.
* **Persistencia:** Los datos se guardan automáticamente en `contenidos.csv`.
* **Arquitectura MVC:** Separación clara entre Modelo, Vista y Controlador.
* **Principios SOLID:** Código modular, extensible y fácil de mantener.
* **Tests Unitarios:** Verificación de lógica con JUnit 5.

## 🛠️ Estructura del Proyecto

El código está organizado en paquetes bajo `src/uni1a/`:

* `modelo/`: Contiene las entidades (`Pelicula`, `SerieDeTV`, etc.) y la lógica de negocio.
* `vista/`: Interfaz de usuario en consola (`ConsolaVista`).
* `controlador/`: Coordina la interacción entre el usuario y el sistema (`AudioVisualController`).
* `persistencia/`: Maneja la lectura y escritura de archivos (`GestorArchivos`).
* `test/`: Pruebas unitarias (`TestAudioVisual`).

## 📋 Pre-requisitos

* Java Development Kit (JDK) 8 o superior.
* Eclipse IDE (o cualquier otro IDE Java).
* Librería JUnit 5 (para ejecutar pruebas).

## 🔧 Cómo ejecutar

1.  Clonar este repositorio.
2.  Importar el proyecto en Eclipse.
3.  Navegar a `src/uni1a/Main.java`.
4.  Ejecutar como **Java Application**.

## 🧪 Cómo ejecutar las pruebas

1.  Navegar a la carpeta `src/uni1a/test/`.
2.  Hacer clic derecho en `TestAudioVisual.java`.
3.  Seleccionar **Run As > JUnit Test**.

## 📝 Cambios Realizados (Refactorización)

* **Código Limpio:** Se mejoraron los nombres de variables y métodos para mayor claridad.
* **SRP:** Se separó la lógica de archivos de las clases de entidad.
* **Persistencia:** Se implementó lectura/escritura robusta con `BufferedReader`.
