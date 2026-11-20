package com.sena.parking.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/inicio")
public class InicioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("""
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <title>ParkingSENA</title>
            </head>
            <body>
                <h1>Bienvenido a ParkingSENA</h1>
                <h2>Sistema de gestión de parqueadero</h2>
                <p>El módulo web Java está funcionando correctamente.</p>
            </body>
            </html>
            """);
    }
}
