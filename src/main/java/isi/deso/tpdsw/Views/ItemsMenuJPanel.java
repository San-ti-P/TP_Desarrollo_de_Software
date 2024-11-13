package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Controllers.ItemMenuController;
import isi.deso.tpdsw.Models.ItemMenu;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ItemsMenuJPanel extends BuscadorJPanel{
    private ItemMenuController controlador;
    
    public ItemsMenuJPanel(){
        super(new String [] {
                "ID", "Nombre", "Descripcion", "Precio", "Categoria", "AptoVegano", "Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo ItemMenu");
        this.getTitleTextField().setText("Lista de ItemsMenu");
        this.getJTable().getColumnModel().getColumn(6).setMinWidth(150);
        this.getJTable().getColumnModel().getColumn(6).setMaxWidth(150);
        
        controlador = new ItemMenuController(this);
        
        this.getJTable().getColumnModel().getColumn(6).setCellRenderer(new ButtonRendererEditor(controlador, this));
        this.getJTable().getColumnModel().getColumn(6).setCellEditor(new ButtonRendererEditor(controlador, this));
    }
    
    public void agregarFila(ItemMenu i){
        DefaultTableModel model = (DefaultTableModel)this.getJTable().getModel();
        model.addRow(new Object[] {i.getId(), i.getNombre(), i.getDescripcion(), i.getPrecio(), i.getCategoria(), i.getAptoVegano(), null});
    }
    
    public void modificarFila(int fila, ItemMenu i) {
        this.getJTable().setValueAt(i.getNombre(), fila, 1);
        this.getJTable().setValueAt(i.getDescripcion(), fila, 2);
        this.getJTable().setValueAt(i.getPrecio(), fila, 3);
        this.getJTable().setValueAt(i.getCategoria(), fila, 4);
        this.getJTable().setValueAt(i.getAptoVegano(), fila, 5);
    }                                                 

    @Override
    void btnCrearActionPerformed(java.awt.event.ActionEvent evt){
        ItemsMenuFormJFrame form = new ItemsMenuFormJFrame(controlador);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setVisible(true);
    } 
}
