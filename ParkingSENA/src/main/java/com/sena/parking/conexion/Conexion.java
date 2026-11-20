
package com.sena.parking.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/ParkingSENA?useSSL=false&serverTimezone=UTC";

    private static final String USUARIO = "root";

    public static Connection obtenerConexion() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el controlador de MySQL.", e);
        }

        String password = System.getenv("PARKINGSENA_DB_PASSWORD");

        if (password == null || password.isBlank()) {
            throw new SQLException("No se ha configurado la contraseña de MySQL.");
        }

        return DriverManager.getConnection(URL, USUARIO, password);
    }
}
