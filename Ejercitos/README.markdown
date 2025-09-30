# ⚔️ Batalla de Ejércitos

¡Bienvenido a **Batalla de Ejércitos**, un emocionante juego de simulación en Python donde dos ejércitos épicos, el Equipo Rojo y el Equipo Azul, se enfrentan en un combate estratégico por turnos! Desarrollado con programación orientada a objetos, este juego enfrenta a cinco clases de guerreros únicas, cada una con habilidades, estadísticas y movimientos especiales. ¡Observa cómo caballeros, arqueros, magos, asesinos y curanderos luchan hasta que un equipo se alce con la victoria o ambos caigan en un empate dramático!

## 🎮 Descripción del Juego

En **Batalla de Ejércitos**, dos ejércitos se enfrentan en un sistema de combate dinámico y aleatorio. Cada ejército está compuesto por cinco guerreros:
- **Caballero**: Un tanque poderoso con alta defensa y ataques fuertes.
- **Arquero**: Un tirador rápido con probabilidad de golpes críticos.
- **Mago**: Un hechicero con ataques devastadores y una habilidad especial para curar aliados.
- **Asesino**: Un luchador sigiloso con alta velocidad y potencial de golpes críticos.
- **Curandero**: Una clase de apoyo que restaura la salud de sus compañeros.

El juego determina el orden de los turnos según la estadística de velocidad más alta, con un toque divertido: ¡si las velocidades están empatadas, el Equipo Azul (las "señoritas") ataca primero! Cada guerrero puede elegir **atacar**, **defender** o (en el caso de los curanderos) **curar**, con resultados influenciados por la aleatoriedad y cálculos estratégicos.

## 🚀 Características

- **Combate Dinámico**: Estadísticas y acciones aleatorias aseguran que cada batalla sea única.
- **Mecánicas por Clases**: Cada clase de guerrero tiene atributos y habilidades únicas, como golpes críticos, ataques de área y curaciones.
- **Estrategia por Turnos**: La velocidad determina el orden de los turnos, con cada guerrero actuando una vez por ronda hasta que todos son derrotados.
- **Interfaz Interactiva**: El juego usa salidas temporizadas y limpieza de pantalla para una experiencia inmersiva en Jupyter Notebooks.
- **Narrativa Épica**: Mensajes de victoria divertidos celebran al equipo ganador (¡o se burlan de ambos en caso de empate!).

## 🛠️ Instalación

Para ejecutar **Batalla de Ejércitos**, necesitas Python 3 y un entorno de Jupyter Notebook. Sigue estos pasos:

1. **Clonar el Repositorio**:
   ```bash
   git clone <url-del-repositorio>
   cd batalla-de-ejercitos
   ```

2. **Instalar Dependencias**:
   El juego utiliza bibliotecas estándar de Python (`random`, `time`) y `IPython.display` para la integración con Jupyter Notebook. No se requieren paquetes adicionales.

3. **Ejecutar el Juego**:
   Abre el archivo `.ipynb` en Jupyter Notebook y ejecuta las celdas en orden:
   - Celda 1: Definiciones de las clases de guerreros (`Guerrero` y subclases).
   - Celda 2: Definición de la clase `Ejercito`.
   - Celda 3: Bucle principal del juego.

   ```bash
   jupyter notebook batalla_de_ejercitos.ipynb
   ```

## 📜 Cómo Jugar

1. **Iniciar el Juego**: Ejecuta todas las celdas en el Jupyter Notebook.
2. **Ver Estadísticas de los Ejércitos**: El juego muestra las estadísticas (salud, fuerza, defensa, velocidad) de cada guerrero en los equipos Rojo y Azul.
3. **Seguir la Batalla**: El juego determina qué equipo ataca primero según la velocidad más alta. En cada turno, un guerrero de cada equipo actúa (ataca, defiende o cura), con los resultados impresos en la consola.
4. **Habilidades Especiales**:
   - **Arquero**: 30% de probabilidad de un golpe crítico.
   - **Mago**: 10% de probabilidad de atacar a todos los enemigos o curar a un aliado al defender.
   - **Asesino**: 25% de probabilidad de un golpe crítico con daño duplicado.
   - **Curandero**: Puede restaurar 30 de salud al aliado con menos vida.
5. **Condiciones de Victoria**: La batalla continúa hasta que un equipo es derrotado (la salud de todos sus guerreros llega a 0) o ambos equipos caen simultáneamente, resultando en un empate.

## 📂 Estructura del Proyecto

El juego está contenido en un solo archivo de Jupyter Notebook (`batalla_de_ejercitos.ipynb`) con tres celdas:
- **Celda 1**: Define la clase base `Guerrero` y sus subclases (`Caballero`, `Arquero`, `Mago`, `Asesino`, `Curandero`) con sus estadísticas y habilidades.
- **Celda 2**: Define la clase `Ejercito`, creando dos equipos (Rojo y Azul) con nombres únicos para los guerreros.
- **Celda 3**: Implementa el bucle principal del juego, manejando el combate por turnos, actualizaciones de estadísticas y condiciones de victoria.

## 🧑‍💻 Ejemplo de Salida

```
El ejercito rojo:
El caballero:
Las estadisticas de Alex son:
 Salud     = 120
 Fuerza    = 35
 Defensa   = 60
 Velocidad = 15
...

Ataca el equipo rojo primero
Turno numero 1
Rojo
El caballero ataca a el mago azul
Daño a realizar 42.0

Azul
El arquero se defiende

Enfrentamiento de los ejercitos
El caballero rojo golpea a el mago azul y le hace 42.0 de daño
...
```

## 🌟 Mejoras Futuras

- Añadir entrada del usuario para controlar las acciones de los guerreros en lugar de elecciones aleatorias.
- Implementar una interfaz gráfica usando Pygame o Tkinter.
- Introducir nuevas clases de guerreros o habilidades especiales.
- Agregar un sistema de puntuación para rastrear victorias en múltiples batallas.

## 🤝 Contribuciones

¡Siéntete libre de hacer un fork de este repositorio, enviar pull requests o abrir issues para sugerir mejoras o reportar errores! Hagamos que **Batalla de Ejércitos** sea aún más épica.

## 📝 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---

**¿Listo para liderar a tu ejército hacia la gloria? ¡Ejecuta el juego y que comience la batalla!** ⚔️