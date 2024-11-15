package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Bebida;
import java.util.ArrayList;

public interface BebidaDao {
    public ArrayList<Bebida> getAll();
    public ArrayList<Bebida> searchByName(String nombre);
}
