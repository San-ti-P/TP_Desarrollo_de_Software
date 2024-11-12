package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Views.EditarClienteJFrame;
import isi.deso.tpdsw.Views.ClientesJPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ClienteController implements Controller{
    private static int nextID = 0;
    private ClientesJPanel cJPanel;
    private int fila;
    
    public Cliente crearCliente(String nombre, String cuit, String email, String direccion, Double latitud, Double longitud){
        Coordenada c = new Coordenada(latitud, longitud);
        Cliente cli = new Cliente(getNextID() ,nombre, cuit, email, direccion, c);
        cJPanel.agregarFila(cli);
        setNextID(getNextID()+ 1);
        
        return cli;
    }

    public ClienteController(ClientesJPanel cJPanel) {
        this.cJPanel = cJPanel;
    }
    
    
    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        ClienteController.nextID = nextID;
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
    
    // Verificar si la fila existe antes de eliminarla
    if (fila >= 0 && fila < modelo.getRowCount()) {
        // Eliminar la fila del modelo
        
        // Limpiar cualquier editor activo en la tabla para evitar errores
        if (tabla.isEditing()) {
            tabla.getCellEditor().stopCellEditing();
        }
        modelo.removeRow(fila);

        // Repintar la tabla para actualizar la interfaz
        tabla.repaint();
    }
}

    
    public void editarCliente(String nombre, String cuit, String email, String direccion, Double latitud, Double longitud) {
        int id = (int) cJPanel.getJTable().getValueAt(fila, 0);
        
    //  Recuperar vendedor de la BD y pasar a modificar
        Cliente c = new Cliente(id, nombre, cuit, email, direccion, new Coordenada(latitud, longitud));
        cJPanel.modificarFila(fila, c);
    }
}
