/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Views.VendedoresJPanel;
/**
 *
 * @author santi
 */
public class VendedorController {
    private static int nextID = 0;
    private VendedoresJPanel vJPanel;
    
    public Vendedor crearVendedor(String nombre, String direccion, Double latitud, Double longitud){
        Coordenada c = new Coordenada(latitud, longitud);
        
        Vendedor v = new Vendedor(getNextID() ,nombre, direccion, c);
        
        vJPanel.agregarFila(v);
        
        setNextID(getNextID()+ 1);
        
        return v;
    }

    public VendedorController(VendedoresJPanel vJPanel) {
        this.vJPanel = vJPanel;
    }

   
    
    
    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        VendedorController.nextID = nextID;
    }
    
    
    
    
}
