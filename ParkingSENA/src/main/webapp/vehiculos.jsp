<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


    
<%@ page import="java.util.List" %>
<%@ page import="com.sena.parking.modelo.Vehiculo" %>

<%
    List<Vehiculo> vehiculos =
        (List<Vehiculo>) request.getAttribute("vehiculos");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>ParkingSENA</title>
</head>
<body>

<h1>ParkingSENA</h1>

<h2>Registro de vehículos</h2>

<form action="<%= request.getContextPath() %>/vehiculos" method="post">
    <input type="hidden" name="accion" value="insertar">

    <label>Placa:</label>
    <input type="text" name="placa" required><br><br>

    <label>Número de serie:</label>
    <input type="text" name="numeroSerie" required><br><br>

    <label>Modelo:</label>
    <input type="text" name="modelo"><br><br>

    <label>Marca:</label>
    <input type="text" name="marca"><br><br>

    <label>Kilometraje:</label>
    <input type="number" step="0.01" name="kilometraje" required><br><br>

    <label>Tipo:</label>
    <input type="text" name="tipo"><br><br>

    <label>ID del cliente:</label>
    <input type="number" name="idCliente" required><br><br>

    <button type="submit">Registrar vehículo</button>
</form>

<hr>

<h2>Vehículos registrados</h2>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Placa</th>
        <th>Número de serie</th>
        <th>Modelo</th>
        <th>Marca</th>
        <th>Kilometraje</th>
        <th>Tipo</th>
        <th>Cliente</th>
        <th>Acción</th>
    </tr>

    <% if (vehiculos != null) {
        for (Vehiculo v : vehiculos) { %>

    <tr>
        <td><%= v.getIdParque() %></td>
        <td><%= v.getPlaca() %></td>
        <td><%= v.getNumeroSerie() %></td>
        <td><%= v.getModelo() %></td>
        <td><%= v.getMarca() %></td>
        <td><%= v.getKilometraje() %></td>
        <td><%= v.getTipo() %></td>
        <td><%= v.getIdCliente() %></td>
        <td>
            <form action="<%= request.getContextPath() %>/vehiculos"
                  method="post">
                <input type="hidden" name="accion" value="eliminar">
                <input type="hidden" name="idParque"
                       value="<%= v.getIdParque() %>">
                <button type="submit">Eliminar</button>
            </form>
        </td>
    </tr>

    <%  }
       } %>
</table>

<hr>

<h2>Actualizar vehículo</h2>

<form action="<%= request.getContextPath() %>/vehiculos" method="post">

    <input type="hidden" name="accion" value="actualizar">

    <label>ID del vehículo que deseas actualizar:</label>
    <input type="number" name="idParque" required><br><br>

    <label>Placa:</label>
    <input type="text" name="placa" required><br><br>

    <label>Número de serie:</label>
    <input type="text" name="numeroSerie" required><br><br>

    <label>Modelo:</label>
    <input type="text" name="modelo"><br><br>

    <label>Marca:</label>
    <input type="text" name="marca"><br><br>

    <label>Kilometraje:</label>
    <input type="number" step="0.01" name="kilometraje" required><br><br>

    <label>Tipo:</label>
    <input type="text" name="tipo"><br><br>

    <label>ID del cliente:</label>
    <input type="number" name="idCliente" required><br><br>

    <button type="submit">Actualizar vehículo</button>
</form>

<br>

<a href="<%= request.getContextPath() %>/inicio">Volver al inicio</a>

</body>
</html>
