package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Vendedor;

public class BebidaController {
    
    public Bebida crearBebida(int id, String nombre, String descripcion, float precio, Categoria categoria, float gradAlcohol, int tamanio, boolean aptoVegano, Vendedor vendedor){
        return new Bebida(id, nombre, descripcion, precio, categoria, gradAlcohol, tamanio, aptoVegano, vendedor);
    }
    public Bebida editarBebida(int id, String nombre, String descripcion, float precio, Categoria categoria, float gradAlcohol, int tamanio, boolean aptoVegano, Vendedor vendedor) {
        //  Recuperar vendedor de la BD y pasar a modificar
        return new Bebida(id, nombre, descripcion, precio, categoria, gradAlcohol, tamanio, aptoVegano, vendedor);

    }
}
