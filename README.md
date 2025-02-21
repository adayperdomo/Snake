# Sesión 1:
En esta sesión nos dedicamos en crear la pantalla para el juego  con un tamaño personalizado con un color de fondo y tambien creamos el repositorio de github.
# Sesión 2:
En esta sesión nos dedicamos en dibujar a la serpiente para que se muestre en la pantalla y tambien le dimos movilidad para que se pueda mover tanto para arriba, como para abajo e izquierda y derecha.



# Snake en Java Swing con Pair Programming y Uso Documentado de IA

## Tarea
Programar el juego "Snake" en Java Swing, aplicando pair programming y haciendo uso documentado de herramientas de IA para la generación de código (ChatGPT, Bard, Copilot, Bing Chat, etc.).

## Objetivo General
Desarrollar, en parejas, el juego "Snake" utilizando Java Swing y aprovechando herramientas de IA. El juego deberá incluir:

- **Ventana y Panel:** Una ventana (`JFrame`) y un panel (`JPanel`) donde se dibuje el campo de juego.
- **Serpiente:** Que se mueva de manera automática (utilizando un `Timer` u otro mecanismo) y cambie de dirección mediante las teclas de flechas.
- **Comida:** Que aparezca en posiciones aleatorias y, al ser consumida, incremente tanto la longitud de la serpiente como la puntuación.
- **Colisiones:** Con las paredes o con el propio cuerpo de la serpiente, generando un "Game Over" al producirse.

## Uso de la IA de Generación de Código
- **Sin restricciones:** Se puede utilizar la IA como se desee: solicitar snippets de código, buscar ideas, depurar errores, optimizar, etc.
- **Documentación:** Es obligatorio incluir breves comentarios en el código o en este README explicando cómo la IA ha colaborado.  
  *Ejemplo:*  
  - “Este método se generó con la ayuda de ChatGPT para manejar la colisión.”  
  - “Usamos Bard para resolver un problema con el Timer.”  
  No es necesario citar cada prompt, pero sí proporcionar una visión general de las consultas o aportes principales.

## Objetivo de Aprendizaje
Integrar la IA en el flujo de desarrollo, aprender a criticar y adaptar sus sugerencias, y fomentar el trabajo en equipo mediante pair programming.

## Pair Programming (Trabajo en Pareja)
- **Organización:** Los alumnos se organizan en parejas.
- **Roles:**
  - **Driver:** Escribe el código e interactúa directamente con la IA.
  - **Navigator:** Revisa la lógica, orienta y da feedback en tiempo real.
- **Rotación:** Se recomienda cambiar de rol (Driver ↔ Navigator) cada 15-20 minutos para que ambos practiquen.
- **Comunicación:** Decidir conjuntamente qué solicitar a la IA y cómo integrar sus respuestas en el desarrollo.

## Plan de 5 Sesiones (1 hora cada una)

### Sesión 1: Creación de la Estructura del Proyecto
- **Actividades:**
  - Preparar la clase principal (por ejemplo, `SnakeGame.java`) que extienda `JFrame`.
  - Añadir un panel (por ejemplo, `GamePanel`) para el lienzo del juego.
  - Prueba: Confirmar que la ventana se abre (aún sin lógica de juego).
- **Control de Sesión:** Mostrar que el proyecto compila y se visualiza la ventana. Uso opcional de la IA para crear la ventana.

### Sesión 2: Dibujo de la Serpiente y Captura de Teclas
- **Actividades:**
  - En `paintComponent(Graphics g)`, dibujar la serpiente en una posición inicial.
  - Implementar `KeyListener` o `KeyBindings` para cambiar la dirección (arriba, abajo, izquierda, derecha).
  - Uso de la IA: Consultar cómo gestionar eventos de teclado en Swing.
- **Control de Sesión:** Al pulsar las flechas, debe evidenciarse el cambio interno de dirección, aunque la serpiente aún no se mueva de forma automática.

### Sesión 3: Movimiento Automático y Colisión con Bordes
- **Actividades:**
  - Incluir un `Timer` (o mecanismo alternativo) que invoque `actualizarLogica()` periódicamente.
  - Añadir la lógica para mover la serpiente automáticamente según la dirección actual.
  - Detectar si la cabeza se sale del panel (paredes) y generar el Game Over.
- **Control de Sesión:** Verificar que la serpiente se mueve sola y que, al salirse de los límites, el juego termina o se muestra un aviso.

### Sesión 4: Comida, Crecimiento y Puntuación
- **Actividades:**
  - Generar comida en posiciones aleatorias.
  - Al colisionar la cabeza con la comida, hacer que la serpiente crezca y se incremente la puntuación.
  - Reubicar la comida en otra posición libre tras ser consumida.
- **Control de Sesión:** Demostrar que la serpiente incrementa su tamaño y que el marcador se actualiza (por ejemplo, mediante un `JLabel` o dibujándolo en el panel).

### Sesión 5: Colisión Interna y Pulido Final
- **Actividades:**
  - Detectar colisiones internas, es decir, que la serpiente se choque consigo misma.
  - Mostrar un mensaje de Game Over y la puntuación final (por ejemplo, con un `JOptionPane` o mensaje en pantalla).
  - Realizar mejoras estéticas (fondos, colores, celdas, etc.) y usar la IA para proponer optimizaciones.
