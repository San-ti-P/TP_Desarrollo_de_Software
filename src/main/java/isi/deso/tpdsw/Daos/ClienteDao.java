
package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Cliente;
import java.util.ArrayList;


public interface ClienteDao {
    public ArrayList<Cliente> getAll();
    public ArrayList<Cliente> searchByName(String nombre);
}
