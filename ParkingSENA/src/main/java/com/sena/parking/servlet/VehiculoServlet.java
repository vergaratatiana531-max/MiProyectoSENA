

package com.sena.parking.servlet;

import com.sena.parking.dao.VehiculoDAO;
import com.sena.parking.modelo.Vehiculo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/vehiculos")
public class VehiculoServlet extends HttpServlet {

    private final VehiculoDAO dao = new VehiculoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("vehiculos", dao.listar());
            request.getRequestDispatcher("/vehiculos.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error al consultar los vehículos", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            String accion = request.getParameter("accion");

            if ("insertar".equals(accion)) {

                Vehiculo v = new Vehiculo();
                v.setPlaca(request.getParameter("placa"));
                v.setNumeroSerie(request.getParameter("numeroSerie"));
                v.setModelo(request.getParameter("modelo"));
                v.setMarca(request.getParameter("marca"));
                v.setKilometraje(Double.parseDouble(request.getParameter("kilometraje")));
                v.setTipo(request.getParameter("tipo"));
                v.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));

                dao.insertar(v);

            } else if ("actualizar".equals(accion)) {

                Vehiculo v = new Vehiculo();
                v.setIdParque(Integer.parseInt(request.getParameter("idParque")));
                v.setPlaca(request.getParameter("placa"));
                v.setNumeroSerie(request.getParameter("numeroSerie"));
                v.setModelo(request.getParameter("modelo"));
                v.setMarca(request.getParameter("marca"));
                v.setKilometraje(Double.parseDouble(request.getParameter("kilometraje")));
                v.setTipo(request.getParameter("tipo"));
                v.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));

                dao.actualizar(v);

            } else if ("eliminar".equals(accion)) {

                int id = Integer.parseInt(request.getParameter("idParque"));
                dao.eliminar(id);
            }

            response.sendRedirect(request.getContextPath() + "/vehiculos");

        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("No fue posible procesar la operación", e);
        }
    }
}

