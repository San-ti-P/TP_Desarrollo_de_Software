package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Views.EditarVendedorJFrame;
import isi.deso.tpdsw.Views.VendedoresJPanel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendedorController implements Controller{
    private static int nextID = 0;
    private VendedoresJPanel vJPanel;
    private int fila;
    
    public Vendedor crearVendedor(String nombre, String direccion, Double latitud, Double longitud){
        Coordenada c = new Coordenada(latitud, longitud);
        Vendedor v = new Vendedor(getNextID() ,nombre, direccion, c);
        vJPanel.agregarFila(v);
        setNextID(getNextID()+ 1);
        
        return v;
    }

    public VendedorController(VendedoresJPanel vJPanel) {
        this.vJPanel = vJPanel;
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
    }

    @Override
    public void eliminarFila(int fila) {
        ((DefaultTableModel) vJPanel.getJTable().getModel()).removeRow(fila);
    }
    
    public void editarVendedor(String nombre, String direccion, Double latitud, Double longitud) {
        int id = (int) vJPanel.getJTable().getValueAt(fila, 0);
        
    //  Recuperar vendedor de la BD y pasar a modificar
        Vendedor v = new Vendedor(id, nombre, direccion, new Coordenada(latitud, longitud));
        vJPanel.modificarFila(fila, v);
    }
}
