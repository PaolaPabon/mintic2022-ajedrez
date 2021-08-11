package co.edu.utp.misiontic2022.c2.reto3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.reto3.model.vo.ProyectosConsultaVo;
import co.edu.utp.misiontic2022.c2.reto3.util.JDBCUtilities;

public class ProyectosConsultaDao {
    // gestiona la peticion de conexion a la base de datos realiza la consulta
    public List<ProyectosConsultaVo> listarProyectosPorClasificaciones(String clasificacion1, String clasificacion2)
            throws SQLException {

        List<ProyectosConsultaVo> respuesta = new ArrayList<>();
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            var query = "SELECT CIUDAD, CLASIFICACION, COUNT(CIUDAD) TOTAL, MIN(Fecha_Inicio) VIEJO, MAX(Fecha_Inicio) RECIENTE"
                    + " FROM PROYECTO P " 
                    + " WHERE CLASIFICACION = (?) OR CLASIFICACION = (?)"
                    + " GROUP BY CIUDAD , CLASIFICACION" 
                    + " ORDER BY CIUDAD , CLASIFICACION";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, clasificacion1);
            stmt.setString(2, clasificacion2);
            rset = stmt.executeQuery();

            while (rset.next()) {
                var vo = new ProyectosConsultaVo();
                vo.setCiudad(rset.getString("Ciudad"));
                vo.setClasificacion(rset.getString("Clasificacion"));
                vo.setTotal(rset.getInt("TOTAL"));
                vo.setViejo(rset.getString("VIEJO"));
                vo.setReciente(rset.getString("RECIENTE"));

                respuesta.add(vo);
            }
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return respuesta;
    }

}
