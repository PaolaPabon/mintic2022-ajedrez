package co.edu.utp.misiontic2022.c2.reto3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    // atributos de clase para gestion de conexion con la base de datos
    private static final String UBICACION_DB = "ProyectosConstruccion.db";
    
    public  static Connection getConnection () throws SQLException {
        String url = "jdbc:sqlite:"+UBICACION_DB;
        return DriverManager.getConnection(url); 
    }
}