package co.edu.utp.misiontic2022.c2.reto3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.reto3.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.reto3.util.JDBCUtilities;

public class ComprasDeLiderDao {

    public List<ComprasDeLiderVo> listarProyectosLiderCompras () throws SQLException{
        
        List<ComprasDeLiderVo> respuesta3 = new ArrayList<>();
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {
            var query = "SELECT (L.NOMBRE ||' '||L.PRIMER_APELLIDO ||' '||L.SEGUNDO_APELLIDO) LIDER, SUM(C.CANTIDAD * MC.PRECIO_UNIDAD) VALOR"
                    + " FROM LIDER L" 
                    + " JOIN PROYECTO P ON (L.ID_LIDER = P.ID_LIDER)" 
                    + " JOIN COMPRA C ON (P.ID_PROYECTO = C.ID_PROYECTO)" 
                    + " JOIN MATERIALCONSTRUCCION MC ON (C.ID_MATERIALCONSTRUCCION = MC.ID_MATERIALCONSTRUCCION)" 
                    + " GROUP BY LIDER"
                    + " ORDER BY VALOR"
                    + " LIMIT 10 ";

            stmt = conn.prepareStatement(query);
            rset = stmt.executeQuery();

            while (rset.next()){
                var vo = new ComprasDeLiderVo();
                vo.setLider(rset.getString("lider"));
                vo.setValor(rset.getDouble("valor"));

                respuesta3.add(vo);
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

            return respuesta3;
    }
    
}
