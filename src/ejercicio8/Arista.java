package ejercicio8;

public class Arista {
    private int distancia;
    private Nodo destino;

    public Arista(int distancia) {
        this.distancia = distancia;
        this.destino = null;
    }

    public Arista(int distancia, Nodo destino) {
        this.distancia = distancia;
        this.destino = destino;
    }

    public int getDistancia() {
        return this.distancia;
    }

    public Nodo getDestino() {
        return this.destino;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }
}
