package co.edu.utp.misiontic2022.c2.reto3.view;

import java.sql.SQLException;
import java.text.DecimalFormat;

import co.edu.utp.misiontic2022.c2.reto3.controller.ReportesController;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.PagadoPorProyectoVo;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ProyectoBancoVo;

public class ReportesView {    
    
    private ReportesController reportesController;

    public ReportesView() {
        reportesController = new ReportesController();
    }

    private String repitaCaracter(Character caracter, Integer veces) {
         var respuesta = ""; 
         for (int i = 0; i < veces; i++) { 
             respuesta += caracter; 
            } 
            return respuesta; 
        } 
        
        public void proyectosFinanciadosPorBanco(String banco) { 
            try  {
                System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO " + repitaCaracter('=', 37)); 
                if (banco != null && !banco.isBlank()) { 
                System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER")); 
                System.out.println(repitaCaracter('-', 105)); 
                }    
                var lista1 = reportesController.listadoProyectoBanco(banco);
                for (ProyectoBancoVo proyecto : lista1) {
    
                    System.out.printf("%3s %-25s %-20s %-18s %-4s %-30s \n", proyecto.getId(),proyecto.getConstructora(), proyecto.getCiudad(), proyecto.getClasificacion(), proyecto.getEstrato(), proyecto.getLider());
                }
    
                } catch (SQLException e){
                    System.err.println("Error:"+ e.getMessage());
                    e.printStackTrace();
                }   
        } 
        
    public void totalPagadoPorProyectosSuperioresALimite(Double limiteInferior) { 
        try {        
        System.out.println(repitaCaracter('=', 1) + " TOTAL PAGADO POR PROYECTO " + repitaCaracter('=', 1)); 
        if (limiteInferior != null) { 
            System.out.println(String.format("%3s %14s", "ID", "VALOR ")); 
            System.out.println(repitaCaracter('-', 29));
            
            var lista2 = reportesController.listadoPagosPorProyectos(limiteInferior);
            for (PagadoPorProyectoVo proyecto: lista2){
                DecimalFormat df = new DecimalFormat("###,###.0");

                System.out.printf("%3s %15s \n", proyecto.getId(), df.format(proyecto.getValor()));
            }
         }
        } catch (SQLException e){
            System.err.println("Error:"+ e.getMessage());
            e.printStackTrace();
        } 
    } 
         
    public void lideresQueMenosGastan() {
        try {
         System.out.println(repitaCaracter('=', 5) + " 10 LIDERES MENOS COMPRADORES " + repitaCaracter('=', 6)); 
         System.out.println(String.format("%-25s %14s", "LIDER", "VALOR ")); 
         System.out.println(repitaCaracter('-', 41)); 

         var lista3 = reportesController.listadoComprasDeLider();
         
         for (ComprasDeLiderVo proyecto : lista3) {
            DecimalFormat df = new DecimalFormat("###,###.0");
            
             System.out.printf("%-25s %15s \n", proyecto.getLider(), df.format(proyecto.getValor()));
         }
         
        } catch (SQLException e){
            System.err.println("Error:"+ e.getMessage());
            e.printStackTrace();
        }
         
    }
}
