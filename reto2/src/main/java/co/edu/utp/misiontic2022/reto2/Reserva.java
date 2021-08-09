package co.edu.utp.misiontic2022.reto2;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Reserva {
    // Atributos
    private Date fecha;
    private String cliente;
    
    private List<Vehiculo> vehiculos;
    
    // Constructor
    public Reserva(Date fecha, String cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
        
        this.vehiculos = new ArrayList<>();
    }
                
    // Metodo    
    public String getCliente() {
        return cliente;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void adicionarVehiculo (Vehiculo Vehiculo) {
        vehiculos.add(Vehiculo); 
    }

    public  Integer calcularCantidadVehiculos() {
        var numVehiculos = vehiculos.size();
        return numVehiculos;
    }
    public Double calcularSubtotal () {
        Double subtotal = 0d;
        for(Vehiculo vehiculo:vehiculos){
        subtotal = subtotal + vehiculo.calcularPrecio();
        }
        return subtotal;
    }

    public Double calcularDescuentos () {
        Double totaldescuentos = 0d;
        for(Vehiculo vehiculo:vehiculos){
        totaldescuentos = totaldescuentos + vehiculo.calcularDescuento(fecha);}
        return totaldescuentos;
    }
    public Double calcularImpuestos () {
        Double totalimpuestos = 0d;
        for(Vehiculo vehiculo:vehiculos){       
        totalimpuestos = totalimpuestos + vehiculo.calcularPorcentajeImpuesto()-vehiculo.calcularDescuento(fecha)*0.19;}
        return totalimpuestos;
    }
    public Double calcularTotal () {

        return calcularSubtotal()-calcularDescuentos()+calcularImpuestos();
    }

}
