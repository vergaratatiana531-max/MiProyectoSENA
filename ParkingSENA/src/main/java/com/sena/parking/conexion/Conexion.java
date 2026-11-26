package com.sena.parking.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
        "jdbc:mysql://localhost:3306/ParkingSENA?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER = "root";

    public static Connection obtenerConexion() throws SQLException {
        String password = System.getenv("PARKINGSENA_DB_PASSWORD");

        if (password == null || password.isEmpty()) {
            throw new SQLException("Falta configurar PARKINGSENA_DB_PASSWORD");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el controlador de MySQL", e);
        }

        return DriverManager.getConnection(URL, USER, password);
    }

    public static Connection conectar() throws SQLException {
        return obtenerConexion();
    }
}
