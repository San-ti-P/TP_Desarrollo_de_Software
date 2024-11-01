/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Controllers.VendedorController;

/**
 *
 * @author santi
 */
public class VendedoresJPanel extends BuscadorJPanel{
    private VendedorController controlador;
    
    public VendedoresJPanel(){
        super(new String [] {
                "Nombre", "Dirección", "Menú", "Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo Vendedor");
        this.getTitleTextField().setText("Lista de Vendedores");
    }
    /*
    @Override
    void titleTextFieldActionPerformed(java.awt.event.ActionEvent evt){
        
    }                                                   

    @Override
    void btnCrearActionPerformed(java.awt.event.ActionEvent evt){

    } 
    */
}
