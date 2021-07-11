package juego_ajedrez;

public abstract class Ficha implements ElementoMovil {
    // Atributos
    private Color color;

    // Metodos
    public Boolean capturar() {
        return null;
    }

    // public abstract Boolean mover();
    // el metodo lo definimos como abstracto porque no sabemos como se va a
    // comportar
    // se elimana el metodo porque se creo el metodo en la interface ElementoMovil
}
