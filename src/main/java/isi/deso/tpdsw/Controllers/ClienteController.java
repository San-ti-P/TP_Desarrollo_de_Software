package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.ClienteDao;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Services.ClienteDaoFactory;
import isi.deso.tpdsw.Views.EditarClienteJFrame;
import isi.deso.tpdsw.Views.ClientesJPanel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.util.ArrayList;

public class ClienteController implements Controller{
    private static int nextID;
    private ClientesJPanel cJPanel;
    private ClienteDao dao;
    private int fila;
    
    public ClienteController(ClientesJPanel cJPanel, ClienteDao dao) {
        this.cJPanel = cJPanel;
        this.dao = dao;
        nextID = dao.obtenerUltimoID() + 1;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        ClienteController.nextID = nextID;
    }

    public void buscarDatos() {
        ArrayList<Cliente> clientes = dao.getAll();
        for (Cliente cliente : clientes) {
            cJPanel.agregarFila(cliente);
        }
    }

    public void filtrarDatos(String nombre) {
        ArrayList<Cliente> clientes = dao.searchByName(nombre);
        for (Cliente cliente : clientes) {
            cJPanel.agregarFila(cliente);
        }
    }

    public Cliente crearCliente(String nombre, String cuit, String email, String direccion, Double latitud, Double longitud){
        Coordenada c = new Coordenada(latitud, longitud);
        Cliente cli = new Cliente(getNextID() ,nombre, cuit, email, direccion, c);
        cJPanel.agregarFila(cli);
        setNextID(getNextID()+ 1);
        dao.createCliente(cli);

        return cli;
    }

    public Cliente editarCliente(String nombre, String cuit, String email, String direccion, Double latitud, Double longitud) {
        int id = (int) cJPanel.getJTable().getValueAt(fila, 0);
        Cliente cli = new Cliente(id, nombre, cuit, email, direccion, new Coordenada(latitud, longitud));
        cJPanel.modificarFila(fila, cli);
        dao.updateCliente(cli);

        return cli;
    }


    @Override
    public void editarFila(int fila) {
        this.fila = fila;
        EditarClienteJFrame form = new EditarClienteJFrame(this);
        form.setVisible(true);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void eliminarFila(int fila) {
        this.fila = fila;
        JTable tabla = cJPanel.getJTable();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        if (fila >= 0 && fila < modelo.getRowCount()) {
            if (tabla.isEditing()) {
                tabla.getCellEditor().stopCellEditing();
            }
            int id = (int) tabla.getValueAt(fila, 0);
            dao.deleteCliente(id);
            modelo.removeRow(fila);
            tabla.repaint();
        }
    }
}
