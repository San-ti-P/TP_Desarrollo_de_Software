package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Vendedor;

import java.util.ArrayList;

public interface BebidaDao {
    public ArrayList<Bebida> getAll();
    public ArrayList<Bebida> searchByName(String nombre);
    public Bebida updateBebida(Bebida bebida);
    public Bebida createBebida(Bebida bebida);
    public void deleteBebida(int id);
    public ArrayList<Bebida> getByVendedor(Vendedor v); 
    public Bebida getById(int id);
    int obtenerUltimoID();
}
