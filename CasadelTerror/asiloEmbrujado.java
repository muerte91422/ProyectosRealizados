/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package casadelterror;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 *
 * @author Hermi
 */
public class asiloEmbrujado extends Application {
    private double jugadorX = 200; // Posición inicial X (centro de la ventana)
    private double jugadorY = 250; // Posición inicial Y (cerca de la parte inferior)
    private double llaveX = 100;
    private double llaveY = 150;
    private boolean llaveRecogida = false; // Indica si la llave fue recogida
    private Text mensaje;
    private int habitacion = 1; // Empiezas en la habitación 1
    private Random random = new Random();
    private Circle llave;
    private double puertaX = 380; // Posición fija en el borde derecho
    private double puertaY = 140; // Centro vertical (ajusta según la ventana de 400x300)
    private boolean puertaVisible = false; // La puerta no aparece hasta recoger la llave
    private Rectangle puerta; // Para manipular la puerta
    private boolean juegoTerminado = false;
    private double fantasmaX = 300; // Posición inicial X del fantasma
    private double fantasmaY = 200; // Posición inicial Y del fantasma
    private boolean fantasmaVisible = false; // Indica si el fantasma está visible
    private Group fantasma; // Grupo para las formas del fantasma
    private MediaPlayer jumpscareSound;
    private Circle linterna;
    private final int radioLinterna = 60; // Radio de la luz (ajustable)
    private Text nota;
    private boolean jugadorVisto = false; // Para rastrear si el fantasma vio al jugador
    private Double fantasmaOpacidad=0.0;
    private Timeline fantasmaAnimacion; // Animación de aparición del fantasma
    
    
    
    
    private void posicionarPuertaAleatoria() {
    int borde = random.nextInt(4); // 0: izquierda, 1: derecha, 2: arriba, 3: abajo
    switch (borde) {
        case 0: // Izquierda
            puertaX = 0;
            puertaY = random.nextDouble() * 260; // Y aleatoria en el borde izquierdo
            break;
        case 1: // Derecha
            puertaX = 380;
            puertaY = random.nextDouble() * 260; // Y aleatoria en el borde derecho
            break;
        case 2: // Arriba
            puertaX = random.nextDouble() * 360; // X aleatoria en el borde superior
            puertaY = 0;
            break;
        case 3: // Abajo
            puertaX = random.nextDouble() * 360; // X aleatoria en el borde inferior
            puertaY = 260;
            break;
    }
    puerta.setX(puertaX);
    puerta.setY(puertaY);
    }
    
    
    
    @Override
   
