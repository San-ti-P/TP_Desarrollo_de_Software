package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Models.ItemPedido;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ItemsPedidoMemory implements ItemsPedidoDao {
    @Override
    public ArrayList<ItemPedido> filtrarPedido(Pedido pedido, Predicate<ItemPedido> funcionLambda) throws ItemNoEncontradoException{
        ArrayList<ItemPedido> r = new ArrayList(pedido.getItems().stream()
                .filter(funcionLambda)
                .collect(Collectors.toList()));
        if(r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condicion");
        else return r;
    }
    @Override
    public ArrayList<ItemPedido> ordenarPedido(Pedido pedido, Comparator comparador){
        ArrayList<ItemPedido> r = new ArrayList(pedido.getItems().stream()
                .sorted(comparador)
                .toList());
        return r;
    }
    @Override
    public ArrayList<ItemPedido> rangoPrecios(Pedido pedido, float precioInferior, float precioSuperior) throws ItemNoEncontradoException{
        ArrayList<ItemPedido> r = new ArrayList(pedido.getItems().stream()
                .filter((i)->i.getItem().getPrecio()>=precioInferior && i.getItem().getPrecio()<=precioSuperior)
                .collect(Collectors.toList()));
        if(r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condicion");
        else return r;
    }
    @Override
    public ArrayList<ItemPedido> filtrarPorRestaurante(Pedido pedido, String nombre) throws ItemNoEncontradoException{
        ArrayList<ItemPedido> r = new ArrayList(pedido.getItems().stream()
                .filter((i)->i.getItem().getVendedor().getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList()));
        if(r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condicion");
        else return r;
    }
}
