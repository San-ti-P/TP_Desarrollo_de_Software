package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Models.Coordenada;

import java.util.ArrayList;

public class VendedorMemory implements VendedorDao {
    private ArrayList<Vendedor> vendedores;

    public VendedorMemory() {
        vendedores = new ArrayList<>();
        // Agregar datos de prueba
        vendedores.add(new Vendedor(1, "Vendedor 1", "Direccion 1", new Coordenada(10.0, 20.0)));
        vendedores.add(new Vendedor(2, "Vendedor 2", "Direccion 2", new Coordenada(30.0, 40.0)));
    }

    @Override
    public ArrayList<Vendedor> getAll() {
        return new ArrayList<>(vendedores);
    }

    @Override
    public ArrayList<Vendedor> searchByName(String nombre) {
        ArrayList<Vendedor> result = new ArrayList<>();
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNombre().contains(nombre)) {
                result.add(vendedor);
            }
        }
        return result;
    }
    
    public Vendedor getVendedorById(int vendedorId){return null;}
}
