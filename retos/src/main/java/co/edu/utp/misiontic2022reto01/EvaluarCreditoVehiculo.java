package co.edu.utp.misiontic2022reto01;


public class EvaluarCreditoVehiculo {
    // identifica la mejor opcion de credito comparando los intereses en cada opcion
    // atributos
    Double valor;
    Integer tiempo;
    
    // Constructor
    
    
    // metodos
    
    public static void main( String[] args ) {
        Double valor = 1000000.0;
        Integer tiempo = 1;

        EvaluarCreditoVehiculo evaluar = new EvaluarCreditoVehiculo();
        String eleccion = evaluar.compararOpcion(valor, tiempo);
        System.out.println(eleccion);
    }  
    
    private  Double calcularInteresSimple(Double valor, Integer tiempo) {
        Double interes = 2.5/100;

        var interessimple = valor*interes*tiempo;  
       
        return interessimple;
      
    }
    private Double calcularInteresCompuesto  (Double valor, Integer tiempo){
        Double interes = 2.2/100;

        var interescompuesto = (Math.pow((1+interes),tiempo)-1)*valor;
        
        return interescompuesto;
    }

    public String compararOpcion(Double valor, Integer tiempo) {
       var is = calcularInteresSimple (valor,tiempo);
       var ic = calcularInteresCompuesto(valor, tiempo);

       String eleccioncredito = (is <= ic) ? "credito especial" : "credito estandar";
       
       return eleccioncredito; 
    }
}
