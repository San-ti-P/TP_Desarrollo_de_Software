package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Vendedor;
import java.util.ArrayList;

public class PlatoMemory implements PlatoDao{

    @Override
    public ArrayList<Plato> getAll() {
        return null;
    }

    @Override
    public ArrayList<Plato> searchByName(String nombre) {
        return null;
    }

    @Override
    public Plato createPlato(Plato plato) {
        return null;
    }

    @Override
    public Plato updatePlato(Plato plato) {
        return null;
    }

    @Override
    public void deletePlato(int id) {

    }

    @Override
    public ArrayList<Plato> getByVendedor(Vendedor v){
        return null;
    }
    
    @Override
    public int obtenerUltimoID() {
        return 0;
    }

    @Override
    public Plato getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
