package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Controllers.PedidoController;
import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Services.PedidoDaoFactory;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;

public class PedidosJPanel extends BuscadorJPanel{
    private PedidoController controlador;
    
    public PedidosJPanel(){
        super(new String [] {
                "ID", "Cliente", "Vendedor", "Estado", "Items" ,"Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo Pedido");
        this.getTitleTextField().setText("Lista de Pedidos");
        this.getJTable().getColumnModel().getColumn(5).setMinWidth(150);
        this.getJTable().getColumnModel().getColumn(5).setMaxWidth(150);
        
        controlador = new PedidoController(this, (new PedidoDaoFactory()).getDao("sql"));
        
        this.getJTable().getColumnModel().getColumn(5).setCellRenderer(new ButtonRendererEditor(controlador, this));
        this.getJTable().getColumnModel().getColumn(5).setCellEditor(new ButtonRendererEditor(controlador, this));
    }

    public PedidoController getControlador() {
        return controlador;
    }

    public void agregarFila(Pedido p){
        DefaultTableModel model = (DefaultTableModel)this.getJTable().getModel();
        model.addRow(new Object[] {p.getId(), p.getCliente().getNombre(), p.getVendedor().getNombre(), p.getEstado(), null, null});
    }
    
    public void modificarFila(int fila, Pedido p) {
        this.getJTable().setValueAt(p.getCliente(), fila, 1);
        this.getJTable().setValueAt(p.getVendedor(), fila, 2);
        this.getJTable().setValueAt(p.getEstado(), fila, 3);
    }
    
    public void actualizarDatos(){
        this.vaciarTabla(); 
        controlador.buscarDatos();
    }

    @Override
    void btnCrearActionPerformed(java.awt.event.ActionEvent evt){
        PedidosFormJFrame form = new PedidosFormJFrame(controlador);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setVisible(true);
    }

    @Override
    void buscadorKeyReleased(KeyEvent evt) {
        this.vaciarTabla();
        controlador.filtrarDatos(this.getBuscadorTextField().getText());
    }

}
