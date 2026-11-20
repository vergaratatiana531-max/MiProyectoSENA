package com.sena.parking.dao;

import com.sena.parking.conexion.Conexion;
import com.sena.parking.modelo.Vehiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    public List<Vehiculo> listar() throws SQLException {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM parque ORDER BY id_parque";

        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vehiculo v = new Vehiculo();
                v.setIdParque(rs.getInt("id_parque"));
                v.setPlaca(rs.getString("placa"));
                v.setNumeroSerie(rs.getString("numeroSerie"));
                v.setModelo(rs.getString("modelo"));
                v.setMarca(rs.getString("marca"));
                v.setKilometraje(rs.getDouble("kilometraje"));
                v.setTipo(rs.getString("tipo"));
                v.setIdCliente(rs.getInt("id_cliente"));
                vehiculos.add(v);
            }
        }
        return vehiculos;
    }

    public boolean insertar(Vehiculo v) throws SQLException {
        String sql = "INSERT INTO parque "
                + "(placa, numeroSerie, modelo, marca, kilometraje, tipo, id_cliente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, v.getPlaca());
            ps.setString(2, v.getNumeroSerie());
            ps.setString(3, v.getModelo());
            ps.setString(4, v.getMarca());
            ps.setDouble(5, v.getKilometraje());
            ps.setString(6, v.getTipo());
            ps.setInt(7, v.getIdCliente());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean actualizar(Vehiculo v) throws SQLException {
        String sql = "UPDATE parque SET placa=?, numeroSerie=?, "
                + "modelo=?, marca=?, kilometraje=?, tipo=?, id_cliente=? "
                + "WHERE id_parque=?";

        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, v.getPlaca());
            ps.setString(2, v.getNumeroSerie());
            ps.setString(3, v.getModelo());
            ps.setString(4, v.getMarca());
            ps.setDouble(5, v.getKilometraje());
            ps.setString(6, v.getTipo());
            ps.setInt(7, v.getIdCliente());
            ps.setInt(8, v.getIdParque());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean eliminar(int idParque) throws SQLException {
        String sql = "DELETE FROM parque WHERE id_parque=?";

        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idParque);
            return ps.executeUpdate() > 0;
        }
    }
}
