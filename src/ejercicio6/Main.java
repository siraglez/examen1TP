package ejercicio6;

import ejercicio5.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Crear los jugadores
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        //Crear tableros para cada jugador
        Tablero tableroJugador1 = new Tablero(10);
        Tablero tableroJugador2 = new Tablero(10);

        //Configuración de los barcos por parte de cada jugador
        System.out.println("Jugador 1, introduce la configuración de tus barcos: ");
        configurarBarcos(scanner, jugador1, tableroJugador1);

        System.out.println("Jugador 2, introduce la configuración de tus barcos: ");
        configurarBarcos(scanner, jugador2, tableroJugador2);

        //Comienza el juego
        while (true) {
            //Turno del jugador 1
            System.out.println("Turno del Jugador 1: ");
            jugarTurno(jugador1, tableroJugador2);

            //Verificar si el jugador 1 ha ganado
            if (tableroJugador2.todosBarcosHundidos()) {
                System.out.println("¡Jugador 1 ha ganado!");
                break;
            }

            //Turno del jugador 2
            System.out.println("Turno del Jugador 2: ");
            jugarTurno(jugador2, tableroJugador1);

            //Verificar si el jugador 2 ha ganado
            if (tableroJugador1.todosBarcosHundidos()) {
                System.out.println("¡Jugador 2 ha ganado!");
                break;
            }

            //Verificar si hay empate
            if (tableroJugador1.todosBarcosHundidos() && tableroJugador2.todosBarcosHundidos()) {
                System.out.println("¡Empate!");
                break;
            }
        }

        scanner.close();
    }

    //Método para configurar los barcos de un jugador
    private static void configurarBarcos(Scanner scanner, Jugador jugador, Tablero tablero) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Configuración del barco " + (i + 1) + ":");
            System.out.println("Fila inicial: ");
            int fila = scanner.nextInt();
            System.out.println("Columna inicial: ");
            int columna = scanner.nextInt();
            System.out.println("Horizontal (true/false): ");
            boolean horizontal = scanner.nextBoolean();

            //Colocar el barco en el tablero del jugador
            boolean colocado = false;
            while (!colocado) {
                if (tablero.colocarBarco(jugador.getBarco(i), fila, columna, horizontal)) {
                    colocado = true;
                } else {
                    System.out.println("Ubicación inválida, intenta nuevamente.");
                    System.out.println("Fila inicial: ");
                    fila = scanner.nextInt();
                    System.out.println("Columna inicial: ");
                    columna = scanner.nextInt();
                    System.out.println("Horizontal (true/false): ");
                    horizontal = scanner.nextBoolean();
                }
            }
        }
    }

    //Método para que un jugador juegue su turno
    private static void jugarTurno(Jugador jugador, Tablero tablero) {
        int[] ataque = jugador.realizarAtaque();
        boolean impacto = tablero.atacar(ataque[0], ataque[1]);
        jugador.actualizarTablero(ataque, impacto);
    }
}
