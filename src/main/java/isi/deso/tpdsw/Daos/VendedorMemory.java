/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Vendedor;
import java.util.ArrayList;

public class VendedorMemory implements VendedorDao{
    private ArrayList<Vendedor> vendedores;
    
    public VendedorMemory(){
        vendedores = new ArrayList<>();
    }

    // Lo agregamos Marcos y Gonza
    @Override
    public ArrayList<Vendedor> getAll() {
        return null;
    }

    @Override
    public ArrayList<Vendedor> searchByName(String nombre) {
        return null;
    }
}
