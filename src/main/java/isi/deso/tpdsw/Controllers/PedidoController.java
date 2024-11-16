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
    private static int nextID;
    private PedidosJPanel pJPanel;
    private PedidoDao dao;
    private int fila;
    
    public PedidoController(PedidosJPanel pJPanel, PedidoDao dao) {
        this.pJPanel = pJPanel;
        this.dao = dao;
        nextID = dao.obtenerUltimoID() + 1;
    }

    public Pedido crearPedido(Cliente cliente, Vendedor vendedor, ArrayList<ItemPedido> items, double subtotal){
        Pedido p = new Pedido(getNextID(), cliente, items, vendedor, EstadoPedido.RECIBIDO);
        pJPanel.agregarFila(p);
        setNextID(getNextID()+ 1);
        dao.createPedido(p);

        return p;
    }
    
    public Pedido editarPedido(Cliente cliente, Vendedor vendedor, ArrayList<ItemPedido> items, EstadoPedido estado) {
        int id = (int) pJPanel.getJTable().getValueAt(fila, 0);
        Pedido p = new Pedido(id, cliente, items, vendedor, estado);
        pJPanel.modificarFila(fila, p);
        dao.updatePedido(p);

        return p;
    }
    
    public void buscarDatos() {
        ArrayList<Pedido> pedidos = dao.getAll();
        for (Pedido pedido : pedidos) {
            pJPanel.agregarFila(pedido);
        }
    }

    public void filtrarDatos(String nombre){
        ArrayList<Pedido> pedidos = dao.searchByName(nombre);
        for (Pedido pedido: pedidos) {
            pJPanel.agregarFila(pedido);
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
            int id = (int) tabla.getValueAt(fila, 0);
            dao.deletePedido(id);
            modelo.removeRow(fila);
            tabla.repaint();
        }
    }
}
