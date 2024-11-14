
package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Categoria;
import java.util.ArrayList;

public interface CategoriaDao {
    public ArrayList<Categoria> getAll();
    public ArrayList<Categoria> searchByName(String nombre);
}
