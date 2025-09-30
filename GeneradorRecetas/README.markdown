# Organizador de Recetas

![Java](https://img.shields.io/badge/Java-17-blue)
![Licencia](https://img.shields.io/badge/Licencia-MIT-green)

## Descripción

**Organizador de Recetas** es una aplicación de consola desarrollada en Java que permite gestionar y organizar recetas de cocina. Los usuarios pueden agregar, visualizar, modificar, eliminar y buscar recetas según ingredientes o tiempo de preparación. Las recetas se almacenan en un archivo serializado (`recetas.ser`) dentro de un directorio `Recetas`, garantizando la persistencia de los datos entre sesiones. La aplicación incluye 50 recetas precargadas, que abarcan desde desayunos como Tostada de Aguacate hasta cenas como Lasaña y postres como Tiramisú.

El proyecto está estructurado en tres clases principales:
- **`Recetas`**: Representa una receta con atributos como nombre, lista de ingredientes, pasos de preparación y tiempo en minutos.
- **`OrganizadorRecetas`**: Contiene la lógica principal de la aplicación, ofreciendo una interfaz de menú interactiva para la gestión de recetas.
- **`GeneradorRecetas`**: Clase auxiliar que precarga 50 recetas de ejemplo en el sistema.

## Características

- **Agregar Recetas**: Permite crear nuevas recetas ingresando nombre, ingredientes, pasos y tiempo de preparación.
- **Visualizar Recetas**: Muestra una lista de todas las recetas almacenadas y permite ver detalles (ingredientes, pasos y tiempo) de una receta seleccionada.
- **Modificar Recetas**: Actualiza los datos de una receta existente reemplazándolos con nuevos valores.
- **Eliminar Recetas**: Permite eliminar recetas no deseadas de la colección.
- **Búsqueda por Ingredientes**: Encuentra recetas que contengan un ingrediente específico.
- **Búsqueda por Tiempo**: Lista recetas que requieran al menos un tiempo de preparación especificado.
- **Búsqueda Combinada**: Busca recetas según ingrediente y tiempo mínimo de preparación.
- **Almacenamiento Persistente**: Las recetas se guardan en un archivo (`recetas.ser`) y se cargan automáticamente al iniciar la aplicación.
- **Recetas Precargadas**: Incluye 50 recetas de ejemplo, como Espaguetis a la Carbonara, Tacos de Carne, Sopa de Lentejas y más.

## Requisitos

- **Java**: Versión 17 o superior.
- Un entorno de desarrollo (como NetBeans, IntelliJ IDEA o Eclipse) o un compilador de Java para ejecutar la aplicación desde la terminal.

## Instalación

1. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/organizador-recetas.git
   cd organizador-recetas
   ```

2. **Configurar el Proyecto**:
   - Asegúrate de tener Java 17 o superior instalado. Verifica con:
     ```bash
     java -version
     ```
   - Importa el proyecto en tu IDE preferido o compila directamente desde la terminal.

3. **Compilar y Ejecutar**:
   - Si usas un IDE, importa el proyecto y ejecuta la clase `OrganizadorRecetas.java`.
   - Desde la terminal, compila y ejecuta:
     ```bash
     javac -d . src/com/mycompany/creadorrecetas/*.java
     java com.mycompany.creadorrecetas.OrganizadorRecetas
     ```

4. **Precargar Recetas (Opcional)**:
   - Para inicializar el sistema con 50 recetas de ejemplo, ejecuta la clase `GeneradorRecetas.java`:
     ```bash
     java com.mycompany.creadorrecetas.GeneradorRecetas
     ```
   - Esto creará el directorio `Recetas` y el archivo `recetas.ser` con las recetas precargadas.

## Uso

1. **Iniciar la Aplicación**:
   - Ejecuta la clase `OrganizadorRecetas`. La aplicación creará automáticamente el directorio `Recetas` si no existe y cargará las recetas guardadas desde `recetas.ser`.

2. **Menú Principal**:
   - Al iniciar, se muestra un menú con las siguientes opciones:
     ```
     Opciones a realizar:
     1. Añadir Receta
     2. Mostrar lista de recetas
     3. Modificar receta
     4. Eliminar receta
     5. Búsqueda de alimentos
     6. Búsqueda por tiempo
     7. Búsqueda alimentos y tiempo
     8. Salir
     ```
   - Selecciona una opción ingresando un número del 1 al 8.

3. **Ejemplos de Uso**:
   - **Añadir una receta**:
     - Selecciona la opción 1.
     - Ingresa el nombre, los ingredientes (escribe "fin" para terminar), los pasos (escribe "fin" para terminar) y el tiempo en minutos.
   - **Ver recetas**:
     - Selecciona la opción 2 para ver una lista de recetas.
     - Ingresa el número de la receta para ver sus detalles.
   - **Buscar por ingrediente**:
     - Selecciona la opción 5, escribe un ingrediente (por ejemplo, "pollo") y elige uno de los resultados para ver las recetas asociadas.
   - **Salir**:
     - Selecciona la opción 8 para cerrar la aplicación. Las recetas se guardan automáticamente.

## Estructura del Proyecto

```
organizador-recetas/
├── src/
│   └── com/
│       └── mycompany/
│           └── creadorrecetas/
│               ├── OrganizadorRecetas.java
│               ├── Recetas.java
│               └── GeneradorRecetas.java
├── Recetas/
│   └── recetas.ser
└── README.md
```

- **`OrganizadorRecetas.java`**: Clase principal con la lógica del menú y la gestión de recetas.
- **`Recetas.java`**: Define la estructura de una receta y soporta serialización para almacenamiento.
- **`GeneradorRecetas.java`**: Genera 50 recetas de ejemplo y las guarda en `recetas.ser`.
- **`Recetas/recetas.ser`**: Archivo donde se almacenan las recetas serializadas.

## Notas

- **Persistencia**: Las recetas se guardan en el archivo `recetas.ser` dentro del directorio `Recetas`. Asegúrate de no eliminar este archivo si deseas conservar tus recetas.
- **Errores de Entrada**: La aplicación maneja entradas inválidas (por ejemplo, números no válidos) y solicita al usuario que ingrese datos correctos.
- **Futuras Mejoras**: Según los comentarios en el código, se planea agregar un atributo para clasificar recetas por tipo de comida (desayuno, comida, cena), lo cual aún no está implementado.

## Contribuciones

¡Las contribuciones son bienvenidas! Si deseas mejorar el proyecto, sigue estos pasos:
1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m "Añadir nueva funcionalidad"`).
4. Sube los cambios (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE).

## Contacto

Para preguntas o sugerencias, contacta a [tu-nombre] en [tu-correo@ejemplo.com] o abre un issue en el repositorio.