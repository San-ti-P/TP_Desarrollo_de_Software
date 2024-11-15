package isi.deso.tpdsw.Daos;
import isi.deso.tpdsw.Services.ItemNoEncontradoException;
import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Models.ItemPedido;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public interface ItemsPedidoDao {
    public ArrayList<ItemPedido> getAll();
    
    public ArrayList<ItemPedido> filtrarPedido(Pedido pedido, Predicate<ItemPedido> funcionLambda) throws ItemNoEncontradoException;
    public ArrayList<ItemPedido> ordenarPedido(Pedido pedido, Comparator comparador);
    public ArrayList<ItemPedido> rangoPrecios(Pedido pedido, float precioInferior, float precioSuperior) throws ItemNoEncontradoException;
    public ArrayList<ItemPedido> filtrarPorRestaurante(Pedido pedido, String nombre) throws ItemNoEncontradoException;
}
    