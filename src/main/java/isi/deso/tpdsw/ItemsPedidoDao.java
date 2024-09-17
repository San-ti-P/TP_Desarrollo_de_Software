package isi.deso.tpdsw;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public interface ItemsPedidoDao {
    public ArrayList<ItemMenu> filtrarPedido(ArrayList<ItemMenu> items, Predicate funcionLambda) throws ItemNoEncontradoException;
    public ArrayList<ItemMenu> ordenarPedido(ArrayList<ItemMenu> items, Comparator comparador);
    public ArrayList<ItemMenu> rangoPrecios(ArrayList<ItemMenu> items, float precioInferior, float precioSuperior) throws ItemNoEncontradoException;
    public ArrayList<ItemMenu> filtrarPorRestaurante(ArrayList<ItemMenu> items, String nombre) throws ItemNoEncontradoException;
}
    