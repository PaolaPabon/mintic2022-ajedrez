package juego_ajedrez;

import java.text.spi.CollatorProvider;

public class Casilla {
    // Atributos
    private final Color color;
    private final Integer columna;
    private final Integer fila;

    private Ficha ficha;
    // esta forma representa la relacion de asociacion

    // Constructores
    public Casilla(Integer columna, Integer fila) {
        this.columna = columna;
        this.fila = fila;
        this.color = (fila + columna) % 2 == 0 ? Color.blanco : Color.negro;
    }

    // Metodos

    public Boolean ocupada() {
        boolean hayficha;
        if (ficha != null) {
            hayficha = true;
        } else {
            hayficha = false;
        }
        return hayficha;
    }

    public void ubicarFicha(Ficha ficha) {
        this.ficha = ficha;
        this.ficha.setCasilla(this;
    }

    public Ficha obtnerFicha() {
        return ficha;
    }

    public void retirarFicha() {
        this.ficha = null;
    }

    @Override
    public String toString() {
        return "Casilla [color=" + color + ", fila=" + fila + ",columna=" + columna + "]";
    }

}
