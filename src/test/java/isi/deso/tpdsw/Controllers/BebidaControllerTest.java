
package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.BebidaDao;
import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Vendedor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BebidaControllerTest {
    
    private BebidaController controlador;
    private BebidaDao dao;
    
    public BebidaControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        dao = mock(BebidaDao.class);

        controlador = new BebidaController(dao);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void crearBebidaFunciona(){
        Bebida b = new Bebida(1, "Coca Cola", "Bebida gaseosa", 1.5f, Categoria.valueOf("gaseosas"), 
                0.0f, 500, true, new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0)));        
        
       
        assertEquals(b, controlador.crearBebida(b));
        verify(dao).createBebida(b);
    }
    
    @Test
    public void editarBebidaFunciona(){
        Bebida b = new Bebida(1, "Coca Cola", "Bebida gaseosa", 1.5f, Categoria.valueOf("gaseosas"), 
                0.0f, 500, true, new Vendedor(5, "McDonalds", "San Martin 384", new Coordenada(30.0, 40.0)));        
        
        assertEquals(b, controlador.editarBebida(b));
        verify(dao).updateBebida(b);
    }
}
