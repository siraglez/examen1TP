link al repositorio: https://github.com/siraglez/examen1TP.git

# Ejercicio 5 examen

Este proyecto implementa un juego de batalla naval en Java.

## Clases

### Barco

- Representa un barco genérico con un tamaño dado.
- Tiene un array de booleanos llamado `impactos` que indica qué partes del barco han sido impactadas.
- Métodos:
  - `estaHundido()`: Devuelve verdadero si todas las partes del barco han sido impactadas.
  - `recibirImpacto(int posicion)`: Marca la parte del barco en la posición dada como impactada.

### Battleship

- Subclase de `Barco` que representa un tipo específico de barco llamado "Battleship".
- Atributo adicional:
  - `contenedoresAislados`: Array que indica qué contenedores aislados del Battleship han sido impactados.
- Sobrescribe el método `recibirImpacto(int posicion)` de la clase `Barco` para manejar el impacto en contenedores aislados.

### Canoe y Frigate

- Subclases de `Barco` que representan tipos específicos de barcos con tamaños diferentes.

### Tablero

- Representa el tablero del juego donde se colocan los barcos y se realizan los ataques.
- Atributos:
  - `cuadricula`: Matriz de objetos de tipo `Barco` que representa la disposición de los barcos en el tablero.
- Métodos:
  - `colocarBarco(Barco barco, int fila, int columna, boolean horizontal)`: Coloca un barco en una posición dada en el tablero.
  - `atacar(int fila, int columna)`: Ataca una posición en el tablero y marca el impacto en el barco correspondiente.
  - `todosBarcosHundidos()`: Verifica si todos los barcos en el tablero han sido hundidos.

# Pseudocódigo

```java
Clase Barco:
    Atributos:
        - tamanio: entero
        - impactos: arreglo de booleanos

    Constructor Barco(tamanio):
        Asignar tamanio a this.tamanio
        Inicializar impactos como un arreglo de tamaño tamanio, todos los elementos a false

    Método estaHundido():
        Para cada impacto en impactos:
            Si impacto es falso:
                Retornar falso
        Retornar verdadero

    Método recibirImpacto(posicion):
        Si posicion está dentro de los límites del arreglo impactos:
            Asignar true a impactos[posicion]

Clase Battleship hereda de Barco:
    Atributos:
        - contenedoresAislados: arreglo de booleanos

    Constructor Battleship():
        Llamar al constructor de la clase base con un tamaño de 5
        Inicializar contenedoresAislados como un arreglo de 5 elementos, todos a false

    Método recibirImpacto(posicion, aislado):
        Si aislado es verdadero:
            Asignar true a contenedoresAislados[posicion]
            Si todos los contenedores aislados están impactados:
                Para cada posición en la longitud del barco:
                    Asignar true a impactos[posicion]
        Sino:
            Llamar al método recibirImpacto de la clase base con la posición dada

    Método todosContenedoresAisladosImpactados():
        Para cada impacto en contenedoresAislados:
            Si impacto es falso:
                Retornar falso
        Retornar verdadero

Clase Canoe hereda de Barco:
    Constructor Canoe():
        Llamar al constructor de la clase base con un tamaño de 1

Clase Frigate hereda de Barco:
    Constructor Frigate():
        Llamar al constructor de la clase base con un tamaño de 3

Clase Tablero:
    Atributos:
        - tamanio: entero
        - cuadricula: arreglo bidimensional de Barco

    Constructor Tablero(tamanio):
        Asignar tamanio a this.tamanio
        Inicializar cuadricula como un arreglo bidimensional de tamaño tamanio x tamanio

    Método colocarBarco(barco, fila, columna, horizontal):
        Si fila o columna están fuera de los límites del tablero:
            Retornar falso
        Calcular finColumna y finFila basado en la orientación horizontal
        Si finColumna o finFila están fuera de los límites del tablero:
            Retornar falso
        Para cada fila desde fila hasta finFila:
            Para cada columna desde columna hasta finColumna:
                Si cuadricula[fila][columna] no es nulo:
                    Retornar falso
        Para cada fila desde fila hasta finFila:
            Para cada columna desde columna hasta finColumna:
                Asignar barco a cuadricula[fila][columna]
        Retornar verdadero

    Método atacar(fila, columna):
        Si fila o columna están fuera de los límites del tablero:
            Retornar falso
        Si cuadricula[fila][columna] no es nulo:
            Llamar al método recibirImpacto del barco en esa posición
            Retornar verdadero
        Retornar falso

    Método todosBarcosHundidos():
        Para cada fila en la cuadricula:
            Para cada columna en la fila:
                Si cuadricula[fila][columna] no es nulo y el barco no está hundido:
                    Retornar falso
        Retornar verdadero

```


