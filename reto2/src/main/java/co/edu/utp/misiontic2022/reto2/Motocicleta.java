package co.edu.utp.misiontic2022.reto2;



public class Motocicleta extends Vehiculo{
    // Atributo
    private Integer cilindraje;  
    
    // Constructor
    public Motocicleta(String marca, String modelo, Double precioBase, Integer cilindraje) {
        super(marca, modelo, precioBase);
        this.cilindraje = cilindraje;
        }
    
    // Metodo
    public Integer getCilindraje() {
        return cilindraje;
    }
    public void setCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
    }
    
    @Override
    public Double calcularPrecio() { 
        if (cilindraje >= 150 && cilindraje <= 300) {
            var preciovehiculo = super.getPrecioBase() + 400000;
            return preciovehiculo;
        }
        else if (cilindraje >= 301 && cilindraje <= 600) {
            var preciovehiculo  = super.getPrecioBase()+ 800000;
            return preciovehiculo;
        }
        else if (cilindraje >= 601) {
            var preciovehiculo = super.getPrecioBase()+ 1200000;
            return preciovehiculo;
        }
        else {var preciovehiculo = super.getPrecioBase();
            return preciovehiculo; }
            
    }
    @Override
    public Double calcularPorcentajeImpuesto() {
        
        Double impuestos = (calcularPrecio() > 6100000) ? calcularPrecio()*0.19:0;
        return impuestos;
    } 
    
}
