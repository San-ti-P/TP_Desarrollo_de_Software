package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Cliente;
import java.util.ArrayList;

public interface ClienteDao {
    public ArrayList<Cliente> getAll();
    public ArrayList<Cliente> searchByName(String nombre);
    public Cliente createCliente(Cliente cliente);
    public Cliente updateCliente(Cliente cliente);
    public void deleteCliente(int id);
    public int obtenerUltimoID();
    public Cliente getClienteById(int id); 
}
