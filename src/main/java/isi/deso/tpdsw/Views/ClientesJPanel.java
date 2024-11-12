package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Controllers.ClienteController;
import javax.swing.table.DefaultTableModel;
import isi.deso.tpdsw.Models.Cliente;
import javax.swing.JFrame;

public class ClientesJPanel extends BuscadorJPanel{
    private ClienteController controlador;
    
    public ClientesJPanel(){
        super(new String [] {
                "ID", "Nombre", "Dirección", "Cuit", "Email", "Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo Cliente");
        this.getTitleTextField().setText("Lista de Clientes");
        DefaultTableModel model = (DefaultTableModel)this.getJTable().getModel();
        this.getJTable().getColumnModel().getColumn(5).setMinWidth(150);
        this.getJTable().getColumnModel().getColumn(5).setMaxWidth(150);
        
        controlador = new ClienteController(this);
        
        this.getJTable().getColumnModel().getColumn(5).setCellRenderer(new ButtonRendererEditor(controlador, this));
        this.getJTable().getColumnModel().getColumn(5).setCellEditor(new ButtonRendererEditor(controlador, this));
    }
    
    public void agregarFila(Cliente cli){
        DefaultTableModel model = (DefaultTableModel)this.getJTable().getModel();
        model.addRow(new Object[] {cli.getId(), cli.getNombre(), cli.getDireccion(), cli.getCuit(), cli.getEmail(), null, null});
    }
    
    public void modificarFila(int fila, Cliente cli) {
        this.getJTable().setValueAt(cli.getNombre(), fila, 1);
        this.getJTable().setValueAt(cli.getDireccion(), fila, 2);
        this.getJTable().setValueAt(cli.getCuit(), fila, 3);
        this.getJTable().setValueAt(cli.getEmail(), fila, 4);
        
    }
    
    @Override
    void titleTextFieldActionPerformed(java.awt.event.ActionEvent evt){ 
    }                                                   

    @Override
    void btnCrearActionPerformed(java.awt.event.ActionEvent evt){
        ClientesFormJFrame form = new ClientesFormJFrame(controlador);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setVisible(true);
    } 
    
    
}
