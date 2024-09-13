package isi.deso.tpdsw;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ItemsPedidoMemory implements ItemsPedidoDao {
    
    public ArrayList<ItemMenu> filtrarPedido(ArrayList<ItemMenu> items, Predicate funcionLambda) {
        System.out.println(""); 
        return null;
    }
    public ArrayList<ItemMenu> ordenarPedido(ArrayList<ItemMenu> items, BiPredicate funcionLambda){
        System.out.println("");
        return null;
    }
    public ArrayList<ItemMenu> rangoPrecios(float precioInferior, float precioSuperior){
        System.out.println("");
        return null;
    }
    public ArrayList<ItemMenu> filtrarPorRestaurante(Vendedor vend){
        System.out.println("");
        return null;
    }
    
}
