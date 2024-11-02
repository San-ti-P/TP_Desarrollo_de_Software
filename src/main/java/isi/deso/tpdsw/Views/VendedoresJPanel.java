/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Controllers.VendedorController;
import javax.swing.table.DefaultTableModel;

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
        DefaultTableModel model = (DefaultTableModel)this.getJTable().getModel();
        model.addRow(new Object[] {null, null, null, null});
        this.getJTable().getColumnModel().getColumn(3).setMinWidth(150);
        this.getJTable().getColumnModel().getColumn(3).setMaxWidth(150);
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
