/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Vendedor;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class VendedorMemory implements VendedorDao{
    private ArrayList<Vendedor> vendedores;
    
    public VendedorMemory(){
        vendedores = new ArrayList<>();
    }
}
