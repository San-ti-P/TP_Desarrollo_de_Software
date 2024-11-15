package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Services.ItemNoEncontradoException;
import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Models.ItemPedido;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ItemsPedidoMemory implements ItemsPedidoDao {
    private ArrayList<ItemPedido> itemsPedido;

    public ItemsPedidoMemory() {
        itemsPedido = new ArrayList<>();
        // Agregar datos de prueba
        Pedido pedido1 = new Pedido(1, null, new ArrayList<>(), null, null);
        Pedido pedido2 = new Pedido(2, null, new ArrayList<>(), null, null);
        itemsPedido.add(new ItemPedido(null, 2, pedido1));
        itemsPedido.add(new ItemPedido(null, 3, pedido2));
    }

    @Override
    public ArrayList<ItemPedido> getAll() {
        return new ArrayList<>(itemsPedido);
    }


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
