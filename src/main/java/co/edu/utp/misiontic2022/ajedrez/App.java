package co.edu.utp.misiontic2022.ajedrez;

import juego_ajedrez.Alfil;
import juego_ajedrez.Caballo;
import juego_ajedrez.Color;
import juego_ajedrez.Peon;
import juego_ajedrez.Reina;
import juego_ajedrez.Rey;
import juego_ajedrez.Tablero;
import juego_ajedrez.Torre;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {       iniciarTablero();
    }
    private static void iniciarTablero () 
    {
        Tablero t = new Tablero();
        t.ubicarFicha(0,0,new Torre(Color.blanco));
        t.ubicarFicha(0,7,new Torre(Color.blanco));
        t.ubicarFicha(0,1,new Caballo(Color.blanco));
        t.ubicarFicha(0,6,new Caballo(Color.blanco));
        t.ubicarFicha(0,2,new Alfil(Color.blanco));
        t.ubicarFicha(0,5,new Alfil(Color.blanco));
        t.ubicarFicha(0,3,new Rey(Color.blanco));
        t.ubicarFicha(0,4,new Reina(Color.blanco));
        for(int i = 0; i< 8; i++) {
            t.ubicarFicha(1,1, new Peon(Color.blanco)); 
        }
        t.ubicarFicha(7,0,new Torre(Color.negro));
        t.ubicarFicha(7,7,new Torre(Color.negro));
        t.ubicarFicha(7,1,new Caballo(Color.negro));
        t.ubicarFicha(7,6,new Caballo(Color.negro));
        t.ubicarFicha(7,2,new Alfil(Color.negro));
        t.ubicarFicha(7,5,new Alfil(Color.negro));
        t.ubicarFicha(7,3,new Rey(Color.negro));
        t.ubicarFicha(7,4,new Reina(Color.negro));
        for(int i = 0; i< 8; i++) {
            t.ubicarFicha(6,1, new Peon(Color.negro)); 
        }
        System.out.println( "Hello World!" );
    }
    
}
