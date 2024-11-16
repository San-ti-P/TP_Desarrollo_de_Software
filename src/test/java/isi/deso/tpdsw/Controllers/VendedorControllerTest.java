
package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.VendedorDao;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Views.VendedoresJPanel;
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
public class VendedorControllerTest {

    private VendedorController controlador;
    private VendedoresJPanel panel;
    private VendedorDao dao;
    private JTable tabla;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Vendedor> vendedoresConL;
    
    @BeforeAll
    public static void setUpClass() throws Exception {
        
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        
        dao = mock(VendedorDao.class);
        panel = mock(VendedoresJPanel.class);
        tabla = new JTable();
        tabla.setModel(new DefaultTableModel(
            new Object [][] {new Object[] {4, "Lo de Nestor", "Pedro de Vega 1423", null, null}}, new String [] {
                "ID", "Nombre", "Dirección", "Menú", "Acciones"
        }));
       
        
        vendedores = new ArrayList<>();
        vendedores.add(new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        vendedores.add(new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0)));
        vendedores.add(new Vendedor(6, "La Brava", "Almirante Brown 1024", new Coordenada(50.0, 60.0)));
        vendedores.add(new Vendedor(7, "El Fogolar", "Salvador del Carril 744", new Coordenada(70.0, 80.0)));
           
        vendedoresConL = new ArrayList<>();
        vendedoresConL.add(new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        vendedoresConL.add(new Vendedor(6, "La Brava", "Almirante Brown 1024", new Coordenada(50.0, 60.0)));
        
        when(dao.getAll()).thenReturn(vendedores);
        when(dao.searchByName("L")).thenReturn(vendedoresConL);
        when(dao.searchByName("")).thenReturn(vendedores);
        when(dao.obtenerUltimoID()).thenReturn(7);
        
        when(panel.getJTable()).thenReturn(tabla);
        
        
        controlador = new VendedorController(panel, dao);
        
        
        
        
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    

    
    @Test
    public void vendedorCreadoCorrectamente(){
        Vendedor esperado = new Vendedor(8, "Luigi's", "Marcial Candioti 3986", new Coordenada(12.3, 89.4));
        Vendedor real = controlador.crearVendedor("Luigi's", "Marcial Candioti 3986", 12.3, 89.4);
        
        assertEquals(esperado, real);
        
    }
    
    @Test
    public void idIncrementadoCorrectamente(){
        Vendedor esperado = new Vendedor(9, "Nombre1", "Dirección1", new Coordenada(10, 10));

        Vendedor real = controlador.crearVendedor("Luigi's", "Marcial Candioti 3986", 12.3, 89.4);
        real = controlador.crearVendedor("Nombre1", "Dirección1", 10d, 10d);
        
        assertEquals(esperado, real);
    }
    
    @Test
    public void buscarDatosObtieneTodos(){
        controlador.buscarDatos();
        verify(dao).getAll();
        
        for(Vendedor v: vendedores){
            verify(panel).agregarFila(v);
        }
    }
    
    @Test
    public void filtrarDatosFiltra(){
        controlador.filtrarDatos("L");
        verify(dao).searchByName("L");
        
        for(Vendedor v: vendedoresConL){
            verify(panel).agregarFila(v);
        }
    }
    
    @Test
    public void filtarDatosStringVacioObtieneTodos(){
        controlador.filtrarDatos("");
        verify(dao).searchByName("");
        
        for(Vendedor v: vendedores){
            verify(panel).agregarFila(v);
        }
    }
    
    @Test
    public void editarFilaLlamaFormYModifica(){
        controlador.editarFila(0);
        controlador.editarVendedor("Lo de Nestor", "Pedro de Vega 1523", 10.0, 20.0);
        verify(panel).getJTable();
        verify(panel).modificarFila(0, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1523", new Coordenada(10.0, 20.0)));
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
                "ID", "Nombre", "Dirección", "Menú", "Acciones"
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
