package com.sena.parking.modelo;

public class Vehiculo {

    private int idParque;
    private String placa;
    private String numeroSerie;
    private String modelo;
    private String marca;
    private double kilometraje;
    private String tipo;
    private int idCliente;

    public Vehiculo() {
    }

    public Vehiculo(int idParque, String placa, String numeroSerie,
                    String modelo, String marca, double kilometraje,
                    String tipo, int idCliente) {
        this.idParque = idParque;
        this.placa = placa;
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.marca = marca;
        this.kilometraje = kilometraje;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }

    public int getIdParque() {
        return idParque;
    }

    public void setIdParque(int idParque) {
        this.idParque = idParque;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
