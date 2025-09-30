# Escape del Asilo Embrujado

¡Bienvenido a *Escape del Asilo Embrujado*! Este es un juego de terror desarrollado en Java con JavaFX, donde debes navegar por un asilo embrujado, recoger llaves y encontrar la salida mientras evitas ser atrapado por un fantasma. El juego cuenta con 8 habitaciones, cada una con mensajes inquietantes y un ambiente oscuro que te mantendrá en tensión.

## Requisitos

Para ejecutar este juego, necesitas lo siguiente:

- **Java Development Kit (JDK)**: Versión 8 o superior (se recomienda JDK 11 o 17).
- **JavaFX SDK**: Versión compatible con tu JDK (por ejemplo, JavaFX 17 para JDK 17).
- Un entorno de desarrollo integrado (IDE) como NetBeans, IntelliJ IDEA o Eclipse (opcional, pero recomendado).
- Un sistema operativo compatible (Windows, macOS o Linux).
- El archivo de sonido `SUSURRO-EFECTO-DE-SONIDO-TERROR.mp3` ubicado en el directorio `src/` del proyecto.

## Instalación

Sigue estos pasos para descargar y configurar el juego:

1. **Clona o descarga el repositorio**:
   - Clona el repositorio desde GitHub:
     ```bash
     git clone <URL_DEL_REPOSITORIO>
     ```
   - O descarga el código como un archivo ZIP y descomprímelo en tu máquina.

2. **Configura JavaFX**:
   - Descarga el SDK de JavaFX desde [GluonHQ](https://gluonhq.com/products/javafx/).
   - Extrae el SDK en una carpeta de tu elección (por ejemplo, `C:\javafx-sdk` o `/home/user/javafx-sdk`).
   - Configura tu IDE o entorno para incluir las librerías de JavaFX:
     - En NetBeans: Agrega las librerías de JavaFX al proyecto (Properties > Libraries > Add JAR/Folder).
     - En IntelliJ: Configura un módulo con las dependencias de JavaFX (File > Project Structure > Libraries).
     - Si usas la línea de comandos, incluye el SDK con el argumento `--module-path` y `--add-modules`.

3. **Asegúrate de incluir el archivo de sonido**:
   - El juego requiere un archivo de sonido ubicado en `src/ssvid.net--SUSURRO-EFECTO-DE-SONIDO-TERROR.mp3`. Asegúrate de que este archivo esté presente en el directorio `src/`.
   - Si no tienes el archivo, puedes reemplazarlo con otro archivo MP3 de efectos de sonido y actualizar la ruta en el código (línea que carga el `MediaPlayer`).

4. **Verifica las dependencias**:
   - Asegúrate de que las siguientes bibliotecas de JavaFX estén incluidas:
     - `javafx.controls`
     - `javafx.fxml` (opcional, no usado directamente en este proyecto)
     - `javafx.media` (para el sonido del jumpscare)

## Ejecución

Para ejecutar el juego, sigue estos pasos:

1. **Desde un IDE**:
   - Abre el proyecto en tu IDE.
   - Configura el módulo principal como `casadelterror.asiloEmbrujado`.
   - Ejecuta el archivo `asiloEmbrujado.java` (método `main`).

2. **Desde la línea de comandos**:
   - Navega al directorio del proyecto.
   - Compila el código incluyendo el SDK de JavaFX:
     ```bash
     javac --module-path <RUTA_AL_SDK_JAVAFX>/lib --add-modules javafx.controls,javafx.media casadelterror/asiloEmbrujado.java
     ```
   - Ejecuta el juego:
     ```bash
     java --module-path <RUTA_AL_SDK_JAVAFX>/lib --add-modules javafx.controls,javafx.media casadelterror.asiloEmbrujado
     ```
   - Reemplaza `<RUTA_AL_SDK_JAVAFX>` con la ruta donde descomprimiste el SDK de JavaFX.

## Cómo jugar

- **Objetivo**: Escapa del asilo embrujado avanzando por 8 habitaciones. En cada habitación, encuentra una llave amarilla y úsala para desbloquear la puerta de salida.
- **Controles**:
  - Usa las teclas de flecha (**←**, **→**, **↑**, **↓**) para mover al jugador (cuadrado verde).
- **Mecánicas**:
  - Recoge la llave amarilla para hacer aparecer la puerta blanca.
  - Alcanza la puerta para pasar a la siguiente habitación.
  - ¡Cuidado con el fantasma! Puede aparecer aleatoriamente y perseguirte. Si te atrapa, el juego termina.
  - Cada habitación tiene un mensaje inquietante que aumenta la atmósfera de terror.
- **Victoria**: Llega a la habitación 8 y escapa por la puerta final. Si el fantasma no te ve, obtendrás un mensaje especial.

## Notas

- El juego incluye un efecto de sonido de jumpscare que se activa cuando aparece el fantasma. Asegúrate de que el archivo de sonido esté en la ruta correcta para una experiencia completa.
- Si encuentras problemas con JavaFX, verifica que la versión del JDK y el SDK de JavaFX sean compatibles.
- El juego está diseñado para una ventana de 400x300 píxeles, con un ambiente oscuro y un contorno gris desgastado para mayor inmersión.

## Contribuciones

Si deseas contribuir al proyecto, ¡siéntete libre de hacer un fork del repositorio y enviar un pull request! Algunas ideas para mejoras:
- Agregar más habitaciones o mecánicas.
- Implementar un sistema de puntaje.
- Mejorar los gráficos del fantasma o del jugador.
- Añadir más efectos de sonido o música de fondo.

## Licencia

Este proyecto está bajo la licencia predeterminada de NetBeans (puedes modificarla según tus necesidades). Consulta el archivo `license-default.txt` para más detalles.