- **Control de Sesión:** Realizar una demo final donde se muestre el juego en funcionamiento: la serpiente se mueve, come, detecta colisiones con paredes o su cuerpo y finaliza correctamente el juego.

## Rúbrica de Evaluación

| **Criterio**                                  | **Descripción**                                                                                   | **0 puntos**                                                      | **1 punto**                                                                                             | **2 puntos**                                                                                |
|-----------------------------------------------|---------------------------------------------------------------------------------------------------|-------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| **Estructura e Interfaz (Sesiones 1-2)**       | Proyecto con `JFrame` y `JPanel` correctos, serpiente dibujada, captura de teclas implementada.    | No se ve la ventana o la serpiente; no compila.                   | Ventana y serpiente presentes, pero con problemas (teclas no se capturan bien, mala organización).       | Ventana funcionando, serpiente correctamente dibujada, flechas reconocidas.                 |
| **Movimiento y Colisión con Bordes (Sesión 3)** | Uso de un `Timer` para la actualización, movimiento automático de la serpiente y detección de colisión con paredes (Game Over). | No hay movimiento o no se controla la salida de la serpiente.      | Movimiento con errores notables o no se detiene correctamente al salir de los bordes.                    | Movimiento estable, bordes controlados, Game Over implementado de forma correcta.           |
| **Comida y Crecimiento (Sesión 4)**           | Generar comida aleatoria, detectar colisión con la cabeza, sumar puntos y crecer la serpiente.      | No se genera la comida o la serpiente no crece/puntúa al comer.     | Se implementa la comida, pero con inconsistencias (no siempre crece o falla al mostrar la puntuación).     | Mecánica de comida sólida: la serpiente crece, el marcador aumenta y la comida se reasigna correctamente. |
| **Colisión Interna y Fin del Juego (Sesión 5)** | Detección de colisión interna, mensaje de fin y presentación de la puntuación final.                | No se detecta colisión interna o el juego no finaliza.              | Se detecta la colisión, pero con fallos (no siempre funciona o no muestra el fin correctamente).           | Colisión interna confiable, Game Over claro, puntuación mostrada, y mejora estética en la interfaz.  |
| **Pair Programming y Documentación de IA**    | Rotación de roles (Driver/Navigator), comunicación y documentación del uso de la IA en el desarrollo. | Trabajo individual sin colaboración real o sin mención del uso de la IA. | Colaboración parcial, con uso de la IA poco documentado o roles poco definidos.                           | Roles bien rotados, comunicación fluida, y documentación clara del uso de la IA (ej. snippets, etc.).   |

**Puntuación Total:** 10 puntos (5 criterios × 2 puntos).

## Entrega y Presentación
- **Código:**  
  - Subir el código a un repositorio de GitHub.
  - Incluir comentarios en el código o en este README donde se mencione el uso de la IA (por ejemplo, “Obtenido método `moverSerpiente` con ayuda de ChatGPT”, “Pedimos a Copilot para optimizar el Timer”, etc.).
- **Demostración Final (Sesión 5):**  
  - Cada pareja presentará una demo en la que se muestre el juego funcionando.
  - Se explicará cómo se integró la IA en el desarrollo (ejemplos o resúmenes de consultas y respuestas).

## Comentarios Adicionales
Este proyecto tiene como objetivo no solo aprender a desarrollar un juego en Java Swing, sino también a integrar de forma crítica y colaborativa herramientas de inteligencia artificial en el proceso de programación. Se busca fomentar tanto la innovación en la codificación como el trabajo en equipo a través del pair programming.

---

# Snake en Java Swing

## Descripción
Este es el clásico juego "Snake" desarrollado en Java Swing. El objetivo es controlar a la serpiente usando las flechas del teclado para comer la comida que aparece de forma aleatoria, hacerla crecer y evitar colisionar contra las paredes o contra sí misma.

## Características del Juego
- **Interfaz Gráfica:**  
  El juego se ejecuta en una ventana (`JFrame`) que contiene un panel (`JPanel`) donde se dibuja el campo de juego.
  
- **Movimiento Automático:**  
  La serpiente se desplaza de manera continua y responde a las teclas de flechas (arriba, abajo, izquierda, derecha) para cambiar su dirección.

- **Comida Aleatoria:**  
  La comida aparece en posiciones aleatorias. Al consumirla, la serpiente crece y la puntuación aumenta.

- **Colisiones y Fin del Juego:**  
  Si la serpiente choca contra las paredes o contra sí misma, se produce un "Game Over" en el que se muestra la puntuación final.

## Instalación y Ejecución

### Requisitos
- Java 8 o superior.
- Un entorno de desarrollo (IDE) o compilador de Java (por ejemplo, IntelliJ IDEA, Eclipse, NetBeans).

### Clonar el Repositorio
Clona el repositorio desde GitHub:
```bash
git clone https://github.com/tuusuario/snake-java-swing.git

javac -d bin src/*.java

java -cp bin SnakeGame





