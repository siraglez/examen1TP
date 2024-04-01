package ejercicio5;

public class Battleship extends Barco {
    private boolean[] contenedoresAislados;

    public Battleship() {
        super(5);
        contenedoresAislados = new boolean[5]; //Suponiendo que todos los contenedores están inicialmente aislados
    }

    public void recibirImpacto(int posicion, boolean aislado) {
        if (aislado) {
           contenedoresAislados[posicion] = true;
           if (todosContenedoresAisladosImpactados()) {
               for (int i = 0; i < tamanio; i++) {
                   impactos[i] = true;
               }
           }
        } else {
            super.recibirImpacto(posicion);
        }
    }

    private boolean todosContenedoresAisladosImpactados() {
        for (boolean impacto : contenedoresAislados) {
            if (!impacto) {
                return false;
            }
        }
        return true;
    }
}
