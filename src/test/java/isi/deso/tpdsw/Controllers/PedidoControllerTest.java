
package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.PedidoDao;
import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.EstadoPedido;
import isi.deso.tpdsw.Models.ItemPedido;
import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Views.PedidosJPanel;
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

/**
 *
 * @author santi
 */
public class PedidoControllerTest {

    private PedidoController controlador;
    private PedidosJPanel panel;
    private PedidoDao dao;
    private JTable tabla;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Pedido> pedidosPorClientesConL;
    
    @BeforeAll
    public static void setUpClass() throws Exception {
        
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        
        dao = mock(PedidoDao.class);
        panel = mock(PedidosJPanel.class);
        tabla = new JTable();
        tabla.setModel(new DefaultTableModel(
            new Object [][] {new Object[] {1, new Cliente(3, "Carlos Diaz", "20-87654321-0", "carlos.diaz@hotmail.com", "Ruta Nacional 1 Km 50", new Coordenada(18.0, 35.0)),
                    new Vendedor(6, "La Brava", "Almirante Brown 1024", new Coordenada(50.0, 60.0)), EstadoPedido.EN_ENVIO
                    , null, null}}, new String [] {
                "ID", "Cliente", "Vendedor", "Estado", "Items" ,"Acciones"
        }));
       
        
        pedidos = new ArrayList<>();
       
        pedidos.add(new Pedido(1, new Cliente(1, "Juan Perez", "20-12345678-9", "juan.perez@gmail.com", "Av. Siempreviva 742", new Coordenada(12.0, 25.0)),
                new ArrayList<ItemPedido>(), 
                new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)), EstadoPedido.RECIBIDO));
        pedidos.add(new Pedido(2, new Cliente(2, "Maria Lopez", "27-98765432-1", "maria.lopez@gmail.com", "Calle Falsa 123", new Coordenada(15.0, 30.0)),
                new ArrayList<ItemPedido>(), 
                new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0)), EstadoPedido.RECIBIDO));
        pedidos.add(new Pedido(3, new Cliente(4, "Laura Garcia", "23-56789012-3", "laura.garcia@yahoo.com", "Bv. Gálvez 1250", new Coordenada(10.0, 22.0)),
                new ArrayList<ItemPedido>(), 
                new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0)), EstadoPedido.RECIBIDO));
        pedidos.add(new Pedido(4, new Cliente(4, "Laura Garcia", "23-56789012-3", "laura.garcia@yahoo.com", "Bv. Gálvez 1250", new Coordenada(10.0, 22.0)),
                new ArrayList<ItemPedido>(), 
                new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)), EstadoPedido.RECIBIDO));
           
        pedidosPorClientesConL = new ArrayList<>();
        pedidosPorClientesConL.add(new Pedido(1, new Cliente(2, "Maria Lopez", "27-98765432-1", "maria.lopez@gmail.com", "Calle Falsa 123", new Coordenada(15.0, 30.0)),
                new ArrayList<ItemPedido>(), 
                new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0)), EstadoPedido.RECIBIDO));
        pedidosPorClientesConL.add(new Pedido(3, new Cliente(4, "Laura Garcia", "23-56789012-3", "laura.garcia@yahoo.com", "Bv. Gálvez 1250", new Coordenada(10.0, 22.0)),
                new ArrayList<ItemPedido>(), 
                new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0)), EstadoPedido.RECIBIDO));
        pedidosPorClientesConL.add(new Pedido(4, new Cliente(4, "Laura Garcia", "23-56789012-3", "laura.garcia@yahoo.com", "Bv. Gálvez 1250", new Coordenada(10.0, 22.0)),
                new ArrayList<ItemPedido>(), 
                new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)), EstadoPedido.RECIBIDO));
        
        when(dao.getAll()).thenReturn(pedidos);
        when(dao.searchByName("L")).thenReturn(pedidosPorClientesConL);
        when(dao.searchByName("")).thenReturn(pedidos);
        when(dao.obtenerUltimoID()).thenReturn(4);
        
        when(panel.getJTable()).thenReturn(tabla);
        
        
        controlador = new PedidoController(panel, dao);
        
        
        
        
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    

    
    @Test
    public void vendedorCreadoCorrectamente(){
        Pedido esperado = new Pedido(5, new Cliente(3, "Carlos Diaz", "20-87654321-0", "carlos.diaz@hotmail.com", "Ruta Nacional 1 Km 50", new Coordenada(18.0, 35.0)),
                new ArrayList<ItemPedido>(), 
                new Vendedor(6, "La Brava", "Almirante Brown 1024", new Coordenada(50.0, 60.0)), EstadoPedido.RECIBIDO);
        Pedido real = controlador.crearPedido(new Cliente(3, "Carlos Diaz", "20-87654321-0", "carlos.diaz@hotmail.com", "Ruta Nacional 1 Km 50", new Coordenada(18.0, 35.0)),
                new Vendedor(6, "La Brava", "Almirante Brown 1024", new Coordenada(50.0, 60.0)),
                new ArrayList<ItemPedido>(), 0);
        
        assertEquals(esperado, real);
        
    }
    
    @Test
    public void idIncrementadoCorrectamente(){
        Pedido esperado = new Pedido(6, new Cliente(3, "Carlos Diaz", "20-87654321-0", "carlos.diaz@hotmail.com", "Ruta Nacional 1 Km 50", new Coordenada(18.0, 35.0)),
                new ArrayList<ItemPedido>(), 
                new Vendedor(6, "La Brava", "Almirante Brown 1024", new Coordenada(50.0, 60.0)), EstadoPedido.RECIBIDO);
        controlador.crearPedido(new Cliente(3, "Carlos Diaz", "20-87654321-0", "carlos.diaz@hotmail.com", "Ruta Nacional 1 Km 50", new Coordenada(18.0, 35.0)),
                new Vendedor(6, "La Brava", "Almirante Brown 1024", new Coordenada(50.0, 60.0)),
                new ArrayList<ItemPedido>(), 0);
        Pedido real = controlador.crearPedido(new Cliente(3, "Carlos Diaz", "20-87654321-0", "carlos.diaz@hotmail.com", "Ruta Nacional 1 Km 50", new Coordenada(18.0, 35.0)),
                new Vendedor(6, "La Brava", "Almirante Brown 1024", new Coordenada(50.0, 60.0)),
                new ArrayList<ItemPedido>(), 0);
        
        assertEquals(esperado, real);
    }
    
    @Test
    public void buscarDatosObtieneTodos(){
        controlador.buscarDatos();
        verify(dao).getAll();
        
        for(Pedido p: pedidos){
            verify(panel).agregarFila(p);
        }
    }
    
    @Test
    public void filtrarDatosFiltra(){
        controlador.filtrarDatos("L");
        verify(dao).searchByName("L");
        
        for(Pedido p: pedidosPorClientesConL){
            verify(panel).agregarFila(p);
        }
    }
    
    @Test
    public void filtarDatosStringVacioObtieneTodos(){
        controlador.filtrarDatos("");
        verify(dao).searchByName("");
        
        for(Pedido p: pedidos){
            verify(panel).agregarFila(p);
        }
    }
    
    @Test
    public void editarFilaLlamaFormYModifica(){
        controlador.editarFila(0);
        controlador.editarPedido(new Cliente(3, "Carlos Diaz", "20-87654321-0", "carlos.diaz@hotmail.com", "Ruta Nacional 1 Km 50", new Coordenada(18.0, 35.0)),
                new Vendedor(6, "La Brava", "Almirante Brown 1024", new Coordenada(50.0, 60.0)),
                new ArrayList<ItemPedido>(), EstadoPedido.RECIBIDO);
        verify(panel).getJTable();
        verify(panel).modificarFila(0, new Pedido(1, new Cliente(3, "Carlos Diaz", "20-87654321-0", "carlos.diaz@hotmail.com", "Ruta Nacional 1 Km 50", new Coordenada(18.0, 35.0)),
                new ArrayList<ItemPedido>(), 
                new Vendedor(6, "La Brava", "Almirante Brown 1024", new Coordenada(50.0, 60.0)), EstadoPedido.EN_ENVIO));
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
                "ID", "Cliente", "Vendedor", "Estado", "Items" ,"Acciones"
        }));
        
        controlador.eliminarFila(0);
        assertEquals(0, ((DefaultTableModel) tabla.getModel()).getRowCount());
    }
    
    @Test
    public void eliminarFilaFueraDeRangoFunciona(){
        
        controlador.eliminarFila(1);
        assertEquals(1, ((DefaultTableModel) tabla.getModel()).getRowCount());
    }
}
