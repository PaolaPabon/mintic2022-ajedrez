package co.edu.utp.misiontic2022.c2.reto3.controller;

import java.sql.SQLException;
import java.util.List;

import co.edu.utp.misiontic2022.c2.reto3.model.dao.ComprasDeLiderDao;
import co.edu.utp.misiontic2022.c2.reto3.model.dao.PagadoPorProyectoDao;
import co.edu.utp.misiontic2022.c2.reto3.model.dao.ProyectoBancoDao;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.PagadoPorProyectoVo;
import co.edu.utp.misiontic2022.c2.reto3.model.vo.ProyectoBancoVo;

public class ReportesController {
    private ComprasDeLiderDao comprasDeLiderDao;
    private PagadoPorProyectoDao pagadoPorProyectoDao;
    private ProyectoBancoDao proyectoBancoDao;

    // constructor  

    public ReportesController() {
        this.comprasDeLiderDao = new ComprasDeLiderDao();
        this.pagadoPorProyectoDao = new PagadoPorProyectoDao();
        this.proyectoBancoDao = new ProyectoBancoDao();
    }

    // metodos

    public List<ComprasDeLiderVo> listadoComprasDeLider () throws SQLException {
        return comprasDeLiderDao.listarProyectosLiderCompras();
    }
    
    public List<PagadoPorProyectoVo> listadoPagosPorProyectos (Double limiteInferior) throws SQLException {
        return pagadoPorProyectoDao.listarProyectosPagados(limiteInferior);
    }

    public List<ProyectoBancoVo> listadoProyectoBanco (String banco) throws SQLException{
        return proyectoBancoDao.listarProyectosBancos (banco);
    } 
}
