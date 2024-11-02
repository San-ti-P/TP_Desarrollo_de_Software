/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Views;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class ClientesJPanel extends BuscadorJPanel{
    
    public ClientesJPanel(){
        super(new String [] {
                "Nombre", "Dirección", "Cuit", "Direccion", "Pedidos", "Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo Cliente");
        this.getTitleTextField().setText("Lista de Clientes");
        DefaultTableModel model = (DefaultTableModel)this.getJTable().getModel();
        model.addRow(new Object[] {null, null, null, null, null, null});
        this.getJTable().getColumnModel().getColumn(5).setMinWidth(150);
        this.getJTable().getColumnModel().getColumn(5).setMaxWidth(150);
    }
    
}
