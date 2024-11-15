
package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Views.VendedoresJPanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author santi
 */
public class VendedorControllerTest {
    
    public VendedorControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void vendedorCreadoCorrectamente(){
        VendedorController.setNextID(0);
        Vendedor esperado = new Vendedor(0, "Luigi's", "Marcial Candioti 3986", new Coordenada(12.3, 89.4));
        VendedoresJPanel panel = new VendedoresJPanel();
        //VendedorController controlador = new VendedorController(null);
        Vendedor real = panel.getControlador().crearVendedor("Luigi's", "Marcial Candioti 3986", 12.3, 89.4);
        assertEquals(esperado.getId(), real.getId());
        assertEquals(esperado.getNombre(), real.getNombre());
        assertEquals(esperado.getDireccion(), real.getDireccion());
        assertEquals(esperado.getCoordenadas().getLat(), real.getCoordenadas().getLat());
        assertEquals(esperado.getCoordenadas().getLng(), real.getCoordenadas().getLng());
    }
    
    @Test
    public void idIncrementadoCorrectamente(){
        VendedorController.setNextID(0);
        Vendedor esperado = new Vendedor(0, "Luigi's", "Marcial Candioti 3986", new Coordenada(12.3, 89.4));
        VendedoresJPanel panel = new VendedoresJPanel();
        Vendedor real = panel.getControlador().crearVendedor("Luigi's", "Marcial Candioti 3986", 12.3, 89.4);
        esperado = new Vendedor(1, "Nombre1", "Dirección1", new Coordenada(10, 10));
        real = panel.getControlador().crearVendedor("Nombre1", "Dirección1", 10d, 10d);
        assertEquals(esperado.getId(), real.getId());
        assertEquals(esperado.getNombre(), real.getNombre());
        assertEquals(esperado.getDireccion(), real.getDireccion());
        assertEquals(esperado.getCoordenadas().getLat(), real.getCoordenadas().getLat());
        assertEquals(esperado.getCoordenadas().getLng(), real.getCoordenadas().getLng());
    }
    
    
}
