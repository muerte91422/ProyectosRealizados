# Quién es Quién - Juego en Python con Pygame

Este es un juego interactivo basado en el clásico "Quién es Quién", implementado en Python utilizando la librería Pygame. El objetivo es adivinar un personaje seleccionado al azar respondiendo preguntas sobre sus características físicas y vestimenta.

## Requisitos

- Python 3.x
- Librería Pygame (`pip install pygame`)

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/quien-es-quien.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd quien-es-quien
   ```
3. Instala las dependencias:
   ```bash
   pip install -r requirements.txt
   ```
   (Nota: Asegúrate de crear un archivo `requirements.txt` con `pygame` si no lo tienes aún).

## Estructura del Proyecto

- `main.py`: Script principal del juego.
- `personaje1.png`, `personaje2.png`, ..., `personaje50.png`: Imágenes de los personajes (asegúrate de incluir todas las imágenes en la carpeta).

## Cómo Jugar

1. Ejecuta el script `main.py`:
   ```bash
   python main.py
   ```
2. El juego mostrará una cuadrícula con imágenes de 50 personajes.
3. Escribe preguntas como "¿Tiene barba?" o "¿Es mujer?" y presiona Enter para recibir respuestas.
4. Usa el comando "preguntas" para ver una lista de ejemplos de preguntas válidas.
5. Cuando solo quede un personaje, se revelará su nombre y podrás salir escribiendo "salir".
6. El juego es redimensionable y se adapta a la pantalla.

## Controles

- **Teclado**: Escribe preguntas y usa Enter para enviarlas. Usa Backspace para corregir.
- **Salir**: Escribe "salir" cuando ganes o cierra la ventana.

## Contribuciones

¡Las contribuciones son bienvenidas! Si deseas añadir más personajes, mejorar la interfaz o corregir errores, por favor:
1. Crea un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature-nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añade nueva característica'`).
4. Haz push a tu rama (`git push origin feature-nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia

[Especifica tu licencia aquí, por ejemplo: MIT, GPL, etc. Si no tienes una, considera añadirla.]

## Contacto

Para preguntas o sugerencias, contacta a [tu nombre o correo] o abre un issue en este repositorio.