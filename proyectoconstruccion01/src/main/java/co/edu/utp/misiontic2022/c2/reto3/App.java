package co.edu.utp.misiontic2022.c2.reto3;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.reto3.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.reto3.model.dao.ProyectosConsultaDao;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ProyectosConsultaVo;

public class App {
    public static void main(String[] args) {

        try {
            var controller = new ConsultasController();
            var lista = controller.listadoProyectosDeClasificaciones("Casa Campestre", "Condominio");
            for (ProyectosConsultaVo consulta: lista) {
                System.out.println(consulta);
            }
                       
        } catch (SQLException e) {
            System.err.println("Error:" + e);
            e.printStackTrace();
        }

    }
}
