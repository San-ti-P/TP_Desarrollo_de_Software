package isi.deso.tpdsw.Views;

import javax.swing.table.DefaultTableModel;

public class ItemsMenuJPanel extends BuscadorJPanel{
    
    public ItemsMenuJPanel(){
        super(new String [] {
                "Nombre", "Descripcion", "Precio", "Categoria", "AptoVegano", "Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo ItemMenu");
        this.getTitleTextField().setText("Lista de ItemsMenu");
        DefaultTableModel model = (DefaultTableModel)this.getJTable().getModel();
        model.addRow(new Object[] {null, null, null, null, null, null});
        this.getJTable().getColumnModel().getColumn(5).setMinWidth(150);
        this.getJTable().getColumnModel().getColumn(5).setMaxWidth(150);
    }
    
}
