package ejercicio7;

import java.util.Hashtable;

public class TablasBarcos {
    private final Hashtable<TipoBarco, Hashtable<Integer, Barco>> tablaTipoBarco;
    private final Hashtable<Integer, Hashtable<Integer, Barco>> tablaNumeroBarco;
    private final Hashtable<String, Hashtable<String, Barco>> tablaNombreBarco;

    public TablasBarcos() {
        this.tablaTipoBarco = new Hashtable<TipoBarco, Hashtable<Integer, Barco>>();
        this.tablaNumeroBarco = new Hashtable<Integer, Hashtable<Integer, Barco>>();
        this.tablaNombreBarco = new Hashtable<String, Hashtable<String, Barco>>();
    }

    public int hashTipoBarco(TipoBarco tipo) {
        return tipo.hashCode() % tablaTipoBarco.size();
    }

    public int hashNumeroBarco(int numero) {
        return numero % tablaNumeroBarco.size();
    }

    public int hashNombreBarco(String nombre) {
        return nombre.hashCode() % tablaNombreBarco.size();
    }

    public void agregarBarco(Barco barco) {
        //Agrega un barco a las tres tablas hash
        int indice_tipo_barco = hashTipoBarco(barco.tipo);
        int indice_numero_barco = hashNumeroBarco(barco.numero);
        int indice_nombre_barco = hashNombreBarco(barco.nombre);

        //Agregar a la primera tabla de hash (tipo de barco)
        if (!tablaTipoBarco.containsKey(barco.tipo)) {
            tablaTipoBarco.put(barco.tipo, new Hashtable<>());
        }
        tablaTipoBarco.get(barco.tipo).put(barco.numero, barco);

        //Agregar a la segunda tabla hash (número de barco)
        if (!tablaNumeroBarco.containsKey(barco.numero)) {
            tablaNumeroBarco.put(barco.numero, new Hashtable<>());
        }
        tablaNumeroBarco.get(barco.numero).put(Integer.valueOf(barco.nombre), barco);

        //Agregar a la tercera tabla hash (nombre de barco)
        if (!tablaNombreBarco.containsKey(barco.nombre)) {
            tablaNombreBarco.put(barco.nombre, new Hashtable<>());
        }
        tablaNombreBarco.get(barco.nombre).put(String.valueOf(barco.numero), barco);
    }
}
