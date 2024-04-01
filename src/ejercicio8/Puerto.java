package ejercicio8;

public class Puerto extends Nodo {
    private String nombre;

    public Puerto(String nombre) {
        super();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Puerto{" + "nombre='" + nombre + '\'' + "} " + super.toString();
    }
}
