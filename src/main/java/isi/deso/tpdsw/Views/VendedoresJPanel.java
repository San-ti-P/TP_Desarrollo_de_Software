package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Controllers.VendedorController;
import javax.swing.table.DefaultTableModel;
import isi.deso.tpdsw.Models.Vendedor;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

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
        
        this.getJTable().getColumnModel().getColumn(4).setCellRenderer(new ButtonRendererEditor(controlador, this));
        this.getJTable().getColumnModel().getColumn(4).setCellEditor(new ButtonRendererEditor(controlador, this));
    }
    
    public VendedorController getControlador(){
        return this.controlador;
    }
    
    public void agregarFila(Vendedor v){
        DefaultTableModel model = (DefaultTableModel)this.getJTable().getModel();
        model.addRow(new Object[] {v.getId(), v.getNombre(), v.getDireccion(), null, null});
    }
    
    public void modificarFila(int fila, Vendedor v) {
        this.getJTable().setValueAt(v.getNombre(), fila, 1);
        this.getJTable().setValueAt(v.getDireccion(), fila, 2);
    }                                                

    public void actualizarDatos(){
        controlador.buscarDatos();
    }
    
    @Override
    void btnCrearActionPerformed(java.awt.event.ActionEvent evt){
        VendedoresFormJFrame form = new VendedoresFormJFrame(controlador);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setVisible(true);
    } 

    @Override
    void buscadorKeyReleased(KeyEvent evt) {
        this.vaciarTabla();
        controlador.filtrarDatos(this.getBuscadorTextField().getText());
    }
    
}
