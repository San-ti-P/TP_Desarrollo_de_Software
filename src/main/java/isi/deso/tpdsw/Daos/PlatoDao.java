package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Plato;
import java.util.ArrayList;

public interface PlatoDao {
    public ArrayList<Plato> getAll();
    public ArrayList<Plato> searchByName(String nombre);
    public Plato createPlato(Plato plato);
    public Plato updatePlato(Plato plato);
    public void deletePlato(int id);

    int obtenerUltimoID();
}
