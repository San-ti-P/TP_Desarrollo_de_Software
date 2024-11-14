package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Models.ItemPedido;
import java.util.Comparator;
import java.util.TreeMap;

public class ComparatorFactory {
    private TreeMap<String, Integer> tipos = new TreeMap();
    
    public ComparatorFactory(){
        tipos.put("nombre", 0);
        tipos.put("categoria", 1);
    }
   
    public Comparator<ItemPedido> obtenerPredicado(String arg, String sentido){
        String s = sentido.toLowerCase();
        switch(tipos.get(arg.toLowerCase().strip())){
            case 0 -> {
                return (s.equals("asc"))?Comparator.comparing((ItemPedido item) -> item.getItem().getNombre()):Comparator.comparing((ItemPedido item) -> item.getItem().getNombre()).reversed();
            }
            case 1 -> {   
                return (s.equals("asc"))?Comparator.comparing((ItemPedido item) -> item.getItem().getCategoria().getId()):Comparator.comparing((ItemPedido item) -> item.getItem().getCategoria().getId()).reversed();
            }
        }
        return null;
    }
    
}
