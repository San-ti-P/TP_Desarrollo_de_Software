
package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.BebidaDao;
import isi.deso.tpdsw.Daos.PlatoDao;
import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.ItemMenu;
import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Views.ItemsMenuJPanel;
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
public class ItemMenuControllerTest {

    private ItemMenuController controlador;
    private ItemsMenuJPanel panel;
    private BebidaDao bebidaDao;
    private PlatoDao platoDao;
    private JTable tabla;
    private ArrayList<Plato> platos;
    private ArrayList<Plato> platosConE;
    private ArrayList<Bebida> bebidas;
    private ArrayList<Bebida> bebidasConE;
    
    @BeforeAll
    public static void setUpClass() throws Exception {
        
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        
        bebidaDao = mock(BebidaDao.class);
        platoDao = mock(PlatoDao.class);
        panel = mock(ItemsMenuJPanel.class);
        tabla = new JTable();
        tabla.setModel(new DefaultTableModel(
            new Object [][] {new Object[] {1, "Coca Cola", "Bebida gaseosa", 1.5f, Categoria.valueOf("gaseosas"), 0.0f}}, new String [] {
                "ID", "Nombre", "Descripcion", "Precio", "Categoria", "AptoVegano", "Acciones"
        }));
       
        
        bebidas = new ArrayList<>();
        bebidas.add(new Bebida(1, "Coca Cola", "Bebida gaseosa", 1.5f, Categoria.valueOf("gaseosas"), 
                0.0f, 500, true, new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0))));
        bebidas.add(new Bebida(2, "Estancia Mendoza Malbec 750 cc.", "Vino Malbec añejado en barriles de roble francés", 2.5f, Categoria.valueOf("vinos"), 
                14.0f, 750, true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0))));
        bebidas.add(new Bebida(3, "Sprite", "Bebida gaseosa", 1.8f, Categoria.valueOf("gaseosas"), 
                0.0f, 250, true, new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0))));
        bebidas.add(new Bebida(8, "Etchart Privado Torrontes", "Vino blanco muy bueno para acompañar pescados y quesos", 1.0f, Categoria.valueOf("vinos"), 
                12.5f, 750, true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0))));
           
        bebidasConE = new ArrayList<>();
        bebidasConE.add(new Bebida(2, "Estancia Mendoza Malbec 750 cc.", "Vino Malbec añejado en barriles de roble francés", 2.5f, Categoria.valueOf("vinos"), 
                14.0f, 750, true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0))));
        bebidasConE.add(new Bebida(8, "Etchart Privado Torrontes", "Vino blanco muy bueno para acompañar pescados y quesos", 1.0f, Categoria.valueOf("vinos"), 
                12.5f, 750, true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0))));
           
        
        platos = new ArrayList<>();
        platos.add(new Plato(4, "Ensalada Verde", "Ensalada fresca con lechuga, rúcula, espinaca y aderezo de oliva", 150, true,
                180.0f, 2.8f, Categoria.valueOf("verduras"), true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0))));
        platos.add(new Plato(5, "Hamburguesa Doble", "Doble medallón de carne vacuna con queso cheddar, lechuga y tomate", 850, false,
                300.0f, 4.5f, Categoria.valueOf("hamburguesas"), false, new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0))));
        platos.add(new Plato(6, "Ensalada de Pollo y Palta", "Ensalada fresca con pechuga de pollo a la plancha, palta y aderezo de limón", 300, false,
                250.0f, 3.0f, Categoria.valueOf("verduras"), false, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0))));
        platos.add(new Plato(7, "Milanesa Napolitana", "Milanesa de ternera con jamón, queso, salsa de tomate y papas fritas", 950, false,
                400.0f, 5.0f, Categoria.valueOf("carnes"), false, new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0))));
        
        platosConE = new ArrayList<>();
        platosConE.add(new Plato(4, "Ensalada Verde", "Ensalada fresca con lechuga, rúcula, espinaca y aderezo de oliva", 150, true,
                180.0f, 2.8f, Categoria.valueOf("verduras"), true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0))));
        platosConE.add(new Plato(6, "Ensalada de Pollo y Palta", "Ensalada fresca con pechuga de pollo a la plancha, palta y aderezo de limón", 300, false,
                250.0f, 3.0f, Categoria.valueOf("verduras"), false, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0))));
        
        when(bebidaDao.getAll()).thenReturn(bebidas);
        when(bebidaDao.searchByName("E")).thenReturn(bebidasConE);
        when(bebidaDao.searchByName("")).thenReturn(bebidas);
        when(bebidaDao.obtenerUltimoID()).thenReturn(8);
        
        when(platoDao.getAll()).thenReturn(platos);
        when(platoDao.searchByName("E")).thenReturn(platosConE);
        when(platoDao.searchByName("")).thenReturn(platos);
        when(platoDao.obtenerUltimoID()).thenReturn(7);
        
        when(panel.getJTable()).thenReturn(tabla);
        
        
        controlador = new ItemMenuController(panel, bebidaDao, platoDao);
        
        
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    

    
    @Test
    public void bebidaCreadaCorrectamente(){
        Bebida esperado = new Bebida(9, "Nombre1", "Descripción1", 2.5f, Categoria.valueOf("vinos"), 
                10.0f, 1000, true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        Bebida real = controlador.crearBebida("Nombre1", "Descripción1", 2.5f, Categoria.valueOf("vinos"), 
                10.0f, 1000, true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        
        assertEquals(esperado, real);
    }
    
    @Test
    public void platoCreadaCorrectamente(){
        Plato esperado = new Plato(9, "Nombre2", "Descripción2", 150, true, 200.0f, 3.0f, Categoria.valueOf("verduras"), 
                true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        Plato real = controlador.crearPlato("Nombre2", "Descripción2", 150, true, 200.0f, 3.0f, Categoria.valueOf("verduras"), 
                true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        
        assertEquals(esperado, real);  
    }
    
    @Test
    public void idIncrementadoCorrectamente(){
        Plato esperado = new Plato(10, "Nombre2", "Descripción2", 150, true, 200.0f, 3.0f, Categoria.valueOf("verduras"), 
                true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        
        controlador.crearBebida("Nombre1", "Descripción1", 2.5f, Categoria.valueOf("vinos"), 
                10.0f, 1000, true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        Plato real = controlador.crearPlato("Nombre2", "Descripción2", 150, true, 200.0f, 3.0f, Categoria.valueOf("verduras"), 
                true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        
        assertEquals(esperado, real);
    }
    
    @Test
    public void buscarDatosObtieneTodos(){
        controlador.buscarDatos();
        verify(bebidaDao).getAll();
        verify(platoDao).getAll();
        
        for(Bebida b: bebidas){
            verify(panel).agregarFila(b);
        }
        for(Plato p: platos){
            verify(panel).agregarFila(p);
        }
    }
    
    @Test
    public void filtrarDatosFiltra(){
        controlador.filtrarDatos("E");
        verify(bebidaDao).searchByName("E");
        verify(platoDao).searchByName("E");
        
        for(Bebida b: bebidasConE){
            verify(panel).agregarFila(b);
        }
        for(Plato p: platosConE){
            verify(panel).agregarFila(p);
        }
    }
    
    @Test
    public void filtarDatosStringVacioObtieneTodos(){
        controlador.filtrarDatos("");
        verify(bebidaDao).searchByName("");
        verify(platoDao).searchByName("");
        
        for(Bebida b: bebidas){
            verify(panel).agregarFila(b);
        }
        for(Plato p: platos){
            verify(panel).agregarFila(p);
        }
    }
    
    @Test
    public void editarFilaLlamaFormYModificaPlato(){
        controlador.editarFila(0);
        controlador.editarPlato("Nombre2", "Descripción2", 150, true, 200.0f, 3.0f, Categoria.valueOf("verduras"), 
                true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        verify(panel).getJTable();
        verify(panel).modificarFila(0, new Plato(1, "Nombre2", "Descripción2", 150, true, 200.0f, 3.0f, Categoria.valueOf("verduras"), 
                true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0))));
    }
    
    @Test
    public void editarFilaLlamaFormYModificaBebida(){
        controlador.editarFila(0);
        controlador.editarBebida("Nombre1", "Descripción1", 2.5f, Categoria.valueOf("vinos"), 
                10.0f, 1000, true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        verify(panel).getJTable();
        verify(panel).modificarFila(0, new Bebida(1, "Nombre1", "Descripción1", 2.5f, Categoria.valueOf("vinos"), 
                10.0f, 1000, true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0))));
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
    /*
    @Test
    public void obtenerVendedoresObtieneTodos(){
        ArrayList<Vendedor> retorno = controlador.obtenerVendedores();
        int size = vendedores.size();
        for(int i=0; i<size; i++){
            assertEquals(vendedores.get(i), retorno.get(i));
        }
    }
    
    @Test
    public void obtenerVendedoresListaVacia(){
        ArrayList<Vendedor> vacio = new ArrayList();
        when(dao.getAll()).thenReturn(vacio);
        ArrayList<Vendedor> retorno = controlador.obtenerVendedores();
        assertEquals(0, retorno.size());
    }
    */
}
