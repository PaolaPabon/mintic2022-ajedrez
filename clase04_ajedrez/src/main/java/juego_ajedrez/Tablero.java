package juego_ajedrez;

public class Tablero {
    // Atributos
    private Casilla[] casillas = new Casilla[64];

    // constructores
    public Tablero() {
        // inicializo variables en los constructores
        casillas = new Casilla[64];
        for (int i = 0; i < casillas.length; i++) {
            int fila = i / 8;
            int columna = i % 8;
            casillas[i] = new Casilla(fila, columna);
        }

    }

    // Metodos
    public void ubicarFicha (Integer fila, Integer columna, Ficha ficha){
        casillas[8 * fila + columna].ubicarFicha(ficha);
    }
    
    public Boolean enroque() {
        return null;
    }

    public Boolean jaque() {
        return null;
    }

    public Boolean jaquemate() {
        return null;
    }

}
