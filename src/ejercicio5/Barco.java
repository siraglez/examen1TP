package ejercicio5;

public class Barco {
    protected int tamanio;
    protected boolean[] impactos;

    public Barco(int tamanio) {
        this.tamanio = tamanio;
        this.impactos = new boolean[tamanio];
    }

    public boolean estaHundido() {
        for (boolean impacto : impactos) {
            if (!impacto) {
                return false;
            }
        }
        return true;
    }

    public void recibirImpacto(int posicion) {
        if (posicion >= 0 && posicion < tamanio) {
            impactos[posicion] = true;
        }
    }
}