    public void start(Stage stage) {
        
        
        Pane pane = new Pane(); 
        pane.setStyle("-fx-background-color: black;"); // Fondo oscuro para terror
        
        
        // Añadir contorno gris desgastado
        Rectangle contorno = new Rectangle(0, 0, 400, 300); // Cubre toda la pantalla
        contorno.setFill(Color.rgb(50, 50, 50)); // Gris oscuro para el contorno
        contorno.setStroke(Color.rgb(80, 80, 80)); // Borde gris más claro
        contorno.setStrokeWidth(10); // Ancho del borde
        pane.getChildren().add(contorno);
        
        
        mensaje = new Text(50, 50, "Bienvenido al Asilo Embrujado... Busca la salida.");
        mensaje.setFont(new Font(15));
        mensaje.setFill(Color.WHITE); // Texto blanco para que se vea
        pane.getChildren().add(mensaje);
        
            // Crear la linterna(Si alguien quiere ponerlo solo quitar los comentarios de aqui y los de movimiento de la linterna)
        //linterna = new Circle(jugadorX + 10, jugadorY + 10, radioLinterna); // Centrado en el jugador
        //linterna.setFill(Color.rgb(255, 255, 255, 0.7)); // Luz blanca con transparencia (70%)
        //linterna.setMouseTransparent(true); // Evita que interfiera con clics
        //pane.getChildren().add(linterna);
        
            // Crear la nota creepy
        nota = new Text(50, 70, ""); // Posición debajo del mensaje
        nota.setFill(Color.WHITE);
        nota.setVisible(false); // Inicialmente oculta
        pane.getChildren().add(nota);
        
            // Mostrar nota de la habitación 1 al inicio
        habitacion = 1; // Asegura que la variable habitacion esté inicializada
        nota.setText("Escuché gritos... el paciente 13 nunca salió.");
        nota.setVisible(true);
        
        Rectangle jugador = new Rectangle(jugadorX, jugadorY, 20, 20); // Cuadrado de 20x20
        jugador.setFill(Color.GREEN); // Color verde para el jugador
        pane.getChildren().add(jugador); // Añade el jugador al contenedor
        
        // Añadir pared en el contorno para limitar movimiento
        Rectangle bordeSuperior = new Rectangle(0, 0, 400, 10);
        Rectangle bordeInferior = new Rectangle(0, 290, 400, 10);
        Rectangle bordeIzquierdo = new Rectangle(0, 0, 10, 300);
        Rectangle bordeDerecho = new Rectangle(390, 0, 10, 300);
        bordeSuperior.setFill(Color.GRAY);
        bordeInferior.setFill(Color.GRAY);
        bordeIzquierdo.setFill(Color.GRAY);
        bordeDerecho.setFill(Color.GRAY);
        pane.getChildren().addAll(bordeSuperior, bordeInferior, bordeIzquierdo, bordeDerecho);
        
        llave = new Circle(llaveX, llaveY, 5); // Creacion de una llave que sera nuestro objeto a perseguir
        llave.setFill(Color.YELLOW); // Color amarillo para llave
        pane.getChildren().add(llave); // Añade llave al contenedor        
        
        puerta = new Rectangle(puertaX, puertaY, 20, 40); // Puerta alta y estrecha
        puerta.setFill(Color.WHITE);
        puerta.setVisible(false); // Oculta al inicio
        pane.getChildren().add(puerta);
        
       
        
                // Crear la cabeza del fantasma (círculo blanco, reducido proporcionalmente)
        javafx.scene.shape.Circle cabeza = new javafx.scene.shape.Circle(0, -5, 10); // Radio 10, desplazado hacia arriba
        cabeza.setFill(Color.WHITE);

        // Crear la parte inferior ondulada (polígono con ondas, reducido)
        javafx.scene.shape.Polygon baseOndulada = new javafx.scene.shape.Polygon(
            -10, -5,  // Punto izquierdo de la cabeza
            -10, 15,  // Baja izquierda
            -5, 10,   // Ondulación 1
            0, 15,    // Ondulación 2
            5, 10,    // Ondulación 3
            10, 15,   // Baja derecha
            10, -5    // Punto derecho de la cabeza
        );
        baseOndulada.setFill(Color.WHITE);

        // Crear los ojos (círculos rojos pequeños, ajustados)
        javafx.scene.shape.Circle ojoIzquierdo = new javafx.scene.shape.Circle(-4, -7, 2); // Posición relativa en la cabeza
        ojoIzquierdo.setFill(Color.RED);
        javafx.scene.shape.Circle ojoDerecho = new javafx.scene.shape.Circle(4, -7, 2); // Posición relativa
        ojoDerecho.setFill(Color.RED);

        // Combinar en un Group
        fantasma = new Group(cabeza, baseOndulada, ojoIzquierdo, ojoDerecho);
        fantasma.setTranslateX(fantasmaX);
        fantasma.setTranslateY(fantasmaY);
        fantasma.setOpacity(fantasmaOpacidad);
        fantasma.setVisible(false);
        pane.getChildren().add(fantasma);
        
        // Inicializar el sonido de jumpscare
        jumpscareSound = new MediaPlayer(new Media(new File("src/ssvid.net--SUSURRO-EFECTO-DE-SONIDO-TERROR.mp3").toURI().toString()));
        jumpscareSound.setVolume(0.5); // Ajusta el volumen (0.0 a 1.0)
        
        Scene scene = new Scene(pane, 400, 300); // Ventana de 400x300
        scene.setOnKeyPressed(event -> {
            if (juegoTerminado){
                return;
            }
            double nuevoX = jugadorX;
            double nuevoY = jugadorY;
            switch (event.getCode()) {
                case LEFT: nuevoX -= 10; break;
                case RIGHT: nuevoX += 10; break;
                case UP: nuevoY -= 10; break;
                case DOWN: nuevoY += 10; break;
            }
            
            // Verificar colisiones con el borde
            if (nuevoX >= 10 && nuevoX + 20 <= 390 && nuevoY >= 10 && nuevoY + 20 <= 290) {
                jugadorX = nuevoX;
                jugadorY = nuevoY;
                jugador.setX(jugadorX);
                jugador.setY(jugadorY);
            }
           
            
           
            
            // Verifica si el jugador toca la llave
            if (!llaveRecogida && Math.abs(jugadorX - llaveX) < 15 && Math.abs(jugadorY - llaveY) < 15) {
                llaveRecogida = true;
                pane.getChildren().remove(llave);
                puerta.setVisible(true);
                puertaVisible = true;
                mensaje.setText("¡Encontraste la llave! Busca la puerta para salir...");
            }

            // Cambiar de habitación o ganar al tocar la puerta
            if (puertaVisible && Math.abs(jugadorX - puertaX) < 15 && Math.abs(jugadorY - puertaY) < 20) {
                if (habitacion < 8) {
                    habitacion++;
                    jugadorX = 10;
                    jugadorY = 140;
                    jugador.setX(jugadorX);
                    jugador.setY(jugadorY);
                    llaveX = random.nextDouble() * 370; // Llave en un lugar accesible
                    llaveY = random.nextDouble() * 270;
                    llave.setCenterX(llaveX);
                    llave.setCenterY(llaveY);
                    llaveRecogida = false;
                    pane.getChildren().add(llave);
                    puerta.setVisible(false);
                    puertaVisible = false;
                    if (habitacion > 1) {
                        posicionarPuertaAleatoria();
                    } else {
                        puertaX = 380;
                        puertaY = 140;
                        puerta.setX(puertaX);
                        puerta.setY(puertaY);
                    }
                    mensaje.setText("Habitación " + habitacion + ": Busca la llave...");
                    // Mostrar nota creepy según la habitación
                    switch (habitacion) {
                        case 1:
                            nota.setText("Escuché gritos... el paciente 13 nunca salió.");
                            break;
                        case 2:
                            nota.setText("Las paredes susurran tu nombre...");
                            break;
                        case 3:
                            nota.setText("Algo me observa desde la oscuridad...");
                            break;
                        case 4:
                            nota.setText("Un frío helado recorre el aire...");
                            break;
                        case 5:
                            nota.setText("Escuché pasos detrás de mí... pero no había nadie.");
                            break;
                        case 6:
                            nota.setText("Las sombras parecen moverse solas...");
                            break;
                        case 7:
                            nota.setText("Un susurro dice mi nombre en la distancia...");
                            break;
                        case 8:
                            nota.setText("La salida está cerca... pero algo me retiene.");
                            break;
                    }
                    nota.setVisible(true); // Muestra la nota
                } else if (habitacion == 8) {
                    juegoTerminado = true;
                    if (jugadorVisto) {
                        mensaje.setText("¡Escapaste del asilo! Pero algo aún te observa...");
                    } else {
                        mensaje.setText("¡Escapaste sin ser visto! El asilo guarda tu secreto...");
                    }
                }
            }

            // Hacer aparecer al fantasma aleatoriamente
            if (random.nextDouble() < 0.03 && !fantasmaVisible && !juegoTerminado) {
                fantasmaVisible = true;
                fantasma.setVisible(true);
                do {
                    fantasmaX = random.nextDouble() * 350;
                    fantasmaY = random.nextDouble() * 250;
                    
                    
                       if (fantasmaX < 10 || fantasmaX + 20 > 390 || fantasmaY < 10 || fantasmaY + 20 > 290) {
                        continue; // Limita al fantasma dentro del contorno

                        }
                    
                       break;
                       
                } while (true);
                fantasma.setTranslateX(fantasmaX);
                fantasma.setTranslateY(fantasmaY);
                mensaje.setText("¡EL FANTASMA! Corre...");
                jumpscareSound.stop(); // Detiene si estaba reproduciéndose
                jumpscareSound.play(); // Reproduce el sonido
                nota.setVisible(false); // Oculta la nota
                // Iniciar animación de aparición
                fantasmaOpacidad = 0.0;
                fantasma.setOpacity(fantasmaOpacidad);
                if (fantasmaAnimacion != null) fantasmaAnimacion.stop();
                fantasmaAnimacion = new Timeline(
                    new KeyFrame(Duration.seconds(0.1), animEvent -> {
                        fantasmaOpacidad += 0.2; // Incrementa la opacidad
                        if (fantasmaOpacidad > 1.0) fantasmaOpacidad = 1.0;
                        fantasma.setOpacity(fantasmaOpacidad);
                    })
                );
                fantasmaAnimacion.setCycleCount(5); // 5 pasos para aparecer
                fantasmaAnimacion.play();
            }
        });
        
    // Actualizar la posición de la linterna
    //linterna.setCenterX(jugadorX + 10); Por si alguien quiere poner el efecto de linterna en el jugador
    //linterna.setCenterY(jugadorY + 10);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (juegoTerminado){
                    return;
                }
                if (fantasmaVisible) {
                    // Mover fantasma hacia el jugador
                    double nuevoFantasmaX = fantasmaX;
                    double nuevoFantasmaY = fantasmaY;
                    if (fantasmaX < jugadorX){ 
                        nuevoFantasmaX += 1;
                    }else if (fantasmaX > jugadorX){
                        nuevoFantasmaX -= 1;
                    }if (fantasmaY < jugadorY){
                        nuevoFantasmaY += 1;
                    }else if (fantasmaY > jugadorY){
                        nuevoFantasmaY -= 1;
                    }
                    
                   // Verificar colisiones con el borde
                    if (nuevoFantasmaX >= 10 && nuevoFantasmaX + 20 <= 390 && nuevoFantasmaY >= 10 && nuevoFantasmaY + 20 <= 290) {
                        fantasmaX = nuevoFantasmaX;
                        fantasmaY = nuevoFantasmaY;
                        fantasma.setTranslateX(fantasmaX);
                        fantasma.setTranslateY(fantasmaY);
                    }
                    
                }
                    // Verifica si el fantasma te atrapa
                    if (Math.abs(fantasmaX - jugadorX) < 15 && Math.abs(fantasmaY - jugadorY) < 15) {
                        juegoTerminado = true;
                        mensaje.setText("El fantasma te atrapó... GAME OVER.");
                        fantasma.setVisible(false);
                        fantasmaVisible = false;
                    } else if (Math.abs(fantasmaX - jugadorX) < 50 && Math.abs(fantasmaY - jugadorY) < 50) {
                    jugadorVisto = true; // El fantasma te vio si está cerca
                    }

                    // Desaparecer el fantasma aleatoriamente
                    if (random.nextDouble() < 0.008) {
                        fantasma.setVisible(false);
                        fantasmaVisible = false;
                        mensaje.setText("Habitación " + habitacion + ": Busca la llave...");
                    }
                }
                
            
            }.start();
        
        stage.setTitle("Escape del Asilo Embrujado");
        stage.setScene(scene);
        stage.show();// Mostrar la ventana
        
    }
    public static void main(String args[]) {
        // TODO code application logic here
        launch(args);
        
    }
    
}
