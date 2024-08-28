/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw;
//import java.lang.Math;

public class Vendedor {
    final static private double RADIOTIERRA = 6378.0;
    private int id;
    private String nombre;
    private String direccion;
    private Coordenada coordenadas;

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    private static double semiverseno(double angulo){
        return Math.pow(Math.sin(angulo/((double)2)), 2);
    }
    
    public double distancia(Cliente cliente){
        double latCliente = Math.toRadians(cliente.getCoordenadas().getLat());
        double lngCliente = Math.toRadians(cliente.getCoordenadas().getLng());
        double latVendedor = Math.toRadians(coordenadas.getLat());
        double lngVendedor = Math.toRadians(coordenadas.getLng());
        return 2*RADIOTIERRA*Math.asin(Math.sqrt(Vendedor.semiverseno(latCliente-latVendedor)+Math.cos(latCliente)*Math.cos(latVendedor)*Vendedor.semiverseno(lngCliente-lngVendedor)));
    }
}

