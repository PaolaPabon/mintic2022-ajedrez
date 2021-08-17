package co.edu.utp.misiontic2022.c2.reto3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.reto3.model.vo.PagadoPorProyectoVo;
import co.edu.utp.misiontic2022.c2.reto3.util.JDBCUtilities;

public class PagadoPorProyectoDao {
    
    public List<PagadoPorProyectoVo> listarProyectosPagados (Double limiteInferior) throws SQLException{
        
        List<PagadoPorProyectoVo> respuesta2 = new ArrayList<>();
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        
        try {
            var query = "SELECT ID_proyecto AS ID, SUM(Cantidad * precio_unidad) AS VALOR " 
            + " FROM Compra c"+ " NATURAL JOIN MaterialConstruccion mc" + " WHERE Pagado = ('Si')" + " GROUP BY ID" + " HAVING VALOR > (?)" + " ORDER BY VALOR DESC";

            stmt = conn.prepareStatement(query);
            stmt.setDouble(1, limiteInferior);
            rset = stmt.executeQuery();

            while (rset.next()){
                var vo = new PagadoPorProyectoVo();
                vo.setId(rset.getInt("id"));
                vo.setValor(rset.getDouble("valor"));
                
                respuesta2.add(vo);
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
            return respuesta2;      
    }
}
