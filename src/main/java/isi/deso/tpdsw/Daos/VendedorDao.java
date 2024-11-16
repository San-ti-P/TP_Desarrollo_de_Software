package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Vendedor;
import java.util.ArrayList;

public interface VendedorDao {
    public ArrayList<Vendedor> getAll();
    public ArrayList<Vendedor> searchByName(String nombre);
    
    public Vendedor getVendedorById(int vendedorId);
    
    public Vendedor createVendedor(Vendedor vendedor);
    public Vendedor updateVendedor(Vendedor vendedor);
    public void deleteVendedor(int id);
    public int obtenerUltimoID();
}
