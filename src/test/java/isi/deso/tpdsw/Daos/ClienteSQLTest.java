
package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Cliente;
import java.util.ArrayList;
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
public class ClienteSQLTest {
    
    private ClienteSQL dao;
    
    public ClienteSQLTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        dao = new ClienteSQL();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void clientesCumplenUnicidadyExistencia(){
        ArrayList<Cliente> clientes = dao.getAll();
        ArrayList<Integer> ids = new ArrayList();
        ArrayList<String> cuits = new ArrayList();
        for(Cliente c: clientes){
            int id = c.getId();
            String cuit = c.getCuit();
            
            assertFalse(ids.contains(id));
            assertFalse(cuits.contains(cuit));
            
            assertNotNull(id);
            assertNotNull(c.getNombre());
            assertNotNull(cuit);
            assertNotNull(c.getDireccion());
            assertNotNull(c.getCoordenadas().getLat());
            assertNotNull(c.getCoordenadas().getLng());
            
            ids.add(id);
            cuits.add(cuit);
        }
    }
}
