package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Categoria;
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
        clientes.add(new Cliente(3, "Cliente 3", "20-11223344-5", "cliente3@example.com", "Direccion Cliente 3", new Coordenada(55.0, 65.0)));
        clientes.add(new Cliente(4, "Cliente 4", "20-55667788-9", "cliente4@example.com", "Direccion Cliente 4", new Coordenada(75.0, 85.0)));
        clientes.add(new Cliente(5, "Cliente 5", "20-99887766-0", "cliente5@example.com", "Direccion Cliente 5", new Coordenada(95.0, 105.0)));
    }

    @Override
    public ArrayList<Cliente> getAll() {
        return clientes;
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
        int maxId = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getId() > maxId) {
                maxId = cliente.getId();
            }
        }
        return maxId;
    }

    @Override
    public Cliente getClienteById(int clienteId) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == clienteId) {
                return cliente;
            }
        }
        return null;
    }
}