package co.edu.utp.misiontic2022.reto2;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Vehiculo {
    // Atributos
    private String marca;
    private String modelo;
    private Double precioBase;
    private Automovil vehiculo;

    // Constructor
    public Vehiculo(String marca, String modelo, Double precioBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;

    }
    // Metodo

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Double calcularDescuento(Date fecha) {
        var cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        var mes = cal.get(Calendar.MONTH);
        var descuento = 0d;
        if (marca == "Mazda" && mes == Calendar.MAY) {
            descuento = calcularPrecio() * 0.1;
        } 
        else if (mes == Calendar.JUNE && marca == "BMW") {
          if (vehiculo instanceof Automovil) {
            descuento = calcularPrecio() * 0.05;
           } else {
            descuento = calcularPrecio() * 0.1;
           }
        }
        return descuento;
    }

    public abstract Double calcularPrecio();

    public abstract Double calcularPorcentajeImpuesto();

}
