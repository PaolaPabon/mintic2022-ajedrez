package co.edu.utp.misiontic2022.c2.reto3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.c2.reto3.model.vo.ProyectoBancoVo;
import co.edu.utp.misiontic2022.c2.reto3.util.JDBCUtilities;

public class ProyectoBancoDao {

    public List<ProyectoBancoVo> listarProyectosBancos (String banco) throws SQLException{

        List <ProyectoBancoVo> respuesta1 = new ArrayList<>();
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {
            var query = "SELECT ID_PROYECTO ID, CONSTRUCTORA, CIUDAD, P.CLASIFICACION, ESTRATO, NOMBRE ||' '||PRIMER_APELLIDO ||' '||SEGUNDO_APELLIDO LIDER"+ " FROM PROYECTO P "+ " JOIN TIPO T ON (P.ID_TIPO = t.ID_Tipo)"+ " JOIN LIDER L ON (P.ID_LIDER=L.ID_LIDER)"+ " WHERE BANCO_VINCULADO = (?)"+ " ORDER BY FECHA_INICIO DESC, CIUDAD ASC, CONSTRUCTORA ASC";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, banco);
            rset =stmt.executeQuery();

            while(rset.next()) {
                var vo = new ProyectoBancoVo();
                vo.setId(rset.getInt("id"));
                vo.setConstructora(rset.getString("Constructora"));
                vo.setCiudad(rset.getString("Ciudad"));
                vo.setClasificacion(rset.getString("Clasificacion"));
                vo.setEstrato(rset.getInt("Estrato"));
                vo.setLider(rset.getString("Lider"));

                respuesta1.add(vo);
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
            
            return respuesta1;
        }
}
