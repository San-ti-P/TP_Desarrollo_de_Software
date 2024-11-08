/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Controllers.VendedorController;
import javax.swing.table.DefaultTableModel;
import isi.deso.tpdsw.Models.Vendedor;
import javax.swing.JFrame;

/**
 *
 * @author santi
 */
public class VendedoresJPanel extends BuscadorJPanel{
    private VendedorController controlador;
    
    public VendedoresJPanel(){
        super(new String [] {
                "ID", "Nombre", "Dirección", "Menú", "Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo Vendedor");
        this.getTitleTextField().setText("Lista de Vendedores");
        this.getJTable().getColumnModel().getColumn(4).setMinWidth(150);
        this.getJTable().getColumnModel().getColumn(4).setMaxWidth(150);
        
        controlador = new VendedorController(this);
    }
    
    public void agregarFila(Vendedor v){
        DefaultTableModel model = (DefaultTableModel)this.getJTable().getModel();
        model.addRow(new Object[] {v.getId(), v.getNombre(), v.getDireccion(), null, null});
    }
    
    @Override
    void titleTextFieldActionPerformed(java.awt.event.ActionEvent evt){ 
    }                                                   

    @Override
    void btnCrearActionPerformed(java.awt.event.ActionEvent evt){
        VendedoresFormJFrame form = new VendedoresFormJFrame(controlador);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setVisible(true);
    } 
    
}
