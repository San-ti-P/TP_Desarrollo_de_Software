package isi.deso.tpdsw;

import java.util.TreeMap;
import java.util.function.Predicate;

public class PredicateFactory {
    private TreeMap<String, Integer> tipos = new TreeMap();
    
    public PredicateFactory(){
        tipos.put("id", 0);
        tipos.put("nombre", 1);
        tipos.put("aptovegano", 2);
        tipos.put("categoria", 3);
    }
   
    public Predicate<ItemPedido> obtenerPredicado(String arg, String valor){
        String val = valor.toLowerCase();
        switch(tipos.get(arg.toLowerCase().strip())){
            case 0 -> {
                return (a) -> a.getItem().getId().toLowerCase().equals(val);
            }
            case 1 -> {   
                return (a) -> a.getItem().getNombre().toLowerCase().equals(val);
            }
            case 2 -> {
                return (a) -> a.getItem().getAptoVegano()==(Boolean.parseBoolean(val));
            }
            case 3 -> {
                return (a) -> a.getItem().getCategoria().getDescripcion().toLowerCase().equals(val);
            }
        }
        return null;
    }
    
}
