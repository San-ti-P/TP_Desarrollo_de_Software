
package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Pago;
import java.util.ArrayList;


public interface PagoDao {
    public ArrayList<Pago> getAll();
    public ArrayList<Pago> searchByName(String nombre);
}
