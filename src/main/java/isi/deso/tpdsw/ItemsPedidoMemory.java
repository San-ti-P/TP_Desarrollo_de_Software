package isi.deso.tpdsw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ItemsPedidoMemory implements ItemsPedidoDao {
    @Override
    public ArrayList<ItemMenu> filtrarPedido(Pedido pedido, Predicate<ItemMenu> funcionLambda) throws ItemNoEncontradoException{
        ArrayList<ItemMenu> r = new ArrayList(pedido.getItems().stream()
                .map(i -> i.getItem())
                .filter(funcionLambda)
                .collect(Collectors.toList()));
        if(r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condición");
        else return r;
    }
    @Override
    public ArrayList<ItemMenu> ordenarPedido(Pedido pedido, Comparator comparador){
        ArrayList<ItemMenu> r = new ArrayList(pedido.getItems().stream()
                .map(i -> i.getItem())
                .sorted(comparador)
                .toList());
        return r;
    }
    @Override
    public ArrayList<ItemMenu> rangoPrecios(Pedido pedido, float precioInferior, float precioSuperior) throws ItemNoEncontradoException{
        ArrayList<ItemMenu> r = new ArrayList(pedido.getItems().stream()
                .map(i -> i.getItem())
                .filter((i)->i.getPrecio()>=precioInferior && i.getPrecio()<=precioSuperior)
                .collect(Collectors.toList()));
        if(r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condición");
        else return r;
    }
    @Override
    public ArrayList<ItemMenu> filtrarPorRestaurante(Pedido pedido, String nombre) throws ItemNoEncontradoException{
        ArrayList<ItemMenu> r = new ArrayList(pedido.getItems().stream()
                .map(i -> i.getItem())
                .filter((i)->i.getVendedor().getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList()));
        if(r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condición");
        else return r;
    }
}
