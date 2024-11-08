package isi.deso.tpdsw.Views;

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
    
}
