package co.edu.utp.misiontic2022.c2.reto3;


import co.edu.utp.misiontic2022.c2.reto3.view.ReportesView;

public class App {
    public static void main(String[] args) {
        
        var reportesView = new ReportesView();
        var banco = "Davivienda"; 
        reportesView.proyectosFinanciadosPorBanco(banco);
        
        //var limiteInferior = 50_000d;
        //reportesView.totalPagadoPorProyectosSuperioresALimite(limiteInferior);
        
        //reportesView.lideresQueMenosGastan();
       
    }
}
