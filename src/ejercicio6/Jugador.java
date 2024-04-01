package ejercicio6;

import ejercicio5.*;
import java.util.Random;

public class Jugador {
    private Tablero tablero;
    private Barco[] barcos;

    public Jugador() {
        tablero = new Tablero(10); //Suponiendo que es un tablero de 10x10
        barcos = new Barco[3]; //Suponiendo que cada jugador tiene 3 barcos
        //Inicializar los barcos del jugador
        barcos[0] = new Battleship();
        barcos[1] = new Frigate();
        barcos[2] = new Canoe();
    }

    public int[] realizarAtaque() {
        Random random = new Random();
        int fila = random.nextInt(10); //Generar fila aleatoria (0-9)
        int columna = random.nextInt(10); //Generar columna aleatoria (0-9)
        return new int[] {fila, columna};
    }

    public void actualizarTablero(int[] ataque, boolean impacto) {
        int fila = ataque[0];
        int columna = ataque[1];
        if (impacto) {
            System.out.println("¡Has impactado un barco en la fila " + fila + " columna " + columna + "!");
        } else {
            System.out.println("No has impactado ningún barco en la fila " + fila + " columna" + columna + ".");
        }
    }

    public Barco getBarco(int index) {
        return barcos[index];
    }
}
