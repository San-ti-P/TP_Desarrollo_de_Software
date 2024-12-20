package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.BebidaDao;
import isi.deso.tpdsw.Daos.PlatoDao;
import isi.deso.tpdsw.Models.*;
import isi.deso.tpdsw.Services.BebidaDaoFactory;
import isi.deso.tpdsw.Services.PlatoDaoFactory;
import isi.deso.tpdsw.Views.EditarItemMenuJFrame;
import isi.deso.tpdsw.Views.ItemsMenuJPanel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.util.ArrayList;

public class ItemMenuController implements Controller{
    private static int nextID;
    private ItemsMenuJPanel iJPanel;
    private PlatoDao daoPlato;
    private BebidaDao daoBebida;
    private int fila;
    private PlatoController controladorPlato;
    private BebidaController controladorBebida;
    
    public ItemMenuController(ItemsMenuJPanel iJPanel, BebidaDao daoBebida, PlatoDao daoPlato) {
        this.iJPanel = iJPanel;
        this.controladorPlato = new PlatoController((new PlatoDaoFactory()).getDao("sql"));
        this.controladorBebida = new BebidaController((new BebidaDaoFactory()).getDao("sql"));
        this.daoBebida = daoBebida;
        this.daoPlato = daoPlato;
        nextID = Math.max(daoPlato.obtenerUltimoID(), daoBebida.obtenerUltimoID()) + 1;
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

    public void buscarDatos() {
        ArrayList<Bebida> bebidas = daoBebida.getAll();
        ArrayList<Plato> platos = daoPlato.getAll();
        
        for (Bebida bebida : bebidas) {
            iJPanel.agregarFila(bebida);
        }
        for (Plato plato : platos) {
            iJPanel.agregarFila(plato);
        }
    }

    public void filtrarDatos(String nombre) {
        ArrayList<Bebida> bebidas = daoBebida.searchByName(nombre);
        ArrayList<Plato> platos = daoPlato.searchByName(nombre);
        for (Bebida bebida : bebidas) {
            iJPanel.agregarFila(bebida);
        }
        for (Plato plato : platos) {
            iJPanel.agregarFila(plato);
        }
    }
    
    public ArrayList<ItemMenu> getByVendedor(Vendedor v){
        ArrayList<ItemMenu> retorno = new ArrayList<>();
        ArrayList<Bebida> bebidas = daoBebida.getByVendedor(v);
        ArrayList<Plato> platos = daoPlato.getByVendedor(v);
        for (Bebida bebida : bebidas) {
            retorno.add(bebida);
        }
        for (Plato plato : platos) {
            retorno.add(plato);
        }
        return retorno;
    }

    public ItemMenu getById(int id){
        Bebida bebida = daoBebida.getById(id);
        if(bebida==null){
            Plato plato = daoPlato.getById(id);
            if(plato==null){
                return null;
            }
            else{
                return plato;
            }
        }
        else{
            return bebida;
        }

    }
    
    public Plato crearPlato(String nombre, String descripcion, int calorias, boolean aptoCeliaco, float peso, float precio, Categoria categoria, boolean aptoVegano, Vendedor vendedor){
        Plato p = new Plato(getNextID(), nombre, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor);
        controladorPlato.crearPlato(p);
        this.getIJPanel().agregarFila(p);
        setNextID(getNextID()+ 1);
        return p;
    }
    
    public void editarPlato(String nombre, String descripcion, int calorias, boolean aptoCeliaco, float peso, float precio, Categoria categoria, boolean aptoVegano, Vendedor vendedor) {
        int id = (int) this.getIJPanel().getJTable().getValueAt(this.getFila(), 0);
        Plato p = new Plato(id, nombre, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor);
        controladorPlato.editarPlato(p);
        this.getIJPanel().modificarFila(this.getFila(), p);
    }
    
    public Bebida crearBebida(String nombre, String descripcion, float precio, Categoria categoria, float gradAlcohol, int tamanio, boolean aptoVegano, Vendedor vendedor){
        Bebida b = new Bebida(getNextID(), nombre, descripcion, precio, categoria, gradAlcohol, tamanio, aptoVegano, vendedor);
        controladorBebida.crearBebida(b);
        this.getIJPanel().agregarFila(b);
        setNextID(getNextID()+ 1);
        return b;
    }
    
    public void editarBebida(String nombre, String descripcion, float precio, Categoria categoria, float gradAlcohol, int tamanio, boolean aptoVegano, Vendedor vendedor) {
        int id = (int) this.getIJPanel().getJTable().getValueAt(this.getFila(), 0);
        Bebida b = new Bebida(id, nombre, descripcion, precio, categoria, gradAlcohol, tamanio, aptoVegano, vendedor);
        controladorBebida.editarBebida(b);
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
            int id = (int) tabla.getValueAt(fila, 0);
            daoBebida.deleteBebida(id);
            daoPlato.deletePlato(id);
            modelo.removeRow(fila);
            tabla.repaint();
        }
    }
}
