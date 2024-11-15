package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.ItemPedido;
import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Services.ItemNoEncontradoException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class ItemsPedidoSQL implements ItemsPedidoDao{

    @Override
    public ArrayList<ItemPedido> getAll() {
        return null;
    }

    @Override
    public ArrayList<ItemPedido> searchByName(String nombre) {
        return null;
    }

    @Override
    public ArrayList<ItemPedido> filtrarPedido(Pedido pedido, Predicate<ItemPedido> funcionLambda) throws ItemNoEncontradoException {
        return null;
    }

    @Override
    public ArrayList<ItemPedido> ordenarPedido(Pedido pedido, Comparator comparador) {
        return null;
    }

    @Override
    public ArrayList<ItemPedido> rangoPrecios(Pedido pedido, float precioInferior, float precioSuperior) throws ItemNoEncontradoException {
        return null;
    }

    @Override
    public ArrayList<ItemPedido> filtrarPorRestaurante(Pedido pedido, String nombre) throws ItemNoEncontradoException {
        return null;
    }
}
