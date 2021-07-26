package juego_ajedrez;

public abstract class Ficha implements ElementoMovil {
    // Atributos
    private final Color color;
    private Casilla casilla;
    // de esta manera se representa la relacion de asociacion
    // Constructor
    public Ficha(Color color) {
        this.color = color;
    }
    
    // Metodos
    
    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public Boolean capturar() {
        return null;
    }

    
    

    // public abstract Boolean mover();
    // el metodo lo definimos como abstracto porque no sabemos como se va a
    // comportar
    // se elimana el metodo porque se creo el metodo en la interface ElementoMovil
}
