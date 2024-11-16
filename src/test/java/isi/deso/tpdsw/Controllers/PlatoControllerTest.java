
package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.PlatoDao;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Vendedor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class PlatoControllerTest {

    private PlatoController controlador;
    private PlatoDao dao;
    
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        dao = mock(PlatoDao.class);

        controlador = new PlatoController(dao);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void crearBebidaFunciona(){
        Plato p = new Plato(4, "Ensalada Verde", "Ensalada fresca con lechuga, rúcula, espinaca y aderezo de oliva", 150, true,
                180.0f, 2.8f, Categoria.valueOf("verduras"), true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
       
        assertEquals(p, controlador.crearPlato(p));
        verify(dao).createPlato(p);
    }
    
    @Test
    public void editarBebidaFunciona(){
        Plato p = new Plato(4, "Ensalada Verde", "Ensalada fresca con lechuga, rúcula, espinaca y aderezo de oliva", 150, true,
                180.0f, 2.8f, Categoria.valueOf("verduras"), true, new Vendedor(4, "Lo de Nestor", "Pedro de Vega 1423", new Coordenada(10.0, 20.0)));
        
        assertEquals(p, controlador.editarPlato(p));
        verify(dao).updatePlato(p);
    }
    
}
