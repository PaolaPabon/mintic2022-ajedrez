package co.edu.utp.misiontic2022.c2.reto3;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.reto3.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.reto3.model.dao.ComprasDeLiderDao;
import co.edu.utp.misiontic2022.c2.reto3.model.dao.PagadoPorProyectoDao;
import co.edu.utp.misiontic2022.c2.reto3.model.dao.ProyectoBancoDao;
import co.edu.utp.misiontic2022.c2.reto3.model.dao.ProyectosConsultaDao;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.PagadoPorProyectoVo;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ProyectoBancoVo;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ProyectosConsultaVo;
import co.edu.utp.misiontic2022.c2.reto3.view.ConsultasView;

public class App {
    public static void main(String[] args) {

        try {
            var dao = new ComprasDeLiderDao();
            var lista = dao.listarProyectosLiderCompras();
            for (ComprasDeLiderVo consulta : lista) {
                System.out.println(consulta);
            }
            
        } catch (SQLException e) {
            System.err.println("Error:" + e);
            e.printStackTrace();
        }
        
        // var view = new ConsultasView();
        //view.imprimirProyectosCasasCampestresYCondominios();           
         
    }
}
