
package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.CategoriaDao;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.TipoItem;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author santi
 */
public class CategoriaControllerTest {
    
    private CategoriaController controlador;
    private CategoriaDao dao;
    private ArrayList<Categoria> categorias;
    
    public CategoriaControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws Exception {
        
    }
    
    
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        
        dao = mock(CategoriaDao.class);
        
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Gaseosas", TipoItem.BEBIDA));
        categorias.add(new Categoria(2, "Hamburguesas", TipoItem.PLATO));
        categorias.add(new Categoria(3, "Helados", TipoItem.PLATO));
        categorias.add(new Categoria(4, "Vinos", TipoItem.BEBIDA));
           
        
        when(dao.getAll()).thenReturn(categorias);

        
        
        controlador = new CategoriaController(dao);
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void obtenerVendedoresObtieneTodos(){
        ArrayList<Categoria> retorno = controlador.obtenerCategorias();
        int size = categorias.size();
        for(int i=0; i<size; i++){
            assertEquals(categorias.get(i), retorno.get(i));
        }
    }
    
    @Test
    public void obtenerVendedoresListaVacia(){
        ArrayList<Categoria> vacio = new ArrayList();
        when(dao.getAll()).thenReturn(vacio);
        ArrayList<Categoria> retorno = controlador.obtenerCategorias();
        assertEquals(0, retorno.size());
    }
}
