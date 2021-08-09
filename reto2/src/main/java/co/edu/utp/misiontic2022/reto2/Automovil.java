package co.edu.utp.misiontic2022.reto2;

public class Automovil extends Vehiculo{
    // Atributo
    private TipoTransmision transmision;
    private Boolean vidriosElectricos;
    private Boolean aireAcondicionado;
   
    // Constructor
    public Automovil(String marca, String modelo,Double precioBase, TipoTransmision transmision, Boolean vidriosElectricos, Boolean aireAcondicionado) {
        super(marca, modelo, precioBase);
        this.transmision = transmision;
        this.vidriosElectricos = vidriosElectricos;
        this.aireAcondicionado = aireAcondicionado;}
    
        // Metodo  
    @Override
    public Double calcularPrecio() {
        var incrementotransmision = transmision == TipoTransmision.AUTOMATICA ? super.getPrecioBase()*0.07: 0;
        
        var incrementovidrios = vidriosElectricos == true ? 300000 : 0;

        var incrementoaireacondicionado = aireAcondicionado == true ? 2500000 : 0;
        
        var preciovehiculo = super.getPrecioBase()+incrementotransmision+incrementovidrios+incrementoaireacondicionado;

        return preciovehiculo;
    } 
    @Override
    public Double calcularPorcentajeImpuesto() { 
        
        var impuestos = calcularPrecio() > 80000000 ? calcularPrecio()*0.19: 0;
        
        return impuestos; 
    }

}
