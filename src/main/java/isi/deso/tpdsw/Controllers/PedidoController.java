package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.PedidoDao;
import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Models.EstadoPedido;
import isi.deso.tpdsw.Models.ItemPedido;
import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.PedidoDaoFactory;
import isi.deso.tpdsw.Views.EditarPedidoJFrame;
import isi.deso.tpdsw.Views.PedidosJPanel;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class PedidoController implements Controller{
    private static int nextID = 0;
    private PedidosJPanel pJPanel;
    private PedidoDao dao;
    private int fila;
    
    public Pedido crearPedido(Cliente cliente, Vendedor vendedor, ArrayList<ItemPedido> items, double subtotal){
        Pedido p = new Pedido(getNextID(), cliente, items, vendedor, EstadoPedido.RECIBIDO);
        pJPanel.agregarFila(p);
        setNextID(getNextID()+ 1);
        
        return p;
    }

    public PedidoController(PedidosJPanel pJPanel) {
        this.pJPanel = pJPanel;
        this.dao = (new PedidoDaoFactory()).getDao("sql");
    }

    public void filtrarDatos(String nombre){
        ArrayList<Pedido> pedidos = dao.searchByName(nombre);

        int size = pedidos.size();
        for(int i=0; i<size; i++){
            pJPanel.agregarFila(pedidos.get(i));
        }
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        PedidoController.nextID = nextID;
    }

    @Override
    public void editarFila(int fila) {
        this.fila = fila;
        EditarPedidoJFrame form = new EditarPedidoJFrame(this);
        form.setVisible(true);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void eliminarFila(int fila) {
        this.fila = fila;

        JTable tabla = pJPanel.getJTable();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        if (fila >= 0 && fila < modelo.getRowCount()) {
            if (tabla.isEditing()) {
                tabla.getCellEditor().stopCellEditing();
            }
            modelo.removeRow(fila);
            tabla.repaint();
        }
    }

    public void editarPedido(Cliente cliente, Vendedor vendedor, ArrayList<ItemPedido> items, double subtotal) {
        int id = (int) pJPanel.getJTable().getValueAt(fila, 0);
        
    //  Recuperar pedido de la BD y pasar a modificar
        Pedido p = new Pedido(id,cliente, items, vendedor, EstadoPedido.ENTREGADO); // definir editar pedidoo interfazz
        pJPanel.modificarFila(fila, p);
    }
}
