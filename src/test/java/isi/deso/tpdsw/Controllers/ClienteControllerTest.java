
package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.ClienteDao;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Views.ClientesJPanel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ClienteControllerTest {
    
    public ClienteControllerTest() {
    }
    
    private ClienteController controlador;
    private ClientesJPanel panel;
    private ClienteDao dao;
    private JTable tabla;
    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> clientesConL;
    
    @BeforeAll
    public static void setUpClass() throws Exception {
        
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        
        dao = mock(ClienteDao.class);
        panel = mock(ClientesJPanel.class);
        tabla = new JTable();
        tabla.setModel(new DefaultTableModel(
            new Object [][] {new Object[] {2, "Maria Lopez", "Calle Falsa 123", "27-98765432-1", "maria.lopez@gmail.com", null, null}}, new String [] {
                "ID", "Nombre", "Dirección", "Cuit", "Email", "Acciones"
            }));
       
        
        clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan Perez", "20-12345678-9", "juan.perez@gmail.com", "Av. Siempreviva 742", new Coordenada(12.0, 25.0)));
        clientes.add(new Cliente(2, "Maria Lopez", "27-98765432-1", "maria.lopez@gmail.com", "Calle Falsa 123", new Coordenada(15.0, 30.0)));
        clientes.add(new Cliente(3, "Carlos Diaz", "20-87654321-0", "carlos.diaz@hotmail.com", "Ruta Nacional 1 Km 50", new Coordenada(18.0, 35.0)));
        clientes.add(new Cliente(4, "Laura Garcia", "23-56789012-3", "laura.garcia@yahoo.com", "Bv. Gálvez 1250", new Coordenada(10.0, 22.0)));
           
        clientesConL = new ArrayList<>();
        clientesConL.add(new Cliente(2, "Maria Lopez", "27-98765432-1", "maria.lopez@gmail.com", "Calle Falsa 123", new Coordenada(15.0, 30.0)));
        clientesConL.add(new Cliente(4, "Laura Garcia", "23-56789012-3", "laura.garcia@yahoo.com", "Bv. Gálvez 1250", new Coordenada(10.0, 22.0)));
        
        when(dao.getAll()).thenReturn(clientes);
        when(dao.searchByName("L")).thenReturn(clientesConL);
        when(dao.searchByName("")).thenReturn(clientes);
        when(dao.obtenerUltimoID()).thenReturn(4);
        
        when(panel.getJTable()).thenReturn(tabla);
        
        
        controlador = new ClienteController(panel, dao);
        
        
        
        
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    

    
    @Test
    public void clienteCreadoCorrectamente(){
        Cliente esperado = new Cliente(5, "Tomás Aquino", "22-12345678-7", "tomas.aquino10@gmail.com", "Marcial Candioti 1545", new Coordenada(11.0, 9.5));
        Cliente real = controlador.crearCliente("Tomás Aquino", "22-12345678-7", "tomas.aquino10@gmail.com", "Marcial Candioti 1545", 11.0, 9.5);
        
        assertEquals(esperado, real);
        
    }
    
    @Test
    public void idIncrementadoCorrectamente(){
        Cliente esperado = new Cliente(6, "Nombre1", "Cuit1", "Email1", "Direccion1", new Coordenada(10.0, 10.0));

        controlador.crearCliente("Tomás Aquino", "22-12345678-7", "tomas.aquino10@gmail.com", "Marcial Candioti 1545", 11.0, 9.5);
        Cliente real = controlador.crearCliente("Nombre1", "Cuit1", "Email1", "Direccion1", 10.0, 10.0);
        
        assertEquals(esperado, real);
    }
    
    @Test
    public void buscarDatosObtieneTodos(){
        controlador.buscarDatos();
        verify(dao).getAll();
        
        for(Cliente c: clientes){
            verify(panel).agregarFila(c);
        }
    }
    
    @Test
    public void filtrarDatosFiltra(){
        controlador.filtrarDatos("L");
        verify(dao).searchByName("L");
        
        for(Cliente c: clientesConL){
            verify(panel).agregarFila(c);
        }
    }
    
    @Test
    public void filtarDatosStringVacioObtieneTodos(){
        controlador.filtrarDatos("");
        verify(dao).searchByName("");
        
        for(Cliente c: clientes){
            verify(panel).agregarFila(c);
        }
    }
    
    @Test
    public void editarFilaLlamaFormYModifica(){
        controlador.editarFila(0);
        controlador.editarCliente("Maria Lopez", "27-98765432-1", "maria-lopez@gmail.com", "Calle Falsa 123", 15.0, 30.0);
        verify(panel).getJTable();
        verify(panel).modificarFila(0, new Cliente(2, "Maria Lopez", "27-98765432-1", "maria-lopez@gmail.com", "Calle Falsa 123", new Coordenada(15.0, 30.0)));
    }

    @Test
    public void eliminarFilaActualizaModelo(){
        
        controlador.eliminarFila(0);
        assertEquals(0, ((DefaultTableModel) tabla.getModel()).getRowCount());
    }
    
    @Test
    public void eliminaFilaTablaVaciaFunciona(){
        JTable tablaVacia = new JTable();
        tablaVacia.setModel(new DefaultTableModel(
            new Object [][] {}, new String [] {
                "ID", "Nombre", "Dirección", "Cuit", "Email", "Acciones"
        }));
        
        controlador.eliminarFila(0);
        assertEquals(0, ((DefaultTableModel) tabla.getModel()).getRowCount());
    }
    
    @Test
    public void eliminarFilaFueraDeRangoFunciona(){
        
        controlador.eliminarFila(1);
        assertEquals(1, ((DefaultTableModel) tabla.getModel()).getRowCount());
    }
    /*
    @Test
    public void obtenerClientesObtieneTodos(){
        ArrayList<Cliente> retorno = controlador.obtenerClientes();
        int size = clientes.size();
        for(int i=0; i<size; i++){
            assertEquals(clientes.get(i), retorno.get(i));
        }
    }
    
    @Test
    public void obtenerClientesListaVacia(){
        ArrayList<Cliente> vacio = new ArrayList();
        when(dao.getAll()).thenReturn(vacio);
        ArrayList<Cliente> retorno = controlador.obtenerClientes();
        assertEquals(0, retorno.size());
    }*/
}
