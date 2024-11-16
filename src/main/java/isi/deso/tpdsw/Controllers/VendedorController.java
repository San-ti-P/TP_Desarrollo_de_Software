package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.VendedorDao;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.VendedorDaoFactory;
import isi.deso.tpdsw.Views.EditarVendedorJFrame;
import isi.deso.tpdsw.Views.VendedoresJPanel;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class VendedorController implements Controller{
    private static int nextID;
    private VendedoresJPanel vJPanel;
    private VendedorDao dao;
    private int fila;

    public VendedorController(VendedoresJPanel vJPanel, VendedorDao dao) {
        this.vJPanel = vJPanel;
        this.dao = dao;
        nextID = dao.obtenerUltimoID() + 1;
    }

    public VendedorController() {
        this.dao = dao;
    }
    
    public Vendedor crearVendedor(String nombre, String direccion, Double latitud, Double longitud){
        Coordenada c = new Coordenada(latitud, longitud);
        Vendedor v = new Vendedor(getNextID() ,nombre, direccion, c);
        vJPanel.agregarFila(v);
        setNextID(getNextID()+ 1);
        dao.createVendedor(v);
        
        return v;
    }
    
    
    public Vendedor editarVendedor(String nombre, String direccion, Double latitud, Double longitud) {
        int id = (int) vJPanel.getJTable().getValueAt(fila, 0);
        Vendedor v = new Vendedor(id, nombre, direccion, new Coordenada(latitud, longitud));
        vJPanel.modificarFila(fila, v);
        dao.updateVendedor(v);

        return v;
    }
    public void buscarDatos(){
        ArrayList<Vendedor> vendedores = dao.getAll();
        
        int size = vendedores.size();
        for(int i=0; i<size; i++){
            vJPanel.agregarFila(vendedores.get(i));
        }
    }

    public void filtrarDatos(String nombre){
        ArrayList<Vendedor> vendedores = dao.searchByName(nombre);

        int size = vendedores.size();
        for(int i=0; i<size; i++){
            vJPanel.agregarFila(vendedores.get(i));
        }
    }
    
    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        VendedorController.nextID = nextID;
    }

    @Override
    public void editarFila(int fila) {
        this.fila = fila;
        EditarVendedorJFrame form = new EditarVendedorJFrame(this);
        form.setVisible(true);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void eliminarFila(int fila) {
        this.fila = fila;

        JTable tabla = vJPanel.getJTable();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        if (fila >= 0 && fila < modelo.getRowCount()) {
            if (tabla.isEditing()) {
                tabla.getCellEditor().stopCellEditing();
            }
            int id = (int) tabla.getValueAt(fila, 0);
            dao.deleteVendedor(id);
            modelo.removeRow(fila);
            tabla.repaint();
        }
    }

    public ArrayList<Vendedor> obtenerVendedores() {
        return dao.getAll();
    }
}
