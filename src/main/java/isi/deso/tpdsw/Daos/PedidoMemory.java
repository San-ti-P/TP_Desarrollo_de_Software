package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.*;
import java.util.ArrayList;

public class PedidoMemory implements PedidoDao{
    private ArrayList<Pedido> pedidos;

    public PedidoMemory() {
        pedidos = new ArrayList<>();

        // Agregar datos de prueba
        Cliente cliente1 = new Cliente(1, "Cliente 1", "20-12345678-9", "cliente1@example.com", "Direccion Cliente 1", new Coordenada(15.0, 25.0));
        Cliente cliente2 = new Cliente(2, "Cliente 2", "20-87654321-0", "cliente2@example.com", "Direccion Cliente 2", new Coordenada(35.0, 45.0));
        Vendedor vendedor1 = new Vendedor(1, "Vendedor 1", "Direccion Vendedor 1", new Coordenada(10.0, 20.0));
        Vendedor vendedor2 = new Vendedor(2, "Vendedor 2", "Direccion Vendedor 2", new Coordenada(30.0, 40.0));

        Pedido pedido1 = new Pedido(1, cliente1, new ArrayList<>(), vendedor1, EstadoPedido.EN_ENVIO);
        Pedido pedido2 = new Pedido(2, cliente2, new ArrayList<>(), vendedor2, EstadoPedido.ENTREGADO);

        pedidos.add(pedido1);
        pedidos.add(pedido2);
    }

    @Override
    public ArrayList<Pedido> getAll() {
        return new ArrayList<>(pedidos);
    }

    @Override
    public ArrayList<Pedido> searchByName(String nombre_cliente) {
        ArrayList<Pedido> result = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getNombre().contains(nombre_cliente)){
                result.add(pedido);
            }
        }
        return result;
    }

    @Override
    public Pedido createPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedido updatePedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletePedido(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int obtenerUltimoID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
