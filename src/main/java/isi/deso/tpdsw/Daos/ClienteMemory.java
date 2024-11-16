package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Models.Coordenada;

import java.util.ArrayList;

public class ClienteMemory implements ClienteDao {
    private ArrayList<Cliente> clientes;

    public ClienteMemory() {
        clientes = new ArrayList<>();
        // Agregar datos de prueba
        clientes.add(new Cliente(1, "Cliente 1", "20-12345678-9", "cliente1@example.com", "Direccion Cliente 1", new Coordenada(15.0, 25.0)));
        clientes.add(new Cliente(2, "Cliente 2", "20-87654321-0", "cliente2@example.com", "Direccion Cliente 2", new Coordenada(35.0, 45.0)));
    }

    @Override
    public ArrayList<Cliente> getAll() {
        return new ArrayList<>(clientes);
    }

    @Override
    public ArrayList<Cliente> searchByName(String nombre) {
        ArrayList<Cliente> result = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().contains(nombre)) {
                result.add(cliente);
            }
        }
        return result;
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        int nuevoId = obtenerUltimoID() + 1;
        cliente.setId(nuevoId);
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void deleteCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    @Override
    public int obtenerUltimoID() {
        return 0;
    }
}