# Ejercicio 6 examen

Este proyecto proporciona una extensión al juego de batalla naval, introduciendo la implementación de jugadores y la lógica del juego.

## Clase Jugador

- Representa a un jugador en el juego.
- **Atributos**:
  - `tablero`: Representa el tablero propio del jugador.
  - `barcos`: Un arreglo de barcos que el jugador posee.
- **Constructor**:
  - Al crear un jugador, se inicializa su tablero y se colocan tres barcos predeterminados en posiciones aleatorias.
- **Métodos**:
  - `realizarAtaque()`: Genera un ataque aleatorio en el tablero del oponente.
  - `actualizarTablero(int[] ataque, boolean impacto)`: Actualiza el tablero propio del jugador después de un ataque, mostrando si se impactó o no un barco en la posición especificada.

## Clase Main

- Contiene el método `main` que inicia el juego.
- El juego comienza con la configuración de los barcos para cada jugador.
- Luego, se juegan turnos alternos hasta que uno de los jugadores hunda todos los barcos del oponente.
- Durante cada turno, un jugador elige una posición en el tablero del oponente para atacar.
- El juego termina cuando todos los barcos de uno de los jugadores son hundidos, lo que resulta en la declaración de victoria para ese jugador, o cuando ambos jugadores tienen todos sus barcos hundidos, lo que resulta en un empate.

Este código extiende la funcionalidad del juego de batalla naval al agregar la lógica de los jugadores y la ejecución del juego en sí. Ahora los jugadores pueden configurar sus barcos y competir entre sí para hundir los barcos del oponente.

# Pseudocódigo

```java
Clase Jugador:
    Atributos:
        - tablero: Tablero
        - barcos: Barco[]
  
    Constructor Jugador():
        Crear un nuevo tablero para el jugador
        Inicializar barcos como un arreglo de longitud 3
        Colocar tres barcos predeterminados en posiciones aleatorias en el tablero
  
    Método realizarAtaque():
        Generar una fila aleatoria entre 0 y 9
        Generar una columna aleatoria entre 0 y 9
        Retornar un arreglo de enteros con la fila y columna generadas
  
    Método actualizarTablero(ataque: int[], impacto: boolean):
        Extraer la fila y la columna del ataque
        Si impacto es verdadero:
            Imprimir "¡Has impactado un barco en la fila X columna Y!"
        Sino:
            Imprimir "No has impactado ningún barco en la fila X columna Y."

Clase Main:
    Método main():
        Crear un nuevo scanner para la entrada estándar
        Crear dos jugadores (jugador1 y jugador2)
        Crear dos tableros (tableroJugador1 y tableroJugador2)
    
        // Configuración de los barcos
        Para cada jugador:
            Pedir al jugador que introduzca la configuración de sus barcos mediante un método configurarBarcos()
    
        // Comienza el juego
        Mientras sea verdadero:
            // Turno del jugador 1
            Imprimir "Turno del Jugador 1:"
            Invocar al método jugarTurno() con jugador1 y tableroJugador2 como parámetros
        
            // Verificar si el jugador 1 ha ganado
            Si todos los barcos en el tableroJugador2 están hundidos:
                Imprimir "¡Jugador 1 ha ganado!"
                Romper el bucle
        
            // Turno del jugador 2
            Imprimir "Turno del Jugador 2:"
            Invocar al método jugarTurno() con jugador2 y tableroJugador1 como parámetros
        
            // Verificar si el jugador 2 ha ganado
            Si todos los barcos en el tableroJugador1 están hundidos:
                Imprimir "¡Jugador 2 ha ganado!"
                Romper el bucle
        
            // Verificar empate
            Si todos los barcos en ambos tableros están hundidos:
                Imprimir "¡Empate!"
                Romper el bucle
    
        Cerrar el scanner

Método configurarBarcos(scanner: Scanner, jugador: Jugador, tablero: Tablero):
    Para cada barco en los barcos del jugador:
        Pedir al jugador que introduzca la fila inicial, la columna inicial y la orientación del barco mediante el scanner
        Mientras no se pueda colocar el barco en el tablero:
            Pedir al jugador que introduzca nuevamente la fila inicial, la columna inicial y la orientación del barco mediante el scanner

Método jugarTurno(jugador: Jugador, tablero: Tablero):
    Realizar un ataque obteniendo las coordenadas con el método realizarAtaque() del jugador
    Obtener el resultado del ataque del tablero del oponente
    Actualizar el tablero del jugador con el resultado del ataque mediante el método actualizarTablero()


```
