package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Views.EditarItemMenuJFrame;
import isi.deso.tpdsw.Views.EditarVendedorJFrame;
import isi.deso.tpdsw.Views.ItemsMenuJPanel;
import isi.deso.tpdsw.Views.VendedoresJPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.util.ArrayList;

public class ItemMenuController implements Controller{
    private static int nextID = 0;
    private ItemsMenuJPanel iJPanel;
//  private ItemMenuDao dao;
    private int fila;
    
    public Bebida crearBebida(String nombre, String descripcion, float precio, Categoria categoria, float gradAlcohol, int tamanio, boolean aptoVegano, Vendedor vendedor){
        Bebida b = new Bebida(getNextID(), nombre, descripcion, precio, categoria, gradAlcohol, tamanio, aptoVegano, vendedor);
        iJPanel.agregarFila(b);
        setNextID(getNextID()+ 1);
        
        return b;
    }
    
    public Plato crearPlato(String nombre, String descripcion, int calorias, boolean aptoCeliaco, float peso, float precio, Categoria categoria, boolean aptoVegano, Vendedor vendedor){
        Plato p = new Plato(getNextID(), nombre, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor);
        iJPanel.agregarFila(p);
        setNextID(getNextID()+ 1);
        
        return p;
    }

    public ItemMenuController(ItemsMenuJPanel iJPanel) {
        this.iJPanel = iJPanel;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        ItemMenuController.nextID = nextID;
    }

    @Override
    public void editarFila(int fila) {
        this.fila = fila;
        EditarItemMenuJFrame form = new EditarItemMenuJFrame(this);
        form.setVisible(true);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void eliminarFila(int fila) {
    this.fila = fila;
    
    JTable tabla = iJPanel.getJTable();
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    
    if (fila >= 0 && fila < modelo.getRowCount()) {
        if (tabla.isEditing()) {
            tabla.getCellEditor().stopCellEditing();
        }
        modelo.removeRow(fila);
        tabla.repaint();
    }
}

    public void editarBebida(String nombre, String descripcion, float precio, Categoria categoria, float gradAlcohol, int tamanio, boolean aptoVegano, Vendedor vendedor) {
        int id = (int) iJPanel.getJTable().getValueAt(fila, 0);
        
        //  Recuperar vendedor de la BD y pasar a modificar
        Bebida b = new Bebida(id, nombre, descripcion, precio, categoria, gradAlcohol, tamanio, aptoVegano, vendedor);
        iJPanel.modificarFila(fila, b);
    }
    
    public void editarPlato(String nombre, String descripcion, int calorias, boolean aptoCeliaco, float peso, float precio, Categoria categoria, boolean aptoVegano, Vendedor vendedor) {
        int id = (int) iJPanel.getJTable().getValueAt(fila, 0);
        
        //  Recuperar vendedor de la BD y pasar a modificar
        Plato p = new Plato(id, nombre, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor);
        iJPanel.modificarFila(fila, p);
    }

//    public void filtrarDatos(String nombre){
//        ArrayList<ItemMenu> item = dao.searchByName(nombre);
//
//        int size = items.size();
//        for(int i=0; i<size; i++){
//            iJPanel.agregarFila(items.get(i));
//        }
//    }
    
}
