package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Vendedor;
import java.util.ArrayList;

public interface PlatoDao {
    public ArrayList<Plato> getAll();
    public ArrayList<Plato> searchByName(String nombre);
    public Plato createPlato(Plato plato);
    public Plato updatePlato(Plato plato);
    public void deletePlato(int id);
    public ArrayList<Plato> getByVendedor(Vendedor v);
    public Plato getById(int id);
    int obtenerUltimoID();
}
