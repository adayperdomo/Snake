# Sesión 1:
En esta sesión nos dedicamos en crear la pantalla para el juego  con un tamaño personalizado con un color de fondo y tambien creamos el repositorio de github.
# Sesión 2:
En esta sesión nos dedicamos en dibujar a la serpiente para que se muestre en la pantalla y tambien le dimos movilidad para que se pueda mover tanto para arriba, como para abajo e izquierda y derecha.


# 🐍 Snake en Java Swing - [TuNombreEquipo]

## 📌 Descripción
Este es el clásico juego **Snake** desarrollado en **Java Swing**. El objetivo es controlar una serpiente que se mueve automáticamente por el campo, consumiendo comida para crecer, mientras se evita colisionar con las paredes o con el propio cuerpo.

El juego utiliza una ventana (`JFrame`) y un panel (`JPanel`) para dibujar el campo de juego, y se actualiza mediante un `Timer` que controla el movimiento y la lógica.

## 🎯 Características
✔️ Juego de **Snake** clásico.<br>
✔️ Desarrollado en **Java** con interfaz **Swing**.<br>
✔️ Movimiento automático y controlado con las teclas de flecha.<br>
✔️ Generación aleatoria de comida.<br>
✔️ Detección de colisiones que finalizan el juego (Game Over).<br>

## 🎮 Cómo Jugar

### Controles
Utiliza las flechas del teclado para cambiar la dirección de la serpiente.

### Objetivo
Consume la comida para aumentar la longitud de la serpiente y tu puntuación. Evita chocar contra las paredes o contra tu propio cuerpo.

### Game Over
Al producirse una colisión, se mostrará un mensaje de **"Game Over"** junto con la puntuación final.

## 🔧 Notas Técnicas

### Tecnología Utilizada
El juego está desarrollado en **Java** y utiliza **Swing** para la interfaz gráfica.

### Mecánica del Juego
Se utiliza un **Timer** para actualizar la lógica y el movimiento de la serpiente. La detección de colisiones, el crecimiento y la generación de comida se gestionan en función de la posición actual de la serpiente y los elementos en el campo de juego.

## 🤖 Uso de Herramientas de IA

Durante el desarrollo del juego se emplearon herramientas de inteligencia artificial (ChatGPT, BlackBoxAI, Copilot.) para:
- Sugerir mejoras en la lógica de movimiento y la detección de colisiones.
- Optimizar el manejo del Timer y la captura de eventos de teclado.
- Proporcionar fragmentos de código y resolver problemas específicos.

**Ejemplo de documentación:**
> “El método `moverSerpiente` se generó con la ayuda de BlackBoxAI para gestionar la colisión.”  
> “Utilizamos ChatGPT para optimizar la lógica del Timer.”

## 📝 Créditos

### Desarrolladores
- [Aday]
- [Matias]


## 🚀 Compilación y Ejecución

### 1️⃣ Compilar el Proyecto
Navega al directorio del proyecto y compila el código:
```sh
javac -d bin src/*.java
```
```sh
java -cp bin SnakeGame
```
