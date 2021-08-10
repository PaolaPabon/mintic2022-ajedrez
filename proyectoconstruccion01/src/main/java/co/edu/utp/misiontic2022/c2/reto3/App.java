package co.edu.utp.misiontic2022.c2.reto3;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.reto3.util.JDBCUtilities;

public class App {
    public static void main(String[] args) {

        try {
            var conn = JDBCUtilities.getConnection();
            System.out.println("Motita feliz");
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
            e.printStackTrace();
        }

    }
}
