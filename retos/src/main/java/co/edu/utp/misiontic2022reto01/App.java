package co.edu.utp.misiontic2022reto01;

import jdk.jshell.EvalException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Double valor = 35000000.0;
        Integer tiempo = 12;

        EvaluarCreditoVehiculo evaluar = new EvaluarCreditoVehiculo();
        String eleccion = evaluar.compararOpcion(valor, tiempo);
        System.out.println(eleccion);

    }     
        
}
