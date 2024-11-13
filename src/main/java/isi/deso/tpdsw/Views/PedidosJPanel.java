package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Models.Pedido;
import javax.swing.table.DefaultTableModel;

public class PedidosJPanel extends BuscadorJPanel{
    
    public PedidosJPanel(){
        super(new String [] {
                "Cliente", "Vendedor", "Estado", "Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo Pedido");
        this.getTitleTextField().setText("Lista de Pedidos");
        DefaultTableModel model = (DefaultTableModel)this.getJTable().getModel();
        model.addRow(new Object[] {null, null, null, null});
        this.getJTable().getColumnModel().getColumn(3).setMinWidth(150);
        this.getJTable().getColumnModel().getColumn(3).setMaxWidth(150);
    }

    public void agregarFila(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void modificarFila(int fila, Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
