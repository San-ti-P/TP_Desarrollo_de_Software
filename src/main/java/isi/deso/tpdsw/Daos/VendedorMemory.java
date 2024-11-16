package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Cliente;
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
        vendedores.add(new Vendedor(3, "Vendedor 3", "Direccion 3", new Coordenada(50.0, 60.0)));
        vendedores.add(new Vendedor(4, "Vendedor 4", "Direccion 4", new Coordenada(70.0, 80.0)));
        vendedores.add(new Vendedor(5, "Vendedor 5", "Direccion 5", new Coordenada(90.0, 100.0)));
    }

    @Override
    public ArrayList<Vendedor> getAll() {
        return vendedores;
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
    
    public Vendedor getVendedorById(int vendedorId){
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() == vendedorId) {
                return vendedor;
            }
        }
        return null;
    }

    @Override
    public Vendedor createVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
        return vendedor;
    }

    @Override
    public Vendedor updateVendedor(Vendedor vendedor) {
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getId() == vendedor.getId()) {
                vendedores.set(i, vendedor);
                return vendedor;
            }
        }
        return null;
    }

    @Override
    public void deleteVendedor(int id) {
        vendedores.removeIf(vendedor -> vendedor.getId() == id);
    }

    @Override
    public int obtenerUltimoID() {
        int maxId = 0;
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() > maxId) {
                maxId = vendedor.getId();
            }
        }
        return maxId;
    }
}
