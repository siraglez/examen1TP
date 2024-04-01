package ejercicio8;

import java.util.ArrayList;
import java.util.List;

public abstract class Nodo {
    private List<Arista> aristas;
    private static int id = 0;
    private boolean visitado;

    public Nodo() {
        this.aristas = new ArrayList<Arista>();
        this.visitado = false;
        id++;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public List<Arista> getAristas() {
        return this.aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Nodo.id = id;
    }

    public void addArista(Arista arista) {
        this.aristas.add(arista);
    }

    @Override
    public String toString() {
        return "Nodo{" + "id=" + id + ", aristas=" + aristas + ", visitado=" + visitado + '}';
    }
}
