package ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Puerto puerto1 = new Puerto("Madero");
        Puerto puerto2 = new Puerto("Rodas");
        Puerto puerto3 = new Puerto("Algeciras");
        Puerto puerto4 = new Puerto("Barcelona");

        grafo.addNodo(puerto1);
        grafo.addNodo(puerto2);
        grafo.addNodo(puerto3);
        grafo.addNodo(puerto4);

        List<Arista> aristas = new ArrayList<>();
        aristas.add(new Arista(230, puerto2));
        aristas.add(new Arista(75, puerto3));
        aristas.add(new Arista(17, puerto4));
        puerto1.setAristas(aristas);

        List<Arista> aristas2 = new ArrayList<>();
        aristas2.add(new Arista(230, puerto1));
        aristas2.add(new Arista(560, puerto3));
        aristas2.add(new Arista(7, puerto4));
        puerto2.setAristas(aristas2);

        List<Arista> aristas3 = new ArrayList<>();
        aristas3.add(new Arista(75, puerto1));
        aristas3.add(new Arista(560, puerto2));
        aristas3.add(new Arista(1000, puerto4));
        puerto3.setAristas(aristas3);

        List<Arista> aristas4 = new ArrayList<>();
        aristas4.add(new Arista(17, puerto1));
        aristas4.add(new Arista(7, puerto2));
        aristas4.add(new Arista(1000, puerto3));
        puerto4.setAristas(aristas4);

        grafo.barridoEnProfundidad((Puerto) grafo.getNodos().get(0));
        System.out.println(grafo.caminoMasCorto(puerto1, puerto2));
    }
}
