package co.edu.utp.misiontic2022.c2.reto3.view;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.reto3.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ProyectosConsultaVo;

public class ConsultasView {
    private ConsultasController consultasController;

    public ConsultasView (){
        consultasController = new ConsultasController();

    }
    private String repitaCaracter (Character caracter, Integer veces) { 
        var respuesta = ""; 
        for (int i = 0; i < veces; i++) {
             respuesta += caracter; } 
            return respuesta;
        }

    public void imprimirProyectosCasasCampestresYCondominios() {
        try {
            System.out.println(repitaCaracter('=', 10) + " LISTADO DE PROYECTOS CLASIFICACION " + repitaCaracter('=', 10));
            System.out.println(String.format("%5s %-15s %7s %10s %10s", "CIUDAD", "CLASIFICICION", "TOTAL", "VIEJO", "RECIENTE"));
            System.out.println(repitaCaracter('-', 105));
            var lista = consultasController.listadoProyectosDeClasificaciones("Casa Campestre", "Condominio");
            for (ProyectosConsultaVo proyecto : lista) {
                System.out.printf("%5s %-15s %7s %10s %10s \n", proyecto.getCiudad(), proyecto.getClasificacion(), proyecto.getTotal(), proyecto.getViejo(), proyecto.getReciente());
            }
        } catch (SQLException e) {
            System.err.println("Error:" + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
