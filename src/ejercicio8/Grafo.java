package ejercicio8;

import java.util.*;

public class Grafo {
    private List<Nodo> nodos;

    public Grafo() {
        this.nodos = new ArrayList<Nodo>();
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    //Opción grafo completo
    public void addNodo(Nodo nodo) {
        if (!nodos.isEmpty()) {
            nodos.add(nodo);
        } else {
            for (Nodo n : nodos) {
                n.addArista(new Arista(1, nodo));
                nodo.addArista(new Arista(1, n));
            }
            nodos.add(nodo);
        }
    }

    //Opción grafo no completo
    public void addNodoGrafoNoCompleto(Nodo nodo) {
        nodos.add(nodo);
    }

    public boolean barridoEnProfundidad(Puerto puerto) {
        if (!puerto.getVisitado()) {
            puerto.setVisitado(true);
            for (Arista a : puerto.getAristas()) {
                if (!a.getDestino().getVisitado()) {
                    barridoEnProfundidad((Puerto) a.getDestino());
                }
            }
            System.out.println(puerto.getNombre() + " visitado.");
            return true;
        }
        return false;
    }

    public List<Puerto> caminoMasCorto(Puerto inicio, Puerto destino) {
        Map<Puerto, Integer> distancia = new HashMap<>();
        Map<Puerto, Puerto> predecesor = new HashMap<>();
        PriorityQueue<Puerto> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distancia::get));

        //Inicializar las distancias
        for (Nodo nodo : nodos) {
            distancia.put((Puerto) nodo, Integer.MAX_VALUE);
            predecesor.put((Puerto) nodo, null);
        }

        //Inicializar la distancia del nodo de inicio
        distancia.put(inicio, 0);
        colaPrioridad.add(inicio);

        //Algoritmo de Dijkstra
        //Mientras la cola de prioridad no esté vacía
        while (!colaPrioridad.isEmpty()) {
            //Saco de la cola el nodo con la menor distancia
            Puerto actual = colaPrioridad.poll();
            //Si el nodo actual es el nodo destino, termino
            if (actual == destino) {
                break;
            }

            //Para cada vecino del nodo actual
            for (Arista arista : actual.getAristas()) {
                Puerto vecino = (Puerto) arista.getDestino();
                //La nueva distancia es la distancia del nodo actual más la distancia de la arista
                int nuevaDistancia = distancia.get(actual) + arista.getDistancia();
                //Si a nueva distancia es menos a la distancia almacenada
                if (nuevaDistancia < distancia.get(vecino)) {
                    //La distancia del vecino desde el nodo de inicio es la nueva distancia
                    distancia.put(vecino, nuevaDistancia);
                    predecesor.put(vecino, actual);
                    //Agregar el vecino a la cola de prioridad
                    colaPrioridad.add(vecino);
                }
            }
        }

        List<Puerto> caminoOptimo = new ArrayList<>();
        Puerto nodo = destino;
        //Recorro el predecesor desde el nodo destino hasta el nodo inicio y lo almaceno en un array
        while (nodo != null) {
            caminoOptimo.add(nodo);
            nodo = predecesor.get(nodo);
        }

        //Le doy la vuelta al array para que quede en el orden correcto
        Collections.reverse(caminoOptimo);
        return caminoOptimo;
    }

    public boolean borrarPuertoConMasAristas() {
        int max = 0;
        Puerto puerto = null;
        //Busco el puerto con más aristas
        for (Nodo n : nodos) {
            if (n.getAristas().size() > max) {
                max = n.getAristas().size();
                puerto = (Puerto) n;
            }
        }

        //Si no había ningún puerto con aristas, retorno false
        if (puerto != null) {
            //Borro el puerto con más aristas de mi grafo/lista de nodos
            nodos.remove(puerto);
            //Busco en cada nodo si hay aristas que tengan como destino el puerto que quiero borrar
            for (Nodo n : nodos) {
                //Busco en cada arista del nodo si el destino es el puerto que quiero borrar
                for (Arista a : n.getAristas()) {
                    //Si el destino es el puerto que quiero borrar, borro la arista
                    if (a.getDestino().equals(puerto)) {
                        n.getAristas().remove(a);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
