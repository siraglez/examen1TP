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
