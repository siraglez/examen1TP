package ejercicio5;

public class Tablero {
    private int tamanio;
    private Barco[][] cuadricula;

    public Tablero(int tamanio) {
        this.tamanio = tamanio;
        cuadricula = new Barco[tamanio][tamanio];
    }

    public boolean colocarBarco(Barco barco, int fila, int columna, boolean horizontal) {
        if (fila < 0 || fila >= tamanio || columna < 0 || columna >= tamanio) {
            return false;
        }

        int finColumna = horizontal ? columna + barco.tamanio - 1 : columna;
        int finFila = horizontal ? fila : fila + barco.tamanio - 1;

        if (finColumna >= tamanio || finFila >= tamanio) {
            return false;
        }

        for (int i = fila; i <= finFila; i++) {
            for (int j = columna; j <= finColumna; j++) {
                if (cuadricula[i][j] != null) {
                    return false;
                }
            }
        }

        for (int i = fila; i <= finFila; i++) {
            for (int j = columna; j <= finColumna; j++) {
                cuadricula[i][j] = barco;
            }
        }
        return true;
    }

    public boolean atacar(int fila, int columna) {
        if (fila < 0 || fila >= tamanio || columna < 0 || columna >= tamanio) {
            return false;
        }

        if (cuadricula[fila][columna] != null) {
            cuadricula[fila][columna].recibirImpacto(fila);
            return true;
        }
        return false;
    }

    public boolean todosBarcosHundidos() {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                Barco barco = cuadricula[i][j];
                if (barco != null && !barco.estaHundido()) {
                    return false;
                }
            }
        }
        return true;
    }
}
