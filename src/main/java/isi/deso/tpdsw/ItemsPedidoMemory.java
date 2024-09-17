package isi.deso.tpdsw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//res=lista.copy()
//for(Predicate c: condiciones){
//res=A.filtrarPedido(res, c);
//}

public class ItemsPedidoMemory implements ItemsPedidoDao {
    @Override
    public ArrayList<ItemMenu> filtrarPedido(ArrayList<ItemMenu> items, Predicate funcionLambda) throws ItemNoEncontradoException{
        ArrayList<ItemMenu> r=(ArrayList<ItemMenu>)items.stream()
                .filter(funcionLambda)
                .collect(Collectors.toList());
        if(r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condición");
        else return r;
    }
    @Override
    public ArrayList<ItemMenu> ordenarPedido(ArrayList<ItemMenu> items, Comparator comparador){
        return (ArrayList<ItemMenu>)items.stream()
                .sorted(comparador)
                .toList();
    }
    @Override
    public ArrayList<ItemMenu> rangoPrecios(ArrayList<ItemMenu> items, float precioInferior, float precioSuperior) throws ItemNoEncontradoException{
        ArrayList<ItemMenu> r=(ArrayList<ItemMenu>)items.stream()
                .filter((i)->i.getPrecio()>=precioInferior && i.getPrecio()<=precioSuperior)
                .collect(Collectors.toList());
        if(r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condición");
        else return r;
    }
    @Override
    public ArrayList<ItemMenu> filtrarPorRestaurante(ArrayList<ItemMenu> items, String nombre) throws ItemNoEncontradoException{
        ArrayList<ItemMenu> r=(ArrayList<ItemMenu>)items.stream()
                .filter((i)->i.getVendedor().getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
        if(r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condición");
        else return r;
    }
}
