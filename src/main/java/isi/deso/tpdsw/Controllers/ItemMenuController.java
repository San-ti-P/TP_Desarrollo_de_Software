package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Views.EditarItemMenuJFrame;
import isi.deso.tpdsw.Views.ItemsMenuJPanel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class ItemMenuController implements Controller{
    private static int nextID = 0;
    private ItemsMenuJPanel iJPanel;
//  private ItemMenuDao dao;
    private int fila;
    private PlatoController controladorPlato;
    private BebidaController controladorBebida;
    
    public ItemMenuController(ItemsMenuJPanel iJPanel) {
        this.iJPanel = iJPanel;
        this.controladorPlato = new PlatoController();
        this.controladorBebida = new BebidaController();
    }
    
    public ItemsMenuJPanel getIJPanel(){
        return this.iJPanel;
    }
    
    public int getFila(){
        return this.fila;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        ItemMenuController.nextID = nextID;
    }
    
    public Plato crearPlato(String nombre, String descripcion, int calorias, boolean aptoCeliaco, float peso, float precio, Categoria categoria, boolean aptoVegano, Vendedor vendedor){
        Plato p = controladorPlato.crearPlato(getNextID(), nombre, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor);
        this.getIJPanel().agregarFila(p);
        return p;
    }
    
    public void editarPlato(String nombre, String descripcion, int calorias, boolean aptoCeliaco, float peso, float precio, Categoria categoria, boolean aptoVegano, Vendedor vendedor) {
        int id = (int) this.getIJPanel().getJTable().getValueAt(this.getFila(), 0);
        
        Plato p = controladorPlato.editarPlato(id, nombre, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor);
        this.getIJPanel().modificarFila(this.getFila(), p);
    }
    
    public Bebida crearBebida(String nombre, String descripcion, float precio, Categoria categoria, float gradAlcohol, int tamanio, boolean aptoVegano, Vendedor vendedor){
        Bebida b = controladorBebida.crearBebida(getNextID(), nombre, descripcion, precio, categoria, gradAlcohol, tamanio, aptoVegano, vendedor);
        this.getIJPanel().agregarFila(b);
        return b;
    }
    
    public void editarBebida(String nombre, String descripcion, float precio, Categoria categoria, float gradAlcohol, int tamanio, boolean aptoVegano, Vendedor vendedor) {
        int id = (int) this.getIJPanel().getJTable().getValueAt(this.getFila(), 0);
        
        Bebida b = controladorBebida.editarBebida(id, nombre, descripcion, precio, categoria, gradAlcohol, tamanio, aptoVegano, vendedor);
        this.getIJPanel().modificarFila(this.getFila(), b);
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

    
    
    
//    public void filtrarDatos(String nombre){
//        ArrayList<ItemMenu> item = dao.searchByName(nombre);
//
//        int size = items.size();
//        for(int i=0; i<size; i++){
//            iJPanel.agregarFila(items.get(i));
//        }
//    }
    
}
