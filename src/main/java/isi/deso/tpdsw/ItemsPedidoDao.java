package isi.deso.tpdsw;
import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public interface ItemsPedidoDao {
    public ArrayList<ItemMenu> filtrarPedido(ArrayList<ItemMenu> items, Predicate funcionLambda);
    public ArrayList<ItemMenu> ordenarPedido(ArrayList<ItemMenu> items, BiPredicate funcionLambda);
    public ArrayList<ItemMenu> rangoPrecios(float precioInferior, float precioSuperior);
    public ArrayList<ItemMenu> filtrarPorRestaurante(Vendedor vend);
}
    