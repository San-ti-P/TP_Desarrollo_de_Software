package isi.deso.tpdsw;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public interface ItemsPedidoDao {
    public ArrayList<ItemMenu> filtrarPedido(Pedido pedido, Predicate<ItemMenu> funcionLambda) throws ItemNoEncontradoException;
    public ArrayList<ItemMenu> ordenarPedido(Pedido pedido, Comparator comparador);
    public ArrayList<ItemMenu> rangoPrecios(Pedido pedido, float precioInferior, float precioSuperior) throws ItemNoEncontradoException;
    public ArrayList<ItemMenu> filtrarPorRestaurante(Pedido pedido, String nombre) throws ItemNoEncontradoException;
}
    