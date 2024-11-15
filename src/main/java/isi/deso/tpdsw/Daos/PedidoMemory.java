package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Pedido;

import java.util.ArrayList;

public class PedidoMemory implements PedidoDao{
    private ArrayList<Pedido> pedidos;

    public PedidoMemory(){
        pedidos = new ArrayList<>();
    }

    // Lo agregamos Marcos y Gonza
    @Override
    public ArrayList<Pedido> getAll() {
        return null;
    }

    @Override
    public ArrayList<Pedido> searchByName(String nombre) {
        return null;
    }
